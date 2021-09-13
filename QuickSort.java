package com.xiawei.algorithms;

import java.util.Arrays;

/*
  快速排序:冒泡+分治+递归
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        System.out.println(Arrays.toString(arr));
        //快速排序
        quickSrot(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSrot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSrot(arr, low, high);
    }

    private static void quickSrot(int[] arr, int low, int high) {
        //递归结束，low和high是同一个数递归结束
        if (low < high) {
            //分区操作，返回分区界限的索引
            int index = partition(arr, low, high);
            //对左分区快排
            quickSrot(arr, low, index - 1);
            //对右分区快排
            quickSrot(arr, index + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        //制定左指针和右指针
        int i = low;
        int j = high;

        //将第一个数作为基准值，挖坑
        int x = arr[i];

        //实现分区
        while (i < j) {
            //1.从右向左移动j，找到第一个小于基准值的arr[j]
            while (arr[j] >= x && i < j) {
                j--;
            }
            //2.将右侧找到小于基准值的数加入到左边（坑）位置，左指针向中间移动一个位置i++
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //3.从左向右移动i，找到第一个大于基准值的arr[i]
            while (arr[i] < x && i < j) {
                i++;
            }
            //4.将左侧找到大于基准值的数加入到右边（坑）位置，右指针向中间移动一个位置j--
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        //使用基准值填坑
        arr[i] = x;

        //返回索引
        return i;
    }
}








