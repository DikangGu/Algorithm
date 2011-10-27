package com.dikang.algorithm.poj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Crazy Search
 *
 * Sample Input

3 4
daababac
Sample Output

5

 */
public class P1200 {

    private static final Set<String> set = new HashSet<String>();

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] nums = line.split(" ");
        int n = Integer.valueOf(nums[0]);
        int nc = Integer.valueOf(nums[1]);

        line = sc.nextLine();
        int len = line.length();

        for (int i=0; i+n <= len; i++) {
            String t = line.substring(i, i+n);
            if (set.contains(t)) continue;

            int[] chars = new int[26];
            for (int j=0; j<n; j++) {
                chars[t.charAt(j) - 'a'] = 1;
            }
            int count = 0;
            for (int j=0; j<26; j++) {
                count += chars[j];
            }
            if (count > nc) continue;
            set.add(t);
        }
        System.out.println(set.size());
    }
}
