package com.sunliang.thread.demo;

import java.util.Date;

/**
 * @author sunliang
 * @desc 全部任务接口
 * @create 2017-12-15 12:42
 **/
public abstract class Task implements Runnable {
    /** 产生时间 */
    private Date generateTime = null;
    /** 提交运行时间 */
    private Date submitTime = null;
    /** 开始运行时间 */
    private Date beginExceuteTime = null;
    /** 运行完毕时间 */
    private Date finishTime = null;

    private long taskId;

    public Task() {
        this.generateTime = new Date();
    }

    /**
     * 任务运行入口
     */
    @Override
    public void run() {
        /**
         * 相关运行代码
         *
         * beginTransaction();
         *
         * 运行过程中可能产生新的任务 subtask = taskCore();
         *
         * commitTransaction();
         *
         * 添加新产生的任务 ThreadPool.getInstance().batchAddTask(taskCore());
         */
    }

    /**
     * 全部任务的核心 所以特别的业务逻辑运行之处
     *
     * @throws Exception
     */
    public abstract Task[] taskCore() throws Exception;

    /**
     * 是否用到数据库
     *
     * @return
     */
    protected abstract boolean useDb();

    /**
     * 是否须要马上运行
     *
     * @return
     */
    protected abstract boolean needExecuteImmediate();

    /**
     * 任务信息
     *
     * @return String
     */
    public abstract String info();

    public Date getGenerateTime() {
        return generateTime;
    }

    public Date getBeginExceuteTime() {
        return beginExceuteTime;
    }

    public void setBeginExceuteTime(Date beginExceuteTime) {
        this.beginExceuteTime = beginExceuteTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

}
