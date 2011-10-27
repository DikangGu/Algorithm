package com.dikang.algorithm.poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1001 {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        BigDecimal num;

        int n;

        String r;

        while(cin.hasNextBigDecimal()){

            num = cin.nextBigDecimal();
            n = cin.nextInt();

            num = num.pow(n);

            r = num.stripTrailingZeros().toPlainString();

            if(r.startsWith("0.")){

                r = r.substring(1);
            }

            System.out.println(r);
        }
    }
}
