package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/valid-square/
 *
 * 暴力法列舉所有的cases
 * 1. 正方形4個邊+上對角2個邊總共有6個邊, 先確認若有一個邊是0則不符合
 * 2. 再以邊長和畢式定理來確認 : 2相鄰邊要一樣長, 2個邊的平方合要等於斜邊的平方
 * 3. 上點的case要考慮對角點有3種cases, 即以P1為例, 對角點可為P2, P3 or P4, 所以有3種cases
 *
 * Time : O(1)
 */

public class ValidSquare {
    private static int p1[] = {0, 0}, p2[] = {1, 1}, p3[] = {1, 0}, p4[] = {0, 1};

    public static boolean validSquare() {
        int dis1 = dist(p1, p2);
        int dis2 = dist(p1, p3);
        int dis3 = dist(p1, p4);
        int dis4 = dist(p2, p4);
        int dis5 = dist(p3, p4);
        int dis6 = dist(p2, p3);

        if (dis1 == 0 || dis2 == 0 || dis3 == 0 || dis4 == 0 || dis5 == 0 || dis6 == 0) return false;

        if (dis1 == dis2 && (dis1 + dis2) == dis3 && (dis4 + dis5) == dis3 ) return true;
        if (dis2 == dis3 && (dis2 + dis3) == dis1 && (dis4 + dis6) == dis1 ) return true;
        if (dis1 == dis3 && (dis1 + dis3) == dis4 && (dis5 + dis6) == dis4 ) return true;

        return false;
    }

    private static int dist(int[] p1, int[] p2) {
        int diff1 = Math.abs(p1[0] - p2[0]);
        int diff2 = Math.abs(p1[1] - p2[1]);

        return diff1 * diff1 + diff2 * diff2;
    }
}
