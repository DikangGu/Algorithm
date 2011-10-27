package com.dikang.algorithm.poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Babelfish
 *
 * Sample Input

dog ogday
cat atcay
pig igpay
froot ootfray
loops oopslay

atcay
ittenkay
oopslay
Sample Output

cat
eh
loops
 */
public class P2503 {

    private static final Map<String, String> dict = new HashMap<String, String>();

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        while (!line.isEmpty()) {
            String[] words = line.split(" ");
            dict.put(words[1], words[0]);

            line = sc.nextLine();
        }

        line = sc.nextLine();
        while (!line.isEmpty()) {
            if (dict.containsKey(line)) {
                System.out.println(dict.get(line));
            } else {
                System.out.println("eh");
            }

            line = sc.nextLine();
        }
    }
}
