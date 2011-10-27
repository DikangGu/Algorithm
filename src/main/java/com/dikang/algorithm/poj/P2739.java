package com.dikang.algorithm.poj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * Sample Input

2
3
17
41
20
666
12
53
0
Sample Output

1
1
2
3
0
0
1
2
 */
public class P2739 {

    private static final List<Integer> primes = new ArrayList<Integer>();

    private static boolean isPrime(int num) {
        for (int i=2; i<Math.sqrt(num)+1; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);

        for (int i = 19; i<10000; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int len = primes.size();
        while (n != 0) {
            int count = 0;
            int head = 0;
            int tail = 0;
            int sum = primes.get(head);

            while (head <= tail && tail <len) {
                if (sum == n) {
                    count ++;
                    sum -= primes.get(head);
                    head ++;
                } else if (sum < n) {
                    tail ++;
                    if (tail < len)
                        sum += primes.get(tail);
                    else break;
                } else {
                    sum -= primes.get(head);
                    head ++;
                }
            }

            System.out.println(count);

            n = sc.nextInt();
        }
    }
}
