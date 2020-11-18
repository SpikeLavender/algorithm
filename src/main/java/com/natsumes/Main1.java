package com.natsumes;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int max = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'A') {
                    int k = 0;
                    int tmp = i;
                    for (int j = tmp; j < chars.length - 1; j++) {
                       if ((chars[j] ^ chars[j+1]) != 0) {
                           k++;
                       } else {
                           if (chars[j] == 'B') {
                               k++;
                           }
                           i = j;
                           break;
                       }
                    }
                    //i = tmp;
                    max = Math.max(max, k);
                }
            }
            System.out.println(max);
        }
    }
}
