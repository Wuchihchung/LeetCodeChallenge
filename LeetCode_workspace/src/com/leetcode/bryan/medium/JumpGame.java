package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/jump-game/
 *
 * 此解法是Leetcode裏的, Dynamic Programming解法
 * 所以稱為Dynamic Programming, 應該是指用array去存good node/bad node的方式, 因為這樣的方式是可以累積前面的結果再往下做的
 *
 * 解法的精神就是要找index 0可不可以到終點(就是index 0是不是一個good node), 則就一個一個看, 例如index 0可以再走下去2步, 則
 * 看index 1/index 2是不是good node. 所以這邊會有一個recursive的code
 *
 * 解法裏的key point 1, 2是大重點, 是可以讓recursion停止的重點
 * key point 2會run到的原因是furthestJump = 0, furthestJump = 0是因為該node一步都不能走
 *
 * Time O(n2)
 *
 */

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame {
    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {          // <--- 這段是dynamic programming的精神, 就是發現之前已經處理過的就直接拿存過的結果, 不再重做一次
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;     // <--- key point 2
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }

        memo[memo.length - 1] = Index.GOOD;     // <--- key point 1
        return canJumpFromPosition(0, nums);
    }
}
