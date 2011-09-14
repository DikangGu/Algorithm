package com.dikang.algorithm.facebook.dp;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * LIS
 */
public class LongestIncreseSequence {

    public int LIS(int[] nums) {
        int []len = new int[nums.length];
        int max = 0;

        for (int i=0; i<nums.length; i++) {

            len[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i]) {
                    len[i] = len[i] < len[j] + 1 ? len[j] + 1 : len[i];
                }
            }

            max = max < len[i] ? len[i] : max;
        }

        return max;
    }

    // return the total numbers of LIS.
    public int LISCount(int[] nums) {
        int []len = new int[nums.length];
        int max = 0;

        int [] count = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            count[i] = 0;
            len[i] = 1;
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i]) {
                    len[i] = len[i] < len[j] + 1 ? len[j] + 1 : len[i];
                }
            }

            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i] && len[j] + 1 == len[i]) {
                    count[i] += count[j];
                }
            }

            if (count[i] == 0) {
                count[i] = 1;
            }

            max = max < len[i] ? len[i] : max;
        }

        int result = 0;
        for (int i=0; i<nums.length; i++) {
            if (len[i] == max) {
                result += count[i];
            }
        }

        return result;
    }

    public int LISLOGN(int[] nums) {

        int []len = new int[nums.length];
        int max = 0;

        int []index = new int[nums.length  + 1];
        index[0] = 0;

        for (int i=0; i<nums.length; i++) {
            index[i+1] = Integer.MAX_VALUE;

            int result = BS(index, nums[i], max);
            len[i] = result + 1;

            max = max < len[i] ? len[i] : max;
            index[len[i]] = Math.min(index[len[i]], nums[i]);

        }

        for (int t : index) {
            System.out.print(t + " ");
        }
        System.out.println();
        return max;
    }

    int BS(int[] index, int key, int max) {
        int left = 1;
        int right = max;

        while(left < right) {
            int mid = (left + right) >>1;
            if (index[mid] < key) {
                left = mid + 1;
            } else if (index[mid] >= key) {
                right = mid -1;
            }
        }

        if (index[left] >= key) {
            return left -1;
        }

        return left;
    }

    public static void main(String[] argv) {
        LongestIncreseSequence longest = new LongestIncreseSequence();
        int[] nums = new int[] {11, 11, 13, 12, 13, 14, 15};

        System.out.println(longest.LIS(nums));
        System.out.println(longest.LISCount(nums));
    }
}
