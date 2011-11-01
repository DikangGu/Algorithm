package com.dikang.algorithm.poj;

import java.util.Scanner;
import java.util.Stack;

/**
 * Web Navigation
 *
 * Sample Input

VISIT http://acm.ashland.edu/
VISIT http://acm.baylor.edu/acmicpc/
BACK
BACK
BACK
FORWARD
VISIT http://www.ibm.com/
BACK
BACK
FORWARD
FORWARD
FORWARD
QUIT
Sample Output

http://acm.ashland.edu/
http://acm.baylor.edu/acmicpc/
http://acm.ashland.edu/
http://www.acm.org/
Ignored
http://acm.ashland.edu/
http://www.ibm.com/
http://acm.ashland.edu/
http://www.acm.org/
http://acm.ashland.edu/
http://www.ibm.com/
Ignored

 */
public class P1028 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> back = new Stack<String>();
        Stack<String> forward = new Stack<String>();

        String line = sc.nextLine().trim();

        String cur = "http://www.acm.org/";
        while (!line.equals("QUIT")) {
            String[] words = line.split(" ");
            if (words[0].equals("VISIT")) {
                back.push(cur);
                cur = words[1];
                forward.clear();
                System.out.println(cur);
            } else if (words[0].equals("BACK")) {
                if (back.isEmpty()) System.out.println("Ignored");
                else {
                    forward.push(cur);
                    cur = back.pop();
                    System.out.println(cur);
                }
            } else if (words[0].equals("FORWARD")) {
                if (forward.isEmpty()) System.out.println("Ignored");
                else {
                    back.push(cur);
                    cur = forward.pop();
                    System.out.println(cur);
                }
            }

            line = sc.nextLine();
        }

    }
}
