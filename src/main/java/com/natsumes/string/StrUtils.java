package com.natsumes.string;

/**
 * @author hetengjiao
 */
public class StrUtils {

    /**
     * 最长不重复子串
     */
    public static int print(String s) {

        int[] chars = new int[256];
        int res = 0;
        int i = 0;
        int j = 0;
        while(i < s.length() && j < s.length()) {
            if(chars[s.charAt(j)] == 0) {
                chars[s.charAt(j)] = 1;
                j++;
                res = (j - i) > res ? (j - i) : res;
            } else {
                chars[s.charAt(i)] = 0;
                i++;
            }

        }
        return res;
    }
}
