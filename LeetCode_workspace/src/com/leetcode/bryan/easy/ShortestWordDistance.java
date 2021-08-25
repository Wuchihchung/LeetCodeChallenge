package com.leetcode.bryan.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShortestWordDistance {
    private static String wordsDict[] = {"practice", "makes", "perfect", "coding", "makes"};
    private static String word1 = "makes", word2 = "coding";

    public static int shortestDistance() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list;

        for (int i = 0; i < wordsDict.length; i++) {
            if (map.containsKey(wordsDict[i])) {
                list = map.get(wordsDict[i]);
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);

                map.put(wordsDict[i], list);
            }
        }

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < l1.size(); i++) {
            int dis1 = l1.get(i);

            for (int j = 0; j < l2.size(); j++) {
                int dis2 = l2.get(j);
                min = Math.min(min, Math.abs(dis1 - dis2));
            }
        }

        return min;
    }
}
