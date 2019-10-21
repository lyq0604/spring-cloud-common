package com.blade.common.utils;

/**
 * @author lyq
 * @create 10/18/19
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    public static String convertToCamelCase(String str){
        if (null != str && str != "") {
            str = str.toLowerCase();
            if (!str.contains("_")) {
                return str.substring(0, 1).toUpperCase() + str.substring(1);
            } else {
                StringBuilder res = new StringBuilder();
                String[] names = str.split("_");
                String[] var3 = names;
                int var4 = names.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    String item = var3[var5];
                    if (!item.isEmpty()) {
                        res.append(item.substring(0, 1).toUpperCase());
                        res.append(item.substring(1));
                    }
                }

                return res.toString();
            }
        } else {
            return "";
        }
    }

}
