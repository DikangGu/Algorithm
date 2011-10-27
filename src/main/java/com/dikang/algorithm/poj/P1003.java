package com.dikang.algorithm.poj;


/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * Sample Input
 *
1.00
3.71
0.04
5.19
0.00

 Sample Output
 3 card(s)
61 card(s)
1 card(s)
273 card(s)
 *
 */

import java.util.*;

public class P1003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double len = sc.nextDouble();
        while (len !=0) {

            double n = 1;
            double thelen = 1.0/(n+1);
            while (thelen < len) {
                n++;
                thelen += 1.0/(n+1);
            }

            System.out.println((int)n + " card(s)");

            len = sc.nextDouble();
        }
    }
}
