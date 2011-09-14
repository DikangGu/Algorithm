package com.dikang.algorithm.facebook.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * TestInput:
1250
LJS93K 1300 10500
J38ZZ9 700 4750
HJ394L 200 3250
O1IE82 75 10250

 TestOutput:
 9500
 *
 */
public class UserBinCash {

    public static class Good implements Comparable<Good> {

        public String label;
        public int pounds;
        public int value;

        public Good(String label, int pounds, int value) {
            this.label = label;
            this.pounds = pounds;
            this.value = value;
        }

        @Override
        public int compareTo(Good good) {

            double t1 = (double )value / (double ) pounds;
            double t2 = (double )good.value / (double )good.pounds;

            if (t1 == t2) return 0;
            if (t1 < t2) return -1;
            return 1;
        }

        @Override
        public String toString() {
            return label + ", " + pounds + ", " + value;
        }
    }

    public int pounds;
    public Good[] goods;

    public int minCost() {

        Arrays.sort(goods);

        int remain = pounds;
        int lost = 0;

        for (int i=0; i<goods.length; i++) {
            System.out.println(goods[i]);

            if (remain <=0) break;

            if (goods[i].pounds <= remain) {
                remain -= goods[i].pounds;
                lost += goods[i].value;
            }
        }

        return lost;
    }

    public int dpSolution(int n, int m) {
        int[][] result = new int[n][m+1];

        result[0][0] = 0;
        for (int i=0; i<n; i++) {
            for (int j=1; j<=m; j++) {
                result[i][j] = Integer.MAX_VALUE;

                for (int k=0; k<=m; k++) {
                    if (j-k*goods[i].pounds <=0) {
                        result[i][j] = Math.min(result[i][j], k*goods[i].value);
                        break;
                    } else {
                        if (i>=1) {
                            result[i][j] = Math.min(result[i][j],
                                    result[i-1][j-k*goods[i].pounds] + k*goods[i].value);
                        }
                    }
                }
            }
        }

        return result[n-1][m];
    }


    public static void main(String[] args) throws IOException {

        UserBinCash userBinCash = new UserBinCash();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = reader.readLine();

            userBinCash.pounds = Integer.valueOf(line);

            line = reader.readLine();
            List<Good> goods = new ArrayList<Good>();
            while (null != line && !line.equals("")) {
                String[] parts = line.split(" ");
                Good good = new Good(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2]));
                goods.add(good);
                line = reader.readLine();
            }

            userBinCash.goods = goods.toArray(new Good[] {});
        } finally {
            reader.close();
        }

        System.out.println(userBinCash.minCost());
        System.out.println(userBinCash.dpSolution(userBinCash.goods.length, userBinCash.pounds));
    }
}
