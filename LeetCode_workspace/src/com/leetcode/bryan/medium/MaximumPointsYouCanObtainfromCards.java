package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/solution/
 *
 * 1. 選K張card的方式就是由左右分別各選(0, K), (1, K-1), (2, K-2), ...., (K-1, 1), (K, 0)這些cases
 * 2. 由左把1張1張card累加, 加至K張, 就是選左邊card的所有cases
 * 3. 由右把1張1張card累加, 加至K張, 就是選右邊card的所有cases
 * 4. 由2, 3, 可以得到所有選卡的case的分數, 再選出其中最大即可
 *
 * Time : O(K)
 */

public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int[] frontSetOfCards = new int[k + 1];
        int[] rearSetOfCards = new int[k + 1];

        for (int i = 0; i < k; i++) {
            frontSetOfCards[i + 1] = cardPoints[i] + frontSetOfCards[i];
            rearSetOfCards[i + 1] = cardPoints[n - i - 1] + rearSetOfCards[i];
        }

        int maxScore = 0;
        // Each i represents the number of cards we take from the front.
        for (int i = 0; i <= k; i++) {
            int currentScore = frontSetOfCards[i] + rearSetOfCards[k - i];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
