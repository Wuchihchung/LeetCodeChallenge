package com.leetcode.bryan.easy;

/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * 原則上一定是使用binary search無誤, 但 while (right - left >= 2) { 這行是要小小想過才行
 * 意思就是要夾到left and right 2個已經到了靠在一起才停止, 此時就的答案就會存在left or right其中一個上了
 * 所以若left不是bad那就一定是right了
 *
 * Time : O(n)
 */

public class FirstBadVersion {
    /* public class FirstBadVersion extends VersionControl {
        public int firstBadVersion(int n) {
            if (isBadVersion(1)) return 1;

            int left = 1, right = n;
            int index;

            while (right - left >= 2) {
                index = left + (right - left) / 2;

                if (isBadVersion(index)) {
                    right = index;
                } else {
                    left = index;
                }
            }

            return isBadVersion(left) ? left : right;
        } */
}