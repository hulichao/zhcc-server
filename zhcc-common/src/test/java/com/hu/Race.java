package com.hu;

import java.util.Arrays;
import java.util.Scanner;
public class Race{
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] teamA = new int[n];
        int[] teamB = new int[n];
        for (int i = 0; i < n; i++) {
            teamA[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            teamB[i] = scanner.nextInt();
        }
        System.out.println(getMostBonus(n, teamA, teamB));
    }

    public static int getMostBonus(int n, int teamA[], int teamB[]) {
        Arrays.sort(teamA);
        Arrays.sort(teamB);
        int i=0, j=0, x=n-1, y=n-1,cnt=0;
        boolean bLast=true;
        while(bLast)
        {
            if(x == i)
                bLast=false;


            if(teamA[x] > teamB[y])
            {
                x--;
                y--;
                cnt+=200;
            }
            else if(teamA[i]> teamB[j])
            {
                i++;
                j++;
                cnt += 200;
            }
            else
            {
                if(teamA[i] < teamB[y])
                    cnt -= 200;
                i++;
                y--;
            }
        }
//        System.out.println(cnt * 100);
        return cnt * 100;
    }
}
