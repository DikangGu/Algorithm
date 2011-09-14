/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class BStrAdd{

    public String bstradd(String a, String b) {

        int ai = a.length() -1;
        int bi = b.length() -1;
        String result = "";

        int t = 0;
        while (ai >=0 && bi >=0) {
            int anum = a.charAt(ai) - '0';
            int bnum = b.charAt(bi) - '0';

            int num = anum + bnum + t;
            if (num < 2) t = 0;
            else if (num == 2) {
                num = 0; t = 1;
            } else {
                num = 1; t = 1;
            }

            result = String.valueOf(num) + result;
            ai --;
            bi --;
        }

        while (ai>=0) {
            int anum = a.charAt(ai) - '0';
            int num = anum + t;
            if (num < 2) t = 0;
            else if (num == 2) {
                num = 0; t = 1;
            } else {
                num = 1; t = 1;
            }

            result = String.valueOf(num) + result;
            ai --;
        }

        while (bi>=0) {
            int bnum = b.charAt(bi) - '0';
            int num = bnum + t;
            if (num < 2) t = 0;
            else if (num == 2) {
                num = 0; t = 1;
            } else {
                num = 1; t = 1;
            }

            result = String.valueOf(num) + result;
            bi --;
        }

        if (t == 1) result = "1" + result;

        return result;

    }

    public static void main(String[] argv) {

        BStrAdd bstrAdd = new BStrAdd();
        System.out.println(bstrAdd.bstradd("11", "111"));
    }

}
