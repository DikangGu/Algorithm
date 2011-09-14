package com.dikang.algorithm.facebook.dp;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class LongestCommonString {

    public int LCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int [][]result = new int[len1+1][len2+1];
        result[0][0] = 0;

        for (int i=1; i<=len1;i++) {
            for (int j=1; j<=len2; j++) {

                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    result[i][j] = result[i-1][j-1] + 1;
                } else {
                    result[i][j] = Math.max(result[i][j-1], result[i-1][j]);
                }
            }
        }

        return result[len1][len2];
    }

    public static void main(String[] args){
        LongestCommonString lcs = new LongestCommonString();
        System.out.println(lcs.LCS("abcdab", "cabdcb"));
    }
}
