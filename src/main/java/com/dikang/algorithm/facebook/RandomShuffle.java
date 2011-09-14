import java.util.Random;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class RandomShuffle {

    private int[] randomShuffle(int[] original) {

        Random random = new Random(System.currentTimeMillis());

        int len = original.length;
        int j = len - 1;
        while (j>0) {
            int index = random.nextInt(j);
            original[index] ^= original[j] ^= original[index];
            original[j] ^= original[index];

            j--;
        }

        return original;
    }

    public static void main(String[] argv) {
        int a = 2;
        int b = 6;
        b ^= a ^= b;
        a ^= b;

        System.out.println(a + ", " + b);

        int [] original = new int[10];
        for (int i=0; i<10; i++) {
            original[i] = i+1;
        }

        int[] result = new RandomShuffle().randomShuffle(original);
        for(int item : result) {
            System.out.print(item);
            System.out.print(" ");
        }
    }
}
