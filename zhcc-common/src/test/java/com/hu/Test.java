package com.hu;

/**
 * @author hulichao
 * @date 2018/8/15
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "programming";
        String s2 = new String("programming");
        String s3 = "program";
        String s4 = "ming";
        String s5 = "program" + "ming";
        String s6 = s3 + s4;
        String s7 = "program" + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2.intern() == s1.intern());//false
        System.out.println(s1 == s7);//false
    }
}
