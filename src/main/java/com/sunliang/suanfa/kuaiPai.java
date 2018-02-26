package com.sunliang.suanfa;

/**
 * @author sunliang
 * @desc 快速排序
 * @create 2017-12-18 16:41
 **/
public class kuaiPai {
    static final int SIZE = 18;

    // 快速排序和冒泡排序思想相似，都是基于交换排序思想的。快速排序对冒泡排序法进行了改进，从而具有更高的执行效率额。
    /*
     * 快速排序算法通过多次比较和交互来实现排序，其排序流程如下：
     * 1，首先定义一个分界值，通过该分界值将数组分为左右两部分。
     *
	 * 2，将大于分界值的数据集中到数组右边,小于分界值的数据集中到数组的左边。
	 * 此时，左边部分中各元素都小于等于分界值，
	 * 而右边部分中各元素都大于等于分界值。
	 *
	 * 3，然后，左边和右边的数据可以独立排序.对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样将左边放置最小值，右边放置最大值。
	 * 右边的数组数据也可以做类似处理。
	 *
	 * 4，重复伤处过程，可以看出这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左右两个部分排序完成后,
	 * 整个数组的排序也就完成了。
	 */

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    static void quickSort(int[] arr, int left, int right) // 快速排序算法
    {
        int f, t;// f 为分界值，t是保存元素交互过程中的临时变量
        int rtemp, ltemp;

        ltemp = left;
        rtemp = right;
        // 分界值
        f = arr[(left + right) / 2];
        while (ltemp < rtemp) {
            while (arr[ltemp] < f) {
                ++ltemp;
            }
            while (arr[rtemp] > f) {
                --rtemp;
            }
            if (ltemp <= rtemp) {
                t = arr[ltemp];
                arr[ltemp] = arr[rtemp];
                arr[rtemp] = t;
                --rtemp;
                ++ltemp;
            }
        }
        if (ltemp == rtemp) {
            ltemp++;
        }

        if (left < rtemp) {
            // 递归调用
            quickSort(arr, left, ltemp - 1);
        }
        if (ltemp < right) {
            // 递归调用
            quickSort(arr, rtemp + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] shuzu = new int[SIZE];
        int i;

        for (i = 0; i < SIZE; i++) {
            // 初始化数组
            shuzu[i] = (int) (100 + Math.random() * (100 + 1));
        }
        // 输出排序前的数组
        System.out.print("排序前的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");
        // 排序操作
        quickSort(shuzu, 0, SIZE - 1);

        System.out.print("排序后的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            // 输出排序后的数组
            System.out.print(shuzu[i] + " ");
        }
        System.out.print("\n");

    }

}
