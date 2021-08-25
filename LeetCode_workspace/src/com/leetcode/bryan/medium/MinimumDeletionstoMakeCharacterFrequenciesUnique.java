package com.leetcode.bryan.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * 1. 先算出字串裏每個字元出現的次數, 並儲存起來
 * 2. 把這些次數做sort
 * 3. 由小到大一個一個往hash map裏塞
 * 4. 當發現map裏有重復時, 則開始對該次數減1, 減到可以不重復塞進map為止, 若一路減至0表示該次數完全不能存在了
 * 5. 本解法的精神就是以最少一次減1為單位, 看減到何時可以變成不重復
 *
 * 時間應該是O(N), N是字串的長度, 後面處理freq那部份, 因為freq的大小為26的array, 算是constant, 所以不影響
 *
 */

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    /* NG */

    /* public int minDeletions() {
        String s = "aaabbbcc";

        char[] arr = s.toCharArray();
        int len = arr.length;
        int count[] = new int[26];

        for (int i = 0; i < len; i++) {
            count[arr[i] - 'a'] += 1;
        }

        Set<Integer> map = new HashSet<>();
        int deletions = 0;

        for (int i = 0; i < 26; i++) {
            if (map.contains(count[i])) deletions += count[i];
            else map.add(count[i]);
        }

        return deletions;
    }*/

    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        Arrays.sort(freq);

        Set<Integer> set = new HashSet();
        int deletions = 0;

        for (int i : freq) {
            while(set.contains(i) && i > 0) {
                i--;
                deletions++;
            }

            set.add(i);
        }

        return deletions;
    }
}
