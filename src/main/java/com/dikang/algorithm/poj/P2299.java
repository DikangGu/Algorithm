package com.dikang.algorithm.poj;

import java.util.Scanner;

/**
 * Calculate the "逆序对" using merge sort.
 *
 * Sample Input

5
9
1
0
5
4
3
1
2
3
0
Sample Output

6
0
 */
public class P2299 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int n = Integer.valueOf(line);

        while (n !=0) {
            int [] nums = new int[n];
            for (int i=0; i<n; i++) {
                line = sc.nextLine();
                nums[i] = Integer.valueOf(line);
            }

            System.out.println(calculate(nums));

            line = sc.nextLine();
            n = Integer.valueOf(line);
        }
    }

    private static long calculate(int[] nums) {
        int n = nums.length;
        int[] dest = new int[n];

        return mergePass(nums, dest, 0, n-1);
    }

    private static long mergePass(int[] nums, int[] dest, int left, int right) {

        if (left < right) {
            int mid = (left + right) >>1;

            long r1 = mergePass(nums, dest, left, mid);
            long r2 = mergePass(nums, dest, mid+1, right);

            long r3 = merge(nums, dest, left, mid, right);
            return r1 + r2 + r3;
        }

        return 0;
    }

    private static long merge(int[] nums, int[] dest, int left, int mid, int right) {
        int i= left;
        int j = mid+1;
        int k = left;
        long result = 0;
        while (i<=mid && j<=right) {
            if (nums[i] <= nums[j])  {
                dest[k++] = nums[i++];
            } else {
                dest[k++] = nums[j++];
                result += mid - i + 1;
            }
        }

        while (i<=mid) {
            dest[k++] = nums[i++];
        }

        while (j<=right) {
            dest[k++] = nums[j++];
        }

        for (k=left; k<=right; k++) {
            nums[k] = dest[k];
        }

        return result;
    }
}
