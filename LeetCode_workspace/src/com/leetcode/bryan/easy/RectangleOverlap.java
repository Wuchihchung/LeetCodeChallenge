package com.leetcode.bryan.easy;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 *
 * 因為rect[]的定義是{x1, y1, x2, y2}, (x1, y1)是左下角的點, (x2, y2)是右上角的點
 * 所以不overlap只有4種cases, 就是在左方 or 在右方 or 在上方 or 在下方
 *
 * Time : O(1)
 *
 */

public class RectangleOverlap {
    //private static int rec1[] = {0, 0, 2, 2}, rec2[] = {1, 1, 3, 3};
    private static int rec1[] = {0, 0, 1, 1}, rec2[] = {1, 0, 2, 1};

    public static boolean isRectangleOverlap() {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
}