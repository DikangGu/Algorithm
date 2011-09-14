/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class StringToInt {

    public int stringToInt(String str) {
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            result = result * 10 + (str.charAt(i) - '0');
        }

        return result;
    }

    public static void main(String[] argv) {
        StringToInt stringToInt = new StringToInt();
        System.out.println(stringToInt.stringToInt("1234567890"));
    }
}
