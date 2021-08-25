package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3906/
 *
 * 這題的解法網路上有好幾種, 下面這種判斷circle的方式code最少, 但需要理解一下, 一開始看不太好懂
 * 這個解法的精神就是 :
 *   1. 對一個n個vertex的tree, 它的邊應該有n-1條, 不多不少
 *   2. 這個tree裏不能存在任何的circle
 *
 *  所以作法一開始是掃過所有的邊一遍, 去看有沒有形成circle的地方
 *   1. 先宣告一個size為n的int array, 去記錄這n個vertex的root
 *   2. 開始掃每個邊, 這步驟是重點, 常會搞不清, 可以想成從沒有邊開始一個邊一個邊往tree裏去加, 看是否會形成circle
 *   3. 舉例, 當加入{1, 3}時, 假設此時array裏1的root是0, 3還沒發現root, 這時處理完後, 3的root應該也為0, 進而把0記錄在array裏成為3的root
 *      也就是說當{1, 3}這個邊被加入tree時, 針對vertex 3我們就可以找到3的一個root為0, 又或是說3經由這個邊可以到達它的root 0
 *   4. 承上, 一直掃到所有邊都結束為止, 若有發現有一新的邊加入時, 舉例{x, 3}, 3可以經由x到達3的root, 也就是說這時3可以經由另一個邊也可以到達3的root
 *      這表示tree裏存在2點, 這2點間的路徑不是唯一的, 所以必存在circle, 所以這個graph不為一個tree. 判斷結束
 *
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        //if (edges.length != n - 1) return false;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = -1;

        for (int[] edge : edges) {
            int root1 = root(roots, edge[0]);
            int root2 = root(roots, edge[1]);

            if (root1 == root2) return false;
            roots[root2] = root1;
        }

        return edges.length == n - 1;       // <-- 對一個n個vertex的tree, 它的邊應該有n-1條, 不多不少
    }

    private int root(int[] roots, int id) {
        while (roots[id] != -1) id = roots[id];

        return id;
    }
}