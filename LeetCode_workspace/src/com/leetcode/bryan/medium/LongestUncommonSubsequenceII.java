package com.leetcode.bryan.medium;

import java.util.*;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3921/
 *
 * 這題的意思是要求最大的非common子序列, 子序列的定義就是針對一字串去移除其中任意的字元(包含不移除), 最大的子序列就是字串其本身
 * 而非common子序列的定義是某個字串的子序列它不為array裏其它所有字串的子序列
 *
 * 這題的解法有幾個點要先了解 :
 *   1. 如果這樣的子序列存在的話, 它一定是這個array中的某一個子串, 而不會是某個字串裏其它更小的子序列
 *   2. 若array裏有2個(以上)的字串相同時, 則這些字串不會是答案, 因為絕對不會有uncommon的子序列產生
 *
 */

public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
    //* 1. Sort原始array, 長度大的放前面
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

        HashMap<String, Integer> group = new HashMap<>();
        List<String> unique = new ArrayList<>();

    //* 2. 計算每個字串出現的次數
        for (String s : strs) {
            int count = group.getOrDefault(s, 0);
            count++;
            group.put(s, count);
        }

    // 3. 把只出現一次的字串撈出來, 這些才是有可能是答案
        for (String s : group.keySet()) {
            if (group.get(s) == 1) unique.add(s);
        }

    // 4. 將只出現一次的字串撈出來並且一樣排序, 長的放前面
        String[] array = new String[unique.size()];
        unique.toArray(array);
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });

    // 5. 由長的字串先check, 若符合的話則就return了
        for (String s : array) {
            if (checkIfUncommon(group, s)) return s.length();
        }

    // 6. 若上面只出現一次的字串裏都沒有答案的話, 就表示無任何uncommon的子序列了
        return -1;
    }

    private boolean checkIfUncommon(HashMap<String, Integer> group, String s) {
        for (String str : group.keySet()) {
            if (str.equals(s)) continue;    // <-- 字串本身不用比也
            if (str.length() < s.length()) continue;    // <-- 字串長度比較小的也不用比對
            if (!unCommon(str, s)) return false;
        }

        return true;
    }

    private boolean unCommon(String s1, String s2) {
        String dummy = s1;
        char[] arr = s2.toCharArray();

        for (char c : arr) {
            int index = dummy.indexOf(c);
            if (index >= 0) {
                dummy = dummy.substring(index + 1);
            } else {
                return true;
            }
        }

        return false;
    }
}