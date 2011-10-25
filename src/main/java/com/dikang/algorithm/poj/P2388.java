package com.dikang.algorithm.poj;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *  Who's in the Middle
 *
 * Sample Input

 5
 2
 4
 1
 3
 5
 Sample Output

 3

 */
public class P2388 {

    private static int n = 0;
    private static Random random = new Random(new Date().getTime());
    static int count = 0;

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        n = Integer.valueOf(line);
        int[] milk = new int[n];

        for (int i=0; i<n; i++) {
            line = sc.nextLine();
            milk[i] = Integer.valueOf(line);
        }

        int result = findTopK(milk, (n+1)/2, 0, n-1);
        System.out.println(result);
    }

    public static int findTopK(int [] nums, int k, int left, int right) {
        int i = left;
        int j = right;

        count ++;

        int pivot = nums[i];

        while(i < j) {
            while(nums[j]>= pivot && i < j) j --;
            nums[i] = nums[j];
            while(nums[i]<=pivot && i < j) i ++;
            nums[j] = nums[i];
        }

        nums[i] = pivot;

        int m = right - i + 1;
        if (m == k) {
            return nums[i];
        } else if (m>k) {
            return findTopK(nums, k, i+1, right);
        } else if (m<k) {
            return findTopK(nums, k-m, left, i-1);
        }

        return 0;
    }

    private static int findMiddle(int[] milk, int start, int end) {
        int middle = partition(milk, start, end);

        if (middle == n/2) {
            return milk[middle];
        } else if (middle < n/2) {
            return findMiddle(milk, middle + 1, end);
        } else {
            return findMiddle(milk, start, middle);
        }
    }

    private static int partition(int[] milk, int start, int end) {
        int i = end;
        int j = end;
        if (start <= end) {
            int pivotIndex = random.nextInt(end-start+1) + start;
            int pivot = milk[pivotIndex];
            milk[pivotIndex] = milk[start];
            milk[start] = pivot;

            while (i>=start) {
                if (milk[i] >= pivot) {
                    if (i!=j) {
                        j--;
                        int t = milk[j];
                        milk[j] = milk[i];
                        milk[i] = t;
                    }
                }
                i--;
            }
        }

        return j;
    }
}
