package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        for (int i=0; i<12; i++) {
            double value = scanner.nextDouble();
            total += value;
        }

        double result = total/12;
        System.out.println(String.format("$%.2f", result));
    }
}
