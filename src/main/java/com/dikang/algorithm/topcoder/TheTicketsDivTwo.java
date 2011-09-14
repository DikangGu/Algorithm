/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 504.5 -> DivII 1000
 *
 * f[n][1][k] = 1/6 + f[n][n][k-1]
 * f[n][m][k] = 1/2*f[n][m-1][k-1] + 1/3*f[n-1][m-1][k-1]
 *
 */
public class TheTicketsDivTwo {

    public double find(int n, int m, int k) {

        if (n==0) {
            return 0.0;
        }

        if (m==0) {
            return 0.0;
        }

        if (k==0) {
            if(m == 1)
                return 1.0;
            else
                return 0.0;
        }

        if (m==1) {
            if (n == 1) {
                return 1.0;
            }
            else
                return ((double)1.0/(double)6.0) + ((double)1.0/(double)2.0) * find(n, n, k-1);
        }

        return ((double)1.0/(double)2.0) * find(n, m-1, k-1) +
                ((double)1.0/(double)3.0) * find(n-1, m-1, k-1);
    }

    public static void main(String[] argv) {

        TheTicketsDivTwo theTicketsDivTwo = new TheTicketsDivTwo();
        System.out.println(theTicketsDivTwo.find(2, 1, 1));
        System.out.println(theTicketsDivTwo.find(2, 1, 2));
        System.out.println(theTicketsDivTwo.find(7, 7, 4));
        System.out.println(theTicketsDivTwo.find(4, 2, 10));
    }
}
