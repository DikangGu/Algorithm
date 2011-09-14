package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class P1009 {

    static int[][] IN = new int[1005][2];
    static Ref[] OUT = new Ref[8000];

    public static class Ref {
        public int index;
        public int code;

        public Ref() {

        }

        public Ref(int index, int code) {
            this.index = index;
            this.code = code;
        }
    }

    public static void main(String[] args) {

        int width, i, j, m, n, t, k, cnt, total, current, row, col;
        Ref cur;
        Scanner scanner = new Scanner(System.in);


        while ((width = scanner.nextInt())!=0) {

            i = total = 0;
            do {
                IN[i][0] = scanner.nextInt();
                IN[i][1] = scanner.nextInt();
                total += IN[i][1];
                i++;
            } while (IN[i-1][0] != 0 && IN[i-1][1] != 0);

            System.out.println(width);
            i--;
            cnt = i;
            n = 1;
            k = 0;

            for (m=0; m<=cnt; m++) {
                row = (n-1) / width;
                col = (n-1) % width;

                for (i=row-1; i<=row+1; i++) {
                    for (j=col-1; j<=col+1; j++) {
                        t = i*width + j;
                        if (i<0 || j<0 || j>width-1 || t>total-1)
                            continue;

                        OUT[k] = new Ref(t+1, encode(t+1, width, total));
                        k++;
                    }
                }
                n += IN[m][1];
            }

            sort(OUT, k);

            cur = OUT[0];
            for (i=0; i<k; i++) {
                if (OUT[i].code == cur.code)
                    continue;

                System.out.println(cur.code + " " + (OUT[i].index - cur.index));
                cur = OUT[i];
            }

            System.out.println(cur.code + " " + (total - cur.index + 1));
            System.out.println("0 0");
        }
        System.out.println("0");
    }

    private static void sort(Ref[] out, int n) {
        Ref tmp;
        int i, j;
        for (i=0; i<n-1; i++) {
            for (j=i+1; j<n; j++) {
                if (out[i].index > out[j].index) {
                    tmp = out[i];
                    out[i] = out[j];
                    out[j] = tmp;
                }
            }
        }
    }

    private static int encode(int n, int width, int total) {
        int i,j,t, code, result, row, col;

        code = getCode(n);

        row = (n-1)/width;
        col = (n-1) % width;

        result = 0;

        for (i=row-1; i<=row +1; i++) {
            for (j=col-1; j<=col+1; j++) {
                t = i*width + j;
                if (i<0 || j<0 || j>width-1 || t == n-1 || t>total-1)
                    continue;

                if (Math.abs(getCode(t+1) - code) > result)
                    result = Math.abs(getCode(t+1) - code);
            }
        }

        return result;
    }

    private static int getCode(int n) {
        int t, i;
        i = 0;
        t = 0;
        while(t<n) {
            t += IN[i++][1];
        }
        return IN[i-1][0];
    }
}
