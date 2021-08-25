package com.leetcode.bryan.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * 下面code是Leetcode上的solution
 * 精神上就是把每個字串都去算存在多少不同的字元, 個數為多少, 然後以這些為基準去比對各個字串, 相同則為同一群
 * 這裏tricky的部份是用每個字串的資訊組成一個字串, ex : abbccc will be #1#2#3#0#0#0...#0
 *
 * #1#2#3#0#0#0...#0這個就是最後拿來比對的, 把它當hash key放在map裏
 *
 * Time : O(NK)
 */

public class GroupAnagrams {
    //private static String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
    private static String strs[] = {"bdddddddddd", "bbbbbbbbbbc"};

    public static List<List<String>> groupAnagrams() {
        if (strs.length == 0) return new ArrayList();

        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
        }

        return new ArrayList(ans.values());
    }
}
