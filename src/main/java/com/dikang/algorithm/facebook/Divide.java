/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * 写一个函数：

 void divide (int num, int den, int & quo, int & rem)

 其中num和den为传入，后两者传出。求 num/den = quo 余数为rem

 要求：函数内不可以使用除法和取模

 */
public class Divide {

    public static class MyInt {

        public int value;

        public MyInt(int value) {
            this.value = value;
        }
    }

    public void divide (int num, int den, MyInt quo, MyInt rem) {

        int left, right;
        if (num >0) {
            left = -num;
            right = num;
        } else {
            left = num;
            right = -num;
        }

        int mid;
        int result = left;
        while(right >= left) {
            mid = (right + left) >>1;

            if (den > 0) {
                if (mid * den > num) {
                    right = mid -1;
                } else {
                    result = mid;
                    left = mid + 1;
                }
            } else {
                if (mid * den < num) {
                    right = mid -1;
                } else {
                    result = mid;
                    left = mid + 1;
                }
            }

            quo.value = result;
            rem.value = num - result*den;
        }

    }

    public static void main(String[] argv) {

        System.out.println(-7/-2);
        System.out.println(-7/2);
        System.out.println(7/-2);
        System.out.println(7/2);

        Divide divide = new Divide();
        MyInt quo=new MyInt(0);
        MyInt rem=new MyInt(0);
        divide.divide(-7, -2, quo, rem);
        System.out.println(quo.value + "," + rem.value);
        divide.divide(-7, 2, quo, rem);
        System.out.println(quo.value + "," + rem.value);
        divide.divide(7, -2, quo, rem);
        System.out.println(quo.value + "," + rem.value);
        divide.divide(7, 2, quo, rem);
        System.out.println(quo.value + "," + rem.value);
    }
}
