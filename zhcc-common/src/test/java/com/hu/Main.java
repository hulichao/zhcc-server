package com.hu;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static int f(int n, int m)
    {
        n = n % m;
        Vector v = new Vector();

        for(;;)
        {
            v.add(n);
            n *= 10;
            n = n % m;
            if(n==0) {
                System.out.print(v.size() + " ");

                return 0;
            }
            if(v.indexOf(n)>=0)  {
                System.out.print(v.indexOf(n) + " ");

                return v.size()-v.indexOf(n) ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int resut;
        try {
            int n = Integer.valueOf(s.split("\\s+")[0]);
            int m = Integer.valueOf(s.split("\\s+")[1]);
            resut = f(0,1);
        }catch (Exception e) {
            return ;
        }
        System.out.println(resut);
    }

}
