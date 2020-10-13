package com.by.basic;

public class ArrayDemo {
    public static void main(String[] args) {
        // 定义一维数组
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[5];
        // 写了大括号初始化，方括号就不能再写大小了
        int[] arr3 = new int[]{1, 2, 3, 4, 5};

        // 也可以写成这样
        int arr4[];
        int arr5[] = new int[5];

        // 定义二维数组
        int[][] b1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] b2 = new int[3][4];
        int[][] b3 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        /**
         * 数组的属性：
         *      length：数组的长度，是属性，不是函数！
         */
        System.out.println(arr1.length);

        /**
         * for each 遍历数组
         */
        for(int m : arr1) {
            System.out.println(m);
        }
    }
}
