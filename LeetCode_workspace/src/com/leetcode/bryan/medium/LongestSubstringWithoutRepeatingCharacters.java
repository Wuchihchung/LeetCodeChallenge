package com.leetcode.bryan.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 作法的精神就是從頭開始走一遍字串. 每走過一個字元就存進hash map裏, 若沒有重復就一直走, 並同時記錄目前最大的不重復長度
 * 當有遇到重復字元時, 就進行調整, 把hash map裏的字串, 從原字串的頭開始一個一個remove, remove到hash map裏沒有重復字元為止
 * 意思就是重新整理出一個沒有重復字元的hash map, 然後再往下走, 走到字串結束, 並在過程中不斷記錄目前最大的不重復長度
 *
 * Time : O(N)
 */

public class LongestSubstringWithoutRepeatingCharacters {
    private static String s = " ";

    private static int maxLen = 0;
    private static Map<Character, Integer> map = new HashMap<>();

    public static int lengthOfLongestSubstring() {
        getMaxLen(0, 0, s);

        return maxLen;
    }

    private static void getMaxLen(int start, int end, String s) {
        char[] charArr = s.toCharArray();
        int len = charArr.length;

        int max = 0;

        while (end < len) {
            if (map.containsKey(charArr[end])) {
                maxLen = Math.max(maxLen, max);
                start = adjHashMap(start, end, charArr);
                map.put(charArr[end], 1);
                max = map.size();
            } else {
                map.put(charArr[end], 1);
                max++;
            }

            end++;
        }

        maxLen = Math.max(maxLen, max);
    }

    private static int adjHashMap(int start, int end, char[] charArr) {
        int newStart = start;

        for (int count = 0; ; count++) {
            map.remove(charArr[newStart]);

            if (charArr[newStart] == charArr[end]) {
                newStart++;
                break;
            }

            newStart++;
        }

        return newStart;
    }
}
