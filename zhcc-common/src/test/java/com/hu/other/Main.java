package com.hu.other;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String res = "";
        char curChar = s.charAt(0);
        int curCount = 1,i = 0;
        while(++i < s.length()) {
            if (s.charAt(i) == curChar) {
                curCount ++;
            }else {
                res += curCount + "" + curChar;
                curChar = s.charAt(i);
                curCount =1;
            }
        }
        res += curCount + "" + curChar;
        System.out.println(res);
    }
}
