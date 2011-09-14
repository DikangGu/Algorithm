package com.dikang.algorithm.facebook.puzzles;

import java.util.Arrays;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 *
For the path that include I[j], the problem is down to OPT(prev(j)) where prev(j) is the closest interval to the left of I[j] which does not overlap I[j].
For the path that exclude I[j], the problem is down to OPT(j-1).
So the pseudo code is:
1. Sort(I) by the earliest finish (last DNA position)
2. Given a function prev(j) begin at I[j] and move to the left of I[j] until I[k].end < I[j].bgn this is a previous non-overlap of I[j].
3. The recursion will look like this;
int OPT(int j){
   if(j < 0) return 0; //base case
   else {
      return Max(OPT(j-1), OPT(pre(j)));
   }
}
For DP, create an OPT table of size N and initialize OPT[0] to I[0].score. For j=1 to N-1 simply call OPT(j). This is an O(N) complexity.
 *
 *
 */
public class Gattaca {

    public static class Interval implements Comparable<Interval>{
        public int start;
        public int end;
        public int value;

        public Interval(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Interval interval) {
            if (start == interval.start && end == interval.end && value == interval.value)
                return 0;

            if (start < interval.start)
                return -1;

            if (start == interval.start && end < interval.end)
                return -1;

            if (start == interval.start && end == interval.end && value < interval.value)
                return -1;

            return 1;
        }

        @Override
        public String toString() {
            return start + ", " + end + ", " + value;
        }
    }


    // O(m*n)
    public static void main(String[] args) {

        Interval[] intervals = new Interval[8];
        intervals[0] = new Interval(43, 70, 27);
        intervals[1] = new Interval(3, 18, 24);
        intervals[2] = new Interval(65, 99, 45);
        intervals[3] = new Interval(20, 39, 26);
        intervals[4] = new Interval(45, 74, 26);
        intervals[5] = new Interval(10, 28, 20);
        intervals[6] = new Interval(78, 97, 23);
        intervals[7] = new Interval(0, 9, 22);

        Arrays.sort(intervals);

        int n = 100;
        int[] value = new int[n];

        for (int i=0; i<intervals.length; i++) {
            int start = intervals[i].end;
            for (int j=start; j<n; j++) {
                int newValue = intervals[i].start == 0? 0 : value[intervals[i].start - 1];
                value[j] = Math.max(value[j], newValue + intervals[i].value);
            }
        }

        System.out.println(value[99]);
    }
}
