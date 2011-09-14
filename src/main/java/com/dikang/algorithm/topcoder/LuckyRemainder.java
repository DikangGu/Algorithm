import java.math.BigInteger;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 509 > Div II 500.
 */
public class LuckyRemainder {

    public int getLuckyCNM(int n, int m) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");

        for (int i=1; i<=m; i++) {
            a = a.multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i=n-m+1; i<=n; i++) {
            b = b.multiply(new BigInteger(String.valueOf(i)));
        }

        return b.divide(a).mod(new BigInteger(String.valueOf("9"))).intValue();
    }

    public int getLuckyRemainder(String X)
	{
        int len = X.length();
        int[] nums = new int[len];

        int sum = 0;
        for (int i=0; i<len; i++) {
            nums[i] = X.charAt(i) - '0';
            sum += nums[i];
        }

        sum = sum % 9;

        int luckyNum = sum;

        for (int k=1; k<len; k++) {
            luckyNum += getLuckyCNM(len-1, k) * sum;
            luckyNum %= 9;
        }

        return luckyNum;
	}

    public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new LuckyRemainder().getLuckyRemainder("123");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
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
		answer = new LuckyRemainder().getLuckyRemainder("24816");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
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
		answer = new LuckyRemainder().getLuckyRemainder("8");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
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
		answer = new LuckyRemainder().getLuckyRemainder("11235813213455");
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
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
