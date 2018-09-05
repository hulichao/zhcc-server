package com.hu.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {//订单

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n =Integer.valueOf(s);
        int target = Integer.valueOf(in.nextLine());
        List<Order> list = new ArrayList<>();
        List<Order> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            int id = Integer.valueOf(str.split("\\s+")[0]);
            int inn = Integer.valueOf(str.split("\\s+")[1]);
            int out = Integer.valueOf(str.split("\\s+")[2]);
            Order o = new Order(id,inn,out);
            list.add(o);
        }

        for (int i = 0; i < n; i++) {
            if(list.get(i).in <= target && target  <= list.get(i).out) {
                result.add(list.get(i));
            }
        }

        if (result == null || result.size() == 0) {
            System.out.println("null");
            return;
        }
        for (Order order : result) {
            System.out.println(order.id);
        }
    }
}

class Order {
    int id ;
    int in;
    int out;

    public Order(int id, int in, int out) {
        this.id = id;
        this.in = in;
        this.out = out;
    }
}
