package com.leetcode.bryan.medium;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class FindAllGroupsofFarmland {
    /*public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer[]> list = new ArrayList<>();
        boolean checking = false;
        int startX, startY;
        int endX, endY;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!checking) {
                    if (land[m][n] == 1) {
                        checking = true;
                        startX = i;
                        startY = j;
                    }
                } else {
                    if (land[m][n] == 1) {
                        endX = i;
                        endY = j;
                    } else {
                        int[] farmland = new int[4];
                        farmland[0] = startX;
                        farmland[1] = startY;
                        farmland[2] = endX;
                        farmland[3] = endY;

                        list.add(farmland);
                        checking = false;
                    }
                }
            }
        }

        return list;
    }*/
}