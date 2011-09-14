/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 504.5 -> DivII 500
 *
 *
 *                      0
 *                     / \
 *                    4   7
 *                   / \ / \
 *                  8   11  14
 *                 / \ / \
 *                12  15 18
 *               / \ / \
 *              16  19 22
 *             / \ / \
 *            20 23 26
 *           / \ / \
 *          24  27 30
 *
 */
public class TheNumbersWithLuckyLastDigit {

    private int[] times = new int[10];
    private int[] mins = new int[10];

    private void construct() {
        times[0] = 5;
        mins[0] = 20;

        times[1] = 2;
        mins[1] = 11;

        times[2] = 3;
        mins[2] = 12;

        times[3] = 5;
        mins[3] = 23;

        times[4] = 1;
        mins[4] = 4;

        times[5] = 3;
        mins[5] = 15;

        times[6] = 4;
        mins[6] = 16;

        times[7] = 1;
        mins[7] = 7;

        times[8] = 2;
        mins[8] = 8;

        times[9] = 4;
        mins[9] = 19;
    }

    public int find(int n) {

        construct();

        int last = n % 10;
        if (n >= mins[last]) {
            return times[last];
        }

        return -1;
    }

    public static void main(String[] argv) {
        TheNumbersWithLuckyLastDigit theNumbersWithLuckyLastDigit =
                new TheNumbersWithLuckyLastDigit();

        System.out.println(theNumbersWithLuckyLastDigit.find(99));
        System.out.println(theNumbersWithLuckyLastDigit.find(11));
        System.out.println(theNumbersWithLuckyLastDigit.find(13));
        System.out.println(theNumbersWithLuckyLastDigit.find(1234567));
    }
}
