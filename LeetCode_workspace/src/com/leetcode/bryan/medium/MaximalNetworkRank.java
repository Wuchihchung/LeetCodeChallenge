package com.leetcode.bryan.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 *
 * 這題題目感覺寫的不太好, 意思是要求任2點其degree相加為最大. 但這2點若相連, 則degree算1次即可.
 *
 * 1. 針對每一個點, 用一個hash set記錄和它相連的點
 * 2. 走一遍所有的road, 把終點記錄在起點的hash set裏, 把起點也記錄在終點的hash set裏
 * 3. 承上, 記錄完後, 再從所有的hash set裏找出2個最大degree的點, 把degree相加即為解. 要注意若這2點相連時, 要減1
 *
 * Time : O(N2)
 */

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());

        for (int[] r : roads) {
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {     // <-- 這裏有個小tricky, 不用從j = 0開始, 因為這樣會重復check. 可以省check

                int cur = map.get(i).size() + map.get(j).size();
                if(map.get(i).contains(j) || map.get(j).contains(i)) cur--;

                res = Math.max(res, cur);
            }
        }

        return res;
    }
}
