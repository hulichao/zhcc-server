package com.hu.lianjia;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        4
//        16 5
//        20 5
//        10 10
//        18 2
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = Integer.valueOf(s);
        List<M> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            int position = Integer.valueOf(str.split("\\s+")[0]);
            int height = Integer.valueOf(str.split("\\s+")[1]);
            list.add(new M(i+1,position,height));
        }

        Collections.sort(list, new Comparator<M>() {
            @Override
            public int compare(M o1, M o2) {
                return o1.position-o2.position;
            }
        });
        for (int i = list.size() -1 ; i >= 0; i--) {
            if(i == list.size()-1) {
                list.get(i).setCount(1);
                continue;
            }

            int temp = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(j).position >= list.get(i).position + 1)) {
                    if ((list.get(j).position <= (list.get(i).position + list.get(i).height - 1)))
                        temp++;
                }
            }
            if ((list.get(i + 1).position >= list.get(i).position + 1)) {
                if ((list.get(i + 1).position <= (list.get(i).position + list.get(i).height - 1)))
                    temp = (temp > list.get(i + 1).getCount() + 1) ? temp: list.get(i + 1).getCount() + 1;
            }
            list.get(i).setCount(temp);
        }

        Collections.sort(list, new Comparator<M>(){
            @Override
            public int compare(M o1, M o2) {
                return o1.id - o2.id;
            }
        });

        for (M m : list) {
            System.out.print(m.getCount()+ " ");
        }
        System.out.println();
    }
}

class M {
    int id;//序号
    int position;//位置
    int height;//高度
    int count;//压倒数量

    public M(int id, int position, int height) {
        this.id = id;
        this.position = position;
        this.height = height;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
