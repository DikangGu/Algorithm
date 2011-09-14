/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * reverse each word in a sentence
 */
public class ReverseWord {

    public String reverse(String words) {

        StringBuilder result = new StringBuilder();
        int i=0,j=0;

        while (i<words.length()) {
            if (words.charAt(i) == ' ') {
                result.append(" ");
                i++;
                continue;
            }

            j = i;
            while (j<words.length() && words.charAt(j)!=' ') {
                j ++;
            }

            int t = j-1;
            while(i<=t) {
                result.append(words.charAt(t));
                t--;
            }

            i = j;
        }

        return result.toString();
    }

    public static void main(String[] argv) {
        ReverseWord reverse = new ReverseWord();
        System.out.println(reverse.reverse("12345 123 I'm king of the word"));
    }
}
