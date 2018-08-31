package com.hu;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String one = "";
        List<String> list = new ArrayList<>();
        int n = Integer.valueOf(s.split("\\s+")[0]);
        int m = Integer.valueOf(s.split("\\s+")[1]);
        if(n < 1 || n > 2000 || m < 1 || m > 2000) return;
        for (int i = 0; i < n; i++) {
            list.add(in.nextLine().trim());
        }
        String result = "";
        for (int i = 0; i < m; i++) {
            Collections.sort(list);
            if(i == 0) one = list.get(0);
            result += list.get(0).charAt(0);
            for (int j = 0; j < n; j++) {
                String temp = list.get(j).substring(1);
                list.set(j, temp);
            }
        }
        System.out.println(result.equals(one) ? "-" : result);
    }

}
