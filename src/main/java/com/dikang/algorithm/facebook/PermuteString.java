import java.util.Arrays;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class PermuteString {

    public void printSimplePermute(char[] str, int d) {
        if (d == str.length) {
            System.out.println(str);
            return;
        }

        for (int i=d; i<str.length; i++) {

            char t = str[i];
            str[i] = str[d];
            str[d] = t;

            printSimplePermute(str, d + 1);

            t = str[i];
            str[i] = str[d];
            str[d] = t;
        }
    }

    public void printPermute(char[] str) {
        Arrays.sort(str);

        while (true) {
            System.out.println(str);
            int frontPos = -1;
            for (int i=str.length - 2; i>=0; i--) {
                if (str[i] < str[i+1]) {
                    frontPos = i;
                    break;
                }
            }

            if (frontPos == -1) {
                break;
            }

            int endPos = -1;
            for (int i=str.length - 1; i>=0; i--) {
                if (str[i] > str[frontPos]) {
                    endPos = i;
                    break;
                }
            }

            char t = str[frontPos];
            str[frontPos] = str[endPos];
            str[endPos] = t;

            int i = frontPos + 1;
            int j = str.length - 1;
            while (i<j) {
                t = str[i];
                str[i] = str[j];
                str[j] = t;

                i++;
                j--;
            }
        }

    }

    public void printNotDuplicatePermute(char[] str, int d) {
        /*if (d == str.length) {
            System.out.println(str);
            return;
        }

        //char lastSwp = ' ';
        for (int i=d; i<str.length; i++) {

            *//*if (lastSwp == str[i]) {
                continue;
            } else {
                lastSwp = str[i];
            }*//*
            boolean duplicated = false;
            for (int j=d; j<i; j++) {
                if (str[j] == str[i]){
                    duplicated = true;
                    break;
                }
            }

            if (duplicated)
                continue;

            char t = str[i];
            str[i] = str[d];
            str[d] = t;

            printSimplePermute(str, d + 1);

            t = str[i];
            str[i] = str[d];
            str[d] = t;
        }*/
    }

    public static void main(String[] args) {
        //new PermuteString().printSimplePermute("abc".toCharArray(), 0);
        //new PermuteString().printNotDuplicatePermute("aabb".toCharArray(), 0);
        new PermuteString().printPermute("abc".toCharArray());
        new PermuteString().printPermute("aabb".toCharArray());
    }

}
