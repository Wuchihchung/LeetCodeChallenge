package com.leetcode.bryan.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/string-compression/
 *
 * 直接字串的每個字元掃過一遍, 並同時將已確定數量的字元從同一array的頭開始存入
 *
 * Time : O(n)
 */

public class StringCompression {
    public int compress(char[] chars) {
        int len = chars.length;
        char preChar = chars[0];
        int count = 0;
        int total = 0;
        int index = 0;

        for (char c : chars) {
            if (c == preChar) {
                count++;
            } else {
                total += count;
                chars[index] = preChar;
                chars[index + 1] = (char)(count + '0');

                preChar = c;
                count = 1;
                index += 2;
            }
        }

        //index += 2;
        chars[index] = preChar;
        chars[index + 1] = (char)(count + '0');

        total += count;
        chars = Arrays.copyOf(chars, index + 2);
        return total;
    }
}
