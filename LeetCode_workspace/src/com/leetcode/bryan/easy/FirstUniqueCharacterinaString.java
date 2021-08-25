package com.leetcode.bryan.easy;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * 1. 第一種方法是全部字元走一遍, 找出只有出現一次的字元. 然後再反回找出這些字元在原string裏出現的index最小的一個
 * 2. 法二是全部字元走一遍, 用字元當key, 出現次數當value, 建成一個hash map. 走完後再瀏覽map若value為1則為答案
 *
 * Time : O(n)
 */

public class FirstUniqueCharacterinaString {
    public static int firstUniqChar(String s) {
        int len = s.length();
        int array[] = new int[26];

        for (int idx = 0; idx < len; idx++) {
            char sub = s.charAt(idx);
            int value = sub - 0x61;
            array[value] += 1;
        }

        int index = Integer.MAX_VALUE;
        for (int idx = 0; idx < 26; idx++) {
            if (array[idx] == 1) {
                int result = s.indexOf(idx + 0x61);
                index = Math.min(index, result);
            }
        }

        return (index == Integer.MAX_VALUE) ? -1 : index;
    }
}
