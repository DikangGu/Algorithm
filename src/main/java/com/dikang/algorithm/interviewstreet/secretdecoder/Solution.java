package com.dikang.algorithm.interviewstreet.secretdecoder;

/* Enter your code here. Read input from STDIN. Print output to STDOUT */

/**
* I assume that :
1. there are always at least one solution for each secret line.
2. the secret will one contain numbers.
3. each word will have at most 9 different words.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static List<String> dicts = new ArrayList<String>(0);
    private static List<String> secretLines = new ArrayList<String>(0);

    private static Map<String, List<String>> processedDicts =
            new HashMap<String, List<String>>(0);

    /**
     * read the dicts and secrets from the stdin
     *
     * @throws IOException
     */
    private static void readIn() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        // ignore the "//dict"
        line = in.readLine();

        // read all the dicts
        while(!line.startsWith("//")) {
            dicts.add(line);
            line = in.readLine();
        }

        // ignore the //secret
        line = in.readLine();
        // read all the secrets
        while(null != line && !"".equals(line)) {
            secretLines.add(line);
            line = in.readLine();
        }

    }

    // process each word, transfer them as "abbc" => "1223"    
    private static String getProcessedWord(String word) {
        String processed = word;
        Set<Character> visited = new HashSet<Character>(0);
        int current = 1;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (visited.contains(c)) {
                continue;
            }

            processed = processed.replaceAll(String.valueOf(c), String.valueOf(current));
            visited.add(c);
            current ++;
        }

        return processed;
    }

    // process each secret, transfer them as "2334" => "abbc" => "1223"
    private static String getProcessedSecret(String secret) {
        String word = "";
        for (int i=0; i<secret.length(); i++) {
            word += (char)('a' + Integer.parseInt(String.valueOf(secret.charAt(i))));
        }
        return getProcessedWord(word);
    }

    // process the input dictionary.
    private static void processDicts() {
        for (String word : dicts) {
            String processed = getProcessedWord(word);

            if (processedDicts.containsKey(processed)) {
                processedDicts.get(processed).add(word);
            } else {
                List<String> list = new ArrayList<String>(0);
                list.add(word);
                processedDicts.put(processed, list);
            }
        }
    }


    // dfs to find the correct candidates.
    private static boolean find(final String[] secrets,
                                final List<List<String>> candidates,
                                final int index,
                                final String currentSecret,
                                final String currentCandidateLine,
                                final String[] result) {

        if (index == secrets.length) {
            return true;
        }

        String secretLine = currentSecret + secrets[index];
        String processedSecret = getProcessedSecret(secretLine);

        if (null == candidates.get(index)) {
            return false;
        }

        for (String candidate : candidates.get(index)) {
            String candidateLine = currentCandidateLine + candidate;
            String processedCandiate = getProcessedWord(candidateLine);

            if (!processedSecret.equals(processedCandiate)) {
                continue;
            }

            if (find(secrets, candidates, index + 1, secretLine, candidateLine, result)) {
                result[index] = candidate;
                return true;
            }
        }

        return false;
    }


    // the main function
    public static void main(String[] argv) throws IOException {
        readIn();
        processDicts();

        for (String secretLine : secretLines) {
            // process each secret line.
            String[] secrets = secretLine.split(" ");

            // get the candidates.
            List<List<String>> candidates = new ArrayList<List<String>>(secrets.length);
            for (String secret : secrets) {

                String processedSecret = getProcessedSecret(secret);
                candidates.add(processedDicts.get(processedSecret));
            }

            //dfs to find the result.
            String[] result = new String[secrets.length];
            find(secrets, candidates, 0, "", "", result);

            // print the result.
            System.out.print(secretLine + " = ");
            for (String theword : result) {
                System.out.print(theword + " ");
            }
            System.out.println();
        }

    }
}

