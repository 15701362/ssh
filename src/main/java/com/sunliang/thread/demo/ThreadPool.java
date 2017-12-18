package com.sunliang.thread.demo;


import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunliang
 * @desc 线程池
 * @create 2017-12-15 12:24
 **/
public final class ThreadPool {
    private static Logger logger = Logger.getLogger(ThreadPool.class);
    private static Logger taskLogger = Logger.getLogger("TaskLogger");

    private static boolean debug = taskLogger.isDebugEnabled();

    /** 单例 */
    private static ThreadPool instance = ThreadPool.getInstance();

    public static final int SYSTEM_BUSY_TASK_COUNT = 150;

    /** 默认池中线程数 */
    public static int worker_num = 5;
    /** 已经处理的任务数 */
    private static int taskCounter = 0;

    private static List<Task> taskQueue = Collections.synchronizedList(new LinkedList<Task>());
    /** 池中的全部线程 */
    public PoolWorker[] workers;

    private ThreadPool() {
        workers = new PoolWorker[worker_num];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new PoolWorker(i);
        }
    }

    /**
     * 添加新的任务
     * 每添加一个新任务。都要唤醒任务队列
     * @param newTask
     */
    public void addTask(Task newTask) {
        synchronized (taskQueue) {
            newTask.setTaskId(++taskCounter);
            newTask.setSubmitTime(new Date());
            taskQueue.add(newTask);
            /* 唤醒队列, 開始运行 */
            taskQueue.notifyAll();
        }
        logger.info("Submit Task<" + newTask.getTaskId() + ">: "
                + newTask.info());
    }
    /**
     * 批量添加新任务
     * @param taskes
     */
    public void batchAddTask(Task[] taskes) {
        if (taskes == null || taskes.length == 0) {
            return;
        }
        synchronized (taskQueue) {
            for (int i = 0; i < taskes.length; i++) {
                if (taskes[i] == null) {
                    continue;
                }
                taskes[i].setTaskId(++taskCounter);
                taskes[i].setSubmitTime(new Date());
                taskQueue.add(taskes[i]);
            }
            /* 唤醒队列, 開始运行 */
            taskQueue.notifyAll();
        }
        for (int i = 0; i < taskes.length; i++) {
            if (taskes[i] == null) {
                continue;
            }
            logger.info("Submit Task<" + taskes[i].getTaskId() + ">: "
                    + taskes[i].info());
        }
    }
    /**
     * 线程池信息
     * @return
     */
    public String getInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("\nTask Queue Size:" + taskQueue.size());
        for (int i = 0; i < workers.length; i++) {
            sb.append("\nWorker " + i + " is "
                    + ((workers[i].isWaiting()) ? "Waiting." : "Running."));
        }
        return sb.toString();
    }
    /**
     * 销毁线程池
     */
    public synchronized void destroy() {
        for (int i = 0; i < worker_num; i++) {
            workers[i].stopWorker();
            workers[i] = null;
        }
        taskQueue.clear();
    }

    public static synchronized ThreadPool getInstance() {
        if (instance == null) {
            return new ThreadPool();
        }
        return instance;
    }

    /**
     * 池中工作线程
     *
     * @author obullxl
     */
    private class PoolWorker extends Thread {
        private int index = -1;
        /** 该工作线程是否有效 */
        private boolean isRunning = true;
        /** 该工作线程能否够运行新任务 */
        private boolean isWaiting = true;

        public PoolWorker(int index) {
            this.index = index;
            start();
        }

        public void stopWorker() {
            this.isRunning = false;
        }

        public boolean isWaiting() {
            return this.isWaiting;
        }
        /**
         * 循环运行任务
         * 这或许是线程池的关键所在
         */
        @Override
        public void run() {
            while (isRunning) {
                Task r = null;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            /* 任务队列为空，则等待有新任务增加从而被唤醒 */
                            taskQueue.wait(20);
                        } catch (InterruptedException ie) {
                            logger.error(ie);
                        }
                    }
                    /* 取出任务运行 */
                    r = taskQueue.remove(0);
                }
                if (r != null) {
                    isWaiting = false;
                    try {
                        if (debug) {
                            r.setBeginExceuteTime(new Date());
                            taskLogger.debug("Worker<" + index
                                    + "> start execute Task<" + r.getTaskId() + ">");
                            if (r.getBeginExceuteTime().getTime()
                                    - r.getSubmitTime().getTime() > 1000) {
                                taskLogger.debug("longer waiting time. "
                                        + r.info() + ",<" + index + ">,time:"
                                        + (r.getFinishTime().getTime() - r
                                        .getBeginExceuteTime().getTime()));
                            }
                        }
                        /** 该任务是否须要马上运行 */
                        if (r.needExecuteImmediate()) {
                            new Thread(r).start();
                        } else {
                            r.run();
                        }
                        if (debug) {
                            r.setFinishTime(new Date());
                            taskLogger.debug("Worker<" + index
                                    + "> finish task<" + r.getTaskId() + ">");
                            if (r.getFinishTime().getTime()
                                    - r.getBeginExceuteTime().getTime() > 1000) {
                                taskLogger.debug("longer execution time. "
                                        + r.info() + ",<" + index + ">,time:"
                                        + (r.getFinishTime().getTime() - r
                                        .getBeginExceuteTime().getTime()));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(e);
                    }
                    isWaiting = true;
                    r = null;
                }
            }
        }
    }
}
