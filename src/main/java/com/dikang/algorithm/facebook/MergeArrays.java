/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * Given 2 arrays A and B where the size of A is equivalent to
 * the number of elements in A and B.
 * Arrays A and B are sorted where the extra memory contained in A is at the end.
 * Merge the two arrays in place in a single pass.
 *
 */
public class MergeArrays {

    public void mergeArrays(int[] A, int []B, int lenA) {
        int i = lenA-1;
        int j = B.length - 1;

        int k = A.length - 1;

        while (i>=0 && j>=0) {
            if (A[i] >= B[j]) {
                A[k] = A[i];
                i--;
            } else {
                A[k] = B[j];
                j --;
            }
            k--;
        }

        if (j>=0) {
            while (k>=0) {
                A[k] = B[k];
                k--;
            }
        }

    }


    public static void main(String[] argv) {
        int[] A = new int[10];
        int[] B = new int[] {-5,-2,-1};
        for (int i=0; i<7; i++) {
            A[i] = i;
        }

        MergeArrays mergeArrays = new MergeArrays();
        mergeArrays.mergeArrays(A, B, 7);

        for (int item : A) {
            System.out.print(item + " ");
        }
    }
}
