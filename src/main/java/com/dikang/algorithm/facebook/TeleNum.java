import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class TeleNum {

    private static final String[] DigitMapping =
            new String[] {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    private static void printPermutations(String numbers, int d, String result) {

        if (d == numbers.length()) {
            System.out.println(result);
            return;
        }

        int num = Integer.valueOf(numbers.charAt(d)+"");
        String mapping = DigitMapping[num];
        for (int i=0; i<mapping.length(); i++) {
            printPermutations(numbers, d+1, result + mapping.charAt(i));
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        printPermutations(line, 0, "");

        reader.close();
    }
}
