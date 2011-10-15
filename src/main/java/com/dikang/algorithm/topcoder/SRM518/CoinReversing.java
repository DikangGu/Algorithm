package com.dikang.algorithm.topcoder.SRM518;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class CoinReversing {
    public double expectedHeads(int N, int[] a)
    {
        /*int k = a.length;
        double prob[] = new double[N+1];
        double newProb[] = new double[N+1];

        for (int i=0 ;i<=N; i++) {
            prob[i] = 0;
            newProb[i] = 0;
        }
        prob[N] = 1;

        for (int i=0 ;i<k; i++) {

            for (int p=0 ;p<=N; p++) {
                newProb[p] = 0;
            }

            for (int j=0; j<=N; j++) {
                if (prob[j] == 0)
                    continue;

                for (int q=0; q<=N; q++) {
                    int diff = j - q;

                }
            }
        }*/

        double res;
        double pb = 1;

        for (int i=0; i<a.length; i++) {
            pb = (1.0 -pb)*((double )a[i] / (double )N) + pb*(1.0 -(double)a[i]/(double )N);
        }

        res = pb*N;

        return  res;
    }

    public static void main(String[] args)
    {
        long time;
        double answer;
        boolean errors = false;
        double desiredAnswer;

        time = System.currentTimeMillis();
        answer = new CoinReversing().expectedHeads(3, new int[]{2,2});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 1.6666666666666667D;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CoinReversing().expectedHeads(10, new int[]{10,10,10});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 0.0D;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CoinReversing().expectedHeads(10, new int[]{2,7,1,8,2,8});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 4.792639999999999D;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();
        time = System.currentTimeMillis();
        answer = new CoinReversing().expectedHeads(1000, new int[]{916,153,357,729,183,848,61,672,295,936});
        System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
        desiredAnswer = 498.1980774932278D;
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        System.out.println("Desired answer:");
        System.out.println("\t" + desiredAnswer);
        if (answer != desiredAnswer)
        {
            errors = true;
            System.out.println("DOESN'T MATCH!!!!");
        }
        else
            System.out.println("Match :-)");
        System.out.println();


        if (errors)
            System.out.println("Some of the test cases had errors :-(");
        else
            System.out.println("You're a stud (at least on the test data)! :-D ");
    }

}
