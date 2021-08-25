package com.leetcode.bryan.medium;

/**
 * https://leetcode.com/problems/lonely-pixel-i/
 *
 * 作法比較笨, 時間複雜度可能也算差, 但直覺易了解
 * 就是先把每一行每一列都掃過一次, 看該行/列是否都剛好只有一個'B', 並且記錄下來
 * 接著就從array裏的每一個element去掃一遍, 若該element是'B'的話, 就看其所在位置的行/列是否是只有一個'B', 是的話該element就是合法的
 *
 * Time : O(MxN)
 */

public class LonelyPixelI {
    public int findLonelyPixel() {
        //char picture[][] = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
        //char picture[][] = {{'W', 'W', 'W'}, {'B', 'B', 'W'}, {'B', 'B', 'B'}};
        char picture[][] = {{'B', 'B', 'B'}};

        int m = picture.length;
        int n = picture[0].length;

        int lonely_m[] = new int[m];
        int lonely_n[] = new int[n];

        for (int i = 0; i < m; i++) {       // <-- 由上m, n的值來看, 此陣列為 m x n 的大小, m是列數, n是行數.
                                            // 這個for loop的用意就是check這m列是否每列都只剛好有一個'B', 是的話記為1, 沒有'B'記0, 否則記-1
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    count++;

                    if (count >= 2) {
                        lonely_m[i] = -1;
                        break;
                    }
                }
            }

            if (count == 1) lonely_m[i] = 1;
        }

        for (int i = 0; i < n; i++) {       // <-- 這個for loop的意思是check這n行是否每行都只剛好有一個'B', 是的話記為1, 沒有'B'記0, 否則記-1
            int count = 0;

            for (int j = 0; j < m; j++) {
                if (picture[j][i] == 'B') {
                    count++;

                    if (count >= 2) {
                        lonely_n[i] = -1;
                        break;
                    }
                }
            }

            if (count == 1) lonely_n[i] = 1;
        }

        int result = 0;

        for (int i = 0; i < m; i++) {       // <-- 再重新每個element都check一次, 若element為'B'時就看此時這個element所在的行/列是否都是只存在一個'B'
            for (int j = 0; j < n; j++)
                if (picture[i][j] == 'B')
                    if (lonely_m[i] == 1 && lonely_n[j] == 1) result++;
        }

        return result;
    }
}
