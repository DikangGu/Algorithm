package com.dikang.algorithm.topcoder.SRM515;

import java.util.HashSet;
import java.util.Set;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 515 -> DIV II -> 250.
 */
public class FortunateNumbers {

    private Set<Integer> set = new HashSet<Integer>();

    private boolean isFortunate(int num) {
        while(num >0) {
            int a = num % 10;
            if (a !=8 && a != 5) {
                return false;
            }

            num = num / 10;
        }

        return true;
    }

    public int getFortunate(int[] a, int[] b, int[] c)
	{
        for (int numA : a) {
            for (int numB : b) {
                for (int numC : c) {

                    int num = numA + numB + numC;
                    if (isFortunate(num)) {
                        set.add(num);
                    }
                }
            }
        }

	    return set.size();
	}
}
