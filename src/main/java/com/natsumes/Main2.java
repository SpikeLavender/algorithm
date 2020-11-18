package com.natsumes;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String str = sc.next();

            HashSet<String> set = new HashSet<>();

            for (int i = 0; i <= n - m; i++) {
                String substring = str.substring(i, m + i);
                set.add(substring);
            }

            System.out.println(set.size());
        }
    }

}
