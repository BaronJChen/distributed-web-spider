package com.baron.bootstrap.util;

import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public abstract class StringUtil extends StringUtils{
    public static String[] concat(String[] strs1, String str) {
        if (isEmpty(str)) {
            return strs1;
        }

        String[] strs2 = new String[1];
        strs2[0]= str;
        return concatenateStringArrays(strs1, strs2);
    }

    public static String[] concat(String str, String[] strs2) {
        if (isEmpty(str)) {
            return strs2;
        }

        String[] strs1 = new String[1];
        strs1[0]= str;
        return concatenateStringArrays(strs1, strs2);
    }

    public static String[] concat(String[] strs1, String[] strs2) {
        return concatenateStringArrays(strs1, strs2);
    }
}