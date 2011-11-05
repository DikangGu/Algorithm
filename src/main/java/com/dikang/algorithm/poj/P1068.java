package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1068 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int no = sc.nextInt();

        int[] s = new int[41];

        for (int k=0; k<no; k++) {

            int n = sc.nextInt();
            for (int i=0; i<n; i++) {

                int p=2+i*2,d=p-1;
                s[p] = sc.nextInt();
                s[p-1]=s[p]-s[p-2];
                while(s[d] == 0) d-=2;
                s[d]--;
                System.out.format("%d ",i-d/2+1);
            }

            System.out.println();
        }
    }
}
