/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 510 > DIVII 500
 */
public class TheLuckyGameDivTwo {

    private boolean[] isLuckyNum;
    private int[][] luckNums;

    private boolean checkLuckNum(int num) {
        int t;
        while (num>0) {
            t = num % 10;
            if (t!= 4 && t!=7) {
                return false;
            }
            num /= 10;
        }

        return true;
    }

    public int find(int a, int b, int jLen, int bLen) {

        isLuckyNum = new boolean[b+1];
        luckNums = new int[b+1][b+1];

        for (int i=a; i<=b; i++) {
            isLuckyNum[i] = checkLuckNum(i);
        }

        for (int i=a; i<b; i++) {
            luckNums[i][i] = isLuckyNum[i] ? 1 : 0;
            for (int j=i+1; j<=b; j++) {
                if (isLuckyNum[j]) {
                    luckNums[i][j] = luckNums[i][j-1] + 1;
                } else {
                    luckNums[i][j] = luckNums[i][j-1];
                }
            }
        }

        int left;
        int right;

        int result = 0;

        for (left = a; left+jLen - 1<= b; left ++) {
            right = left + jLen -1;
            int min = luckNums[left][right];
            for (int bleft = left; bleft + bLen - 1 <=right; bleft ++) {
                int bright = bleft + bLen -1;

                if (min > luckNums[bleft][bright]) {
                    min = luckNums[bleft][bright];
                }
            }

            if (result < min) {
                result = min;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TheLuckyGameDivTwo theLuckyGameDivTwo = new TheLuckyGameDivTwo();
        System.out.println(theLuckyGameDivTwo.find(1, 10, 2, 1));
        System.out.println(theLuckyGameDivTwo.find(1, 100, 100, 100));
        System.out.println(theLuckyGameDivTwo.find(4, 8, 3, 2));
    }
}
