package com.dikang.algorithm.poj;

import java.util.Scanner;

public class P2109 {

	public static int root(int p, double number) {
		int current = 2;
		int flag = -2;
		int upper = 2;
		int lower = 1;
		int prev;
		double n;
		while (flag != 0) {
			n = 1;
			for (int i = 0; i < p; i++) {
				n *= current;
			}
			if (n == number){
				prev = current;
				flag = 0;
			}
			else if (n > number) {
				upper = current;
				prev = current;
				current = (lower + upper) / 2;
				flag = -1;
			} else {
				if (upper == current) {
					lower = current;
					prev = current;
					current *= 2;
					upper = current;
				} else {
					lower = current;
					prev = current;
					current = (lower + upper) / 2;
				}
				flag = 1;
			}
			if(prev == current){
				flag = 0;
			}
		}
		return current;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        double b = in.nextDouble();
		while (a != -1) {
			System.out.println(root(a, b));
			a = in.nextInt();
			b = in.nextDouble();
		}
	}
}