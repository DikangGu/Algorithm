package com.dikang.algorithm.poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 Spell checker

 Sample Input

i
is
has
have
be
my
more
contest
me
too
if
award
#
me
aware
m
contest
hav
oo
or
i
fi
mre
#
Sample Output

me is correct
aware: award
m: i my me
contest is correct
hav: has have
oo: too
or:
i is correct
fi: i
mre: more me

 */
public class P1035 {

    private static final Map<String, Integer> dict = new HashMap<String, Integer>();

    private static String find(String line) {
        Map<Integer, String> result = new TreeMap<Integer, String>();
        int len = line.length();

        //deleting of one letter from the word
        String tmp = "";

        for (int i =0 ;i<len; i++) {
            if (i==0) {
                tmp = line.substring(1);
            } else if (i==len-1) {
                tmp = line.substring(0, i);
            } else {
                tmp = line.substring(0, i) + line.substring(i+1);
            }

            if (dict.containsKey(tmp)) {
                result.put(dict.get(tmp), tmp);
            }
        }

        //replacing one letter
        for (int i=0; i<len; i++) {
            for (char c = 'a'; c<='z'; c++) {
                if (i==0) {
                    tmp = c + line.substring(1);
                } else if (i==len-1) {
                    tmp = line.substring(0, i) + c;
                } else {
                    tmp = line.substring(0, i) + c + line.substring(i+1);
                }

                if (dict.containsKey(tmp)) {
                    result.put(dict.get(tmp), tmp);
                }
            }
        }

        // inserting one letter
        for (char c = 'a'; c<='z'; c++) {
            for (int i=0; i<len; i++) {
                if (i==0) {
                    tmp = c + line;
                } else {
                    tmp = line.substring(0, i) + c + line.substring(i);
                }

                if (dict.containsKey(tmp)) {
                    result.put(dict.get(tmp), tmp);
                }
            }

            tmp = line + c;
            if (dict.containsKey(tmp)) {
                result.put(dict.get(tmp), tmp);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (Integer key : result.keySet()) {
            sb.append(" " + result.get(key));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int index = 0;
        while(!line.equals("#")) {
            dict.put(line, index);

            line = sc.nextLine();
            index ++;
        }

        line = sc.nextLine();
        while(!line.equals("#")) {
            if (dict.containsKey(line)) {
                System.out.println(line + " is correct");
            } else {
                System.out.println(line + ":" + find(line));
            }

            line = sc.nextLine();
        }

    }
}
