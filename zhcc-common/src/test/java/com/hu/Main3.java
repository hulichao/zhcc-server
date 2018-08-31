package com.hu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hulichao
 * @date 2018/8/30
 */
public class Main3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>;
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = Integer.valueOf(s.split("\\s+")[0]);
        int m = Integer.valueOf(s.split("\\s+")[1]);
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine());
        }

        for (int i = n-1; i >= 0; i--) {
            if(i == n-1){
                if (list.get(i).contains("o")) list.get(i).replace("o",".");
            }
            for (int i1 = 0; i1 < m; i1++) {
                StringBuilder sb = new StringBuilder(list.get(i));
                if (i + 1 >= n) sb.setCharAt(i1,'.');
                char cur = list.get(i+1).charAt(i1);
                while( cur == '.'){
                    sb.setCharAt(i1,'.');
                    list.get(i + 1).
                }

            }
        }
    }
}
