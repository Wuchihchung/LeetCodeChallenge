package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * 本解法的精神是假設有一條水平線, 這條水平線由最高的height開始, 慢慢一格一格往下降
 * 在下降的過程中, 與各個垂直線有交集形成長方形時則記錄是否比之前的都大, 如此下降到水平線height = 1時, 即可找到最大的container
 *
 * getArea()中會試著找到最左邊和最右邊足height值的垂直線, 注意這裏是需要愈左愈好, 愈右愈好, 所以一遇到符合的就要return
 * getArea()本身可以看看還可以精簡否
 *
 * Time : O(n2)
 */

public class ContainerWithMostWater {
    private static int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};

    public static int maxArea() {
        int len = height.length;
        int max = 0;
        int maxArea = 0;

        for (int i = 0; i < len; i++) max = Math.max(max, height[i]);

        for (int h = max; h >= 1; h--) {
            int area = getArea(height, h);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int getArea(int[] height, int h) {
        int len = height.length;
        int left = 0, right = 0;

        for (int i = 0; i < len; i++) {
            if (height[i] >= h) {
                left = i;
                break;
            }
        }

        for (int j = len - 1; j >= 0; j--) {
            if (height[j] >= h) {
                right = j;
                break;
            }
        }

        if (left < right) return (right - left) * h;
        else return 0;
    }
}
