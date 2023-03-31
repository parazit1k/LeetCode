package org.PARAZITIK;


/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    public static int reverse(int x) {
        String stringX = String.valueOf(x);
        StringBuilder result = new StringBuilder(x < 0 ? "-" : "");

        for(int i = stringX.length() - 1; i >= 0; i--){
            result.append(stringX.charAt(i) != '-' ? stringX.charAt(i) : "");
        }

        long longResult = Long.parseLong(result.toString());

        if(Integer.MIN_VALUE > longResult || longResult > Integer.MAX_VALUE) return 0;

        return (int) Long.parseLong(result.toString());
    }
}
