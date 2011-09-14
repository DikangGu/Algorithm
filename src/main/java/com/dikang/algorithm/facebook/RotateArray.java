package com.dikang.algorithm.facebook;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class RotateArray {

    public int getDestination(int n, int r, int i) {
        return (i+r) % n;
    }

    public void rotate(int[] array, int r) {
        int index = 0;
        int pre = array[0];
        int n = array.length;
        int des = getDestination(n, r, index);

        while (des != 0) {
            int t = array[des];
            array[des] = pre;
            pre = t;

            des = getDestination(n, r, des);
        }
        array[0] = pre;
    }

    public static void main(String[] args) {
        int [] array = new int[] {1, 2, 3 ,4 ,5};

        new RotateArray().rotate(array, 1);

        for (int item : array) {
            System.out.print(item + ",");
        }
    }
}
