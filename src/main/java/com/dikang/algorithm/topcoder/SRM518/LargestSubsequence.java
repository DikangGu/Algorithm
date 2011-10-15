package com.dikang.algorithm.topcoder.SRM518;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class LargestSubsequence {

    public String getLargest(String s)
	{
        String result = "";
        int len = s.length();
        int index = 0;

        while (index < len) {

            char max = s.charAt(index);
            int tmp = index;
            for (int i=index + 1; i<len; i++) {
                if (max < s.charAt(i)) {
                    max = s.charAt(i);
                    tmp = i;
                }
            }
            result += String.valueOf(s.charAt(tmp));
            index = tmp + 1;

        }

        return result;
	}

    public static void main(String[] args) {
        LargestSubsequence sequence = new LargestSubsequence();
        System.out.println(sequence.getLargest("topcoder"));
    }
}
