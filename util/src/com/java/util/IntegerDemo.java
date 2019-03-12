package com.java.util;

import java.util.Scanner;

/**
 * @author SacredBier
 * Integer类的练习
 * 2019/3/10
 */
public class IntegerDemo {
    public static void main(String[] args) {
        int num = 31;
        //调用Integer类的方法，将num进行进制转换
        String str1 = Integer.toBinaryString(num);
        String str2 = Integer.toHexString(num);
        String str3 = Integer.toOctalString(num);
        String str4 = Integer.toString(num, 7);
        System.out.println(str1 + " " + str2 + " " + str3 + " " + str4 + " ");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int radix = scanner.nextInt();
        System.out.println(conver(num1, radix));

    }

    private static String conver(int num, int radix) {
        StringBuffer stringBuffer = new StringBuffer();
        while (num != 0) {
            int remainder = num % radix;
            num = num / radix;
            stringBuffer.append(String.valueOf(remainder));
        }

        return stringBuffer.reverse().toString();
    }
}

