package com.dikang.algorithm.poj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Round and Round We Go
 *
 * Sample Input

142857
142856
142858
01
0588235294117647
Sample Output

142857 is cyclic
142856 is not cyclic
142858 is not cyclic
01 is not cyclic
0588235294117647 is cyclic

 */
public class P1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.nextLine().trim();
            int n = line.length();

            String full = line + line;
            BigInteger num = new BigInteger(line);
            boolean cycle = true;
            for (int i=2; i<=n; i++) {
                BigInteger t = num.multiply(new BigInteger(String.valueOf(i)));
                if (!full.contains(t.toString())) {
                    cycle = false;
                    break;
                }
            }

            if (cycle) {
                System.out.println(line + " is cyclic");
            } else {
                System.out.println(line + " is not cyclic");
            }
        }
    }
}
