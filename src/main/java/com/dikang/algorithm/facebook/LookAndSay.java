/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class LookAndSay {

    public char[] lookAndSay(char[] preStr) {
        int count = 0;
        char pre = ' ';
        int index = 0;

        StringBuilder sb = new StringBuilder();

        while (index < preStr.length) {
            if (preStr[index] == pre) {
                count ++;
            } else {
                if (pre != ' ') {
                    sb.append(String.valueOf(count)).append(pre);
                }
                count = 1;
                pre = preStr[index];
            }

            index ++;
        }

        if (count>0) {
            sb.append(String.valueOf(count)).append(pre);
        }

        return sb.toString().toCharArray();
    }

    public static void main(String[] argv) {

        LookAndSay lookAndSay = new LookAndSay();
        char[] preStr = new char[]{'1'};
        char[] curStr;

        for (int i=0; i<20; i++) {
            curStr = lookAndSay.lookAndSay(preStr);

            char[] t = curStr;
            curStr = preStr;
            preStr = t;
        }

        System.out.println(preStr);
    }
}
