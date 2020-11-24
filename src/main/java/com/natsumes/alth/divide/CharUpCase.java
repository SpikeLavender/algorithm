package com.natsumes.alth.divide;

/**
 * 大小写字母转换
 *
 * @author hetengjiao
 */
public class CharUpCase {


    public static char[] toUpCase(char[] chs,int i) {
        if(i>=chs.length) {
            return chs;
        }
        chs[i]=toUpCase(chs[i]);
        return toUpCase(chs,i + 1);
    }

    private static char toUpCase(char a) {
        if ((int) a < 97 || (int) a > 122) {
            return ' ';
        }
        return (char) Integer.parseInt(String.valueOf((int) a - 32));
    }

}
