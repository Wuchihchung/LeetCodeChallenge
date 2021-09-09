package com.leetcode.bryan.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * https://leetcode.com/problems/best-meeting-point/
 */

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> friendsListX = new ArrayList<>();
        List<Integer> friendsListY = new ArrayList<>();

        int count = 0;
        int friendsX, friendsY;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    friendsListX.add(i);
                    friendsListY.add(j);
                }
            }
        }

        friendsX = (int)median(friendsListX);
        friendsY = (int)median(friendsListY);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count += distance(i, j, friendsX, friendsY);
                }
            }
        }

        return count;
    }

    private int distance(int x, int y, int fX, int fY) {
        return Math.abs(fX - x) + Math.abs(fY - y);
    }

    private static double median(List<Integer> total) {
        double j = 0;
        //集合排序
        Collections.sort(total);
        int size = total.size();
        if(size % 2 == 1){
            j = total.get((size-1)/2);
        }else {
            //加0.0是为了把int转成double类型，否则除以2会算错
            j = (total.get(size/2-1) + total.get(size/2) + 0.0)/2;
        }
        return j;
    }
}