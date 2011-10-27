package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1006 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = 1;
        while(true){
            int p = cin.nextInt();
            int e = cin.nextInt();
            int i = cin.nextInt();
            int d = cin.nextInt();
            if(p==e && p==i && p==d && p==-1){
                break;
            }

            int r = (5544*p+14421*e+1288*i-d+21252)%(23*28*33);

            if(r==0)
                r = 23*28*33;
            System.out.println("Case "+num+": the next triple peak occurs in "+r+" days.");
            num++;
        }

    }
}
