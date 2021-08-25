package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Java String的split似乎tab key也會處理, 只要下空白就好, 不用特別再下tab
 * 所以整個處理就變得相當的容易. 之後可以再複習一下regx的使用
 *
 * Time : O(n)
 */
public class ReverseWordsinaString {
    private static String s = "  hello world  ";

    public static String reverseWords() {
        String[] strArray = s.split(" ");
        String result = "";

        int len = strArray.length;

        StringBuilder builder = new StringBuilder();

        for (int i = len - 1; i >= 0; i--) {
            if (!strArray[i].isEmpty()) {
                if (builder.length() > 0) {
                    builder.append(" ");
                    builder.append(strArray[i]);
                } else builder.append(strArray[i]);
            }
        }

        return builder.toString();
    }
}
