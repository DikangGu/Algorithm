package com.dikang.algorithm.topcoder.SRM518;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class TwiceString {

    public String getShortest(String s) {
        int len = s.length();
        int i;
        for (i=1; i<len; i++) {
            boolean equal = true;
            for (int j=0; j <len-i; j++) {
                if (s.charAt(j+i) != s.charAt(j)) {
                    equal = false;
                    break;
                }
            }
            if (equal)
                break;
        }

        String result = "";
        if (i == len)
            result = s + s;
        else
            result = s + s.substring(len - i);

        return result;

    }

    public static void main(String[] args) {
        TwiceString twiceString = new TwiceString();
        System.out.println(twiceString.getShortest("s"));
    }
}
