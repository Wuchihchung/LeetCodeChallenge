package com.leetcode.bryan.medium;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 *
 *  先宣告一個hashset, 塞入所有的employee id
 *
 * 1. 把所有leave id留下, 移除非leaf的id
 * 2. 由每個leaf反推上去到head, 看要多少通知時間, 再記錄最大的通知時間
 *
 * Time : O(n), step 1為O(n), step 2也是O(n)
 */

public class TimeNeededtoInformAllEmployees {
    private static int n = 7;
    private static int headID = 6;
    private static int manager[] = {1, 2, 3, 4, 5, 6, -1};
    private static int informTime[] = {0, 6, 5, 4, 3, 2, 1};

    public static int numOfMinutes() {
        // 1. get all leaves
        HashMap<Integer, Integer> leaves = new HashMap<>();
        for (int id = 0; id < n; id++)
            leaves.put(id, 1);

        leaves.remove(headID);

        for (int id = 0; id < n; id++)
            leaves.remove(manager[id]);

        // 2. get highest level
        int maxLevel = 0, tmp = 0;
        for (Integer id : leaves.keySet()) {
            while (id != headID) {
                int managerId = manager[id];
                int time = informTime[managerId];
                tmp += time;
                id = managerId;
            }

            maxLevel = Math.max(maxLevel, tmp);
            tmp = 0;
        }

        return maxLevel;
    }
}
