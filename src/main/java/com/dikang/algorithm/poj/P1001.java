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

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            double R = scanner.nextDouble();
            int n = scanner.nextInt();

            BigDecimal bigDecimal = new BigDecimal(R);
            bigDecimal.setScale(10, BigDecimal.ROUND_HALF_UP);
            String result = bigDecimal.pow(n).toPlainString();

            int i =0;
            for (; i<result.length(); i++) {
                if (result.charAt(i)!='0')
                    break;
            }

            if (i>0) {
                result = result.substring(i);
            }



            System.out.println(result);
        }

    }
}
