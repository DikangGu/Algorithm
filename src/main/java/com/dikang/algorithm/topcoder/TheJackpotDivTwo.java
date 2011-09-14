import java.util.Arrays;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 504.5 -> DivII 250
 */

public class TheJackpotDivTwo {

    public int[] find(int[] money, int jackpot) {

        Arrays.sort(money);

        int i=0;
        for (i=0; i<money.length - 1; i++) {
            int minus = money[i+1] - money[i];
            if (jackpot >= (i+1)*minus) {
                jackpot -= (i+1)*minus;
                money[i] = money[i+1];
            } else {
                break;
            }
        }

        if (i==0) {
            money[i] += jackpot;
            return money;
        }

        for (int j=i-1; j>0; j--) {
            money[j-1] = money[j];
        }

        int p = jackpot / (i+1);
        int q = jackpot % (i+1);

        for (int j=i; j>=0; j--) {
            if (q>0) {
                money[j] += p + 1;
                q -= 1;
            } else {
                money[j] += p;
            }
        }

        return money;
    }


    public static void main(String[] argv) {
        TheJackpotDivTwo theJackpotDivTwo = new TheJackpotDivTwo();

        printArray(theJackpotDivTwo.find(new int[] {1, 2, 3, 4}, 2));
        printArray(theJackpotDivTwo.find(new int[] {4, 7}, 1));
        printArray(theJackpotDivTwo.find(new int[] {1}, 100));
        printArray(theJackpotDivTwo.find(new int[] {21, 85, 6, 54, 70, 100, 91, 60, 71}, 15));

    }

    private static void printArray (int [] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            System.out.print(',');
        }
        System.out.println();
    }

}
