package com.dikang.algorithm.game;

import java.util.*;  
import java.lang.*;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class Cal24 {
	
	private static char[] op = new char[] {'+', '-', '*', '/'};
	
	private double calculate(double a, double b, char opNo) {
		switch(opNo) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':    
				if (b == 0) {
					return Double.MIN_VALUE;
				}
				return a / b;
		}
		
		return 0;
	}
	
	private int[] getNextIndex(int[] cur) {
		int smallerThanNext = cur.length - 2;
		
		while (smallerThanNext >=0 && cur[smallerThanNext] > cur[smallerThanNext+1]) {
			smallerThanNext --;
		}
		
		if (smallerThanNext < 0) return null;
		int larger = cur[smallerThanNext + 1];
		int largerIndex = smallerThanNext + 1;
		
		for (int index = largerIndex + 1; index < cur.length; index ++) {
			if (larger > cur[index] && cur[index] > cur[smallerThanNext]) {
				larger = cur[index];
				largerIndex = index;
			}
		}
		
		int tmp = cur[largerIndex];
		cur[largerIndex] = cur[smallerThanNext];
		cur[smallerThanNext] = tmp;
		
		Arrays.sort(cur, smallerThanNext + 1, cur.length);
		
		return cur;
	}
	
	private static void printArray(int[] array) {
		for (int item : array) {
			System.out.print(item + ",");
		}
		System.out.println();
	}    
	                                                 
	// case 1:
	private double calculate1(char op1, char op2, char op3, int[] data) {
		double result = 0;         
		
		double t = calculate(data[2], data[3], op3);
		if (t == Double.MIN_VALUE) return t;
		
		t = calculate(data[1], t, op2);
		if (t == Double.MIN_VALUE) return t;
		
		result = calculate(data[0], t, op1);
		
		return result;
	}  
	
	// case 2:
	private double calculate2(char op1, char op2, char op3, int[] data) {
		double result = 0;         
		
		double t = calculate(data[1], data[2], op3);
		if (t == Double.MIN_VALUE) return t;
		
		t = calculate(t, data[3], op2);
		if (t == Double.MIN_VALUE) return t;
		
		result = calculate(data[0], t, op1);
		
		return result;
	}
	
	// case 3:
	private double calculate3(char op1, char op2, char op3, int[] data) {
		double result = 0;         
		
		double t1 = calculate(data[2], data[3], op3);
		if (t1 == Double.MIN_VALUE) return t1;
		
		double t2 = calculate(data[0], data[1], op1);
		if (t2 == Double.MIN_VALUE) return t2;
		
		result = calculate(t2, t1, op2);
		
		return result;
	}
	
	// case 4:
	private double calculate4(char op1, char op2, char op3, int[] data) {
		double result = 0;         
		
		double t = calculate(data[1], data[2], op3);
		if (t == Double.MIN_VALUE) return t;
		
		t = calculate(data[0], t, op2);
		if (t == Double.MIN_VALUE) return t;
		
		result = calculate(t, data[3], op1);
		
		return result;
	}
	
	// case 5:
	private double calculate5(char op1, char op2, char op3, int[] data) {
		double result = 0;         
		
		double t = calculate(data[0], data[1], op3);
		if (t == Double.MIN_VALUE) return t;
		
		t = calculate(t, data[2], op2);
		if (t == Double.MIN_VALUE) return t;
		
		result = calculate(t, data[3], op1);
		
		return result;
	}
	
	public static void main(String[] args) {
		                           
		int [] data = new int[] {1, 2, 4 ,4};
		int [] array = new int[] {1, 2, 3, 4};
		Cal24 cal = new Cal24();
		
		while (null != array) {
			printArray(array);        
			
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					for (int k=0; k<4; k++) {
						    
						int [] realData = new int[] {data[array[0]-1], data[array[1]-1], data[array[2]-1],
							data[array[3]-1]};
						double result = cal.calculate1(op[i], op[j], op[k], 
							realData);    
						if (result == 24)  {  
							System.out.println("calculate1");    
							printArray(realData);
						 	System.out.println(op[i] + "," + op[j] + "," + op[k]);
						   return;         
						}  
						
						result = cal.calculate2(op[i], op[j], op[k], 
							realData);    
						if (result == 24)  {  
							System.out.println("calculate2");   
							printArray(realData);
						 	System.out.println(op[i] + "," + op[j] + "," + op[k]);
						   return;         
						}
						
						result = cal.calculate3(op[i], op[j], op[k], 
							realData);    
						if (result == 24)  {  
							System.out.println("calculate3");    
							printArray(realData);
						 	System.out.println(op[i] + "," + op[j] + "," + op[k]);
						   return;         
						}
						
						result = cal.calculate4(op[i], op[j], op[k], 
							realData);    
						if (result == 24)  {  
							System.out.println("calculate4");   
							printArray(realData);
						 	System.out.println(op[i] + "," + op[j] + "," + op[k]);
						   return;         
						}
						
						result = cal.calculate5(op[i], op[j], op[k], 
							realData);    
						if (result == 24)  {  
							System.out.println("calculate5");    
							printArray(realData);
						 	System.out.println(op[i] + "," + op[j] + "," + op[k]);
						   return;         
						}
					}
				}
			}
			
	     	array = cal.getNextIndex(array);
		}
		
	}

}
