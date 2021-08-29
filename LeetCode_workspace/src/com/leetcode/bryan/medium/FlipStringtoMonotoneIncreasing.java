package com.leetcode.bryan.medium;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;


/**
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3876/
 *
 * 這題的意思是給定一個由0與1組成的字串. 如果它是遞增的話就稱它為monotone increasing
 * 遞增的意思就是0後面接的只能是0 or 1. Ex : 00011, 00111, 11111, 000000, 0001...
 * 題目中允許, 將0換成1 or 將1換成0, 問最少要換幾次才能將原本的字串轉換成monotone increasing
 *
 * 作法1 : 如最下面mark掉的code, 用recursive的寫法. 即原字串的最小轉換會等於min(第0個字元要轉換 + 後面n-1個字元轉換的最小值, 第0個字元要'不'轉換 + 後面n-1個字元轉換的最小值)
 * 如果去recursive, 即可求解. 但原字串一長, 這個方式就會遇到stackoverflow的問題.
 * 所以recursive的寫法, 雖然窄看設計理念還不錯, 但code不好寫, 而且必需要嘗試做backtracking的機制, 減少不必要的recursive, 讓stackoverflow不發生
 * 整理而言recursive的設計要滿足leetcode裏的時間/memory限制, 一般而言難度很高. 幾次經驗下來, 應該是不建議用recursive
 *
 * 作法2 : 如下面沒有mark的code. 精神就是當原字串被轉換成monotone increasing字串時, 可能的樣子為00000, 00001, 00011, 00111, 01111, 11111
 * 也就是說以這個方向去想, 當原字串轉換成這些字串時, 每個轉換次數裏的最小值就是答案
 * 但若照著去寫code, 沒有任何optimize的話, 當原字串過大時, 又會爆掉, 超過限制的時間
 * 所以這邊又有一個想法, 就是由左至右去check, 看每增加一位時要轉換為全部字串皆為0需幾步. 同樣也由右至左去check, 看每增加一位時要轉換為全部字串皆為1需幾步.
 * 如此, 會得到2個array如下面code裏所寫. 再去找出array裏兩兩相加的最小值即可
 *
 * 結論 : 做了一些題目後, 這類字串的處理/判斷問題, 用resursive去做幾乎會越搞越複雜. 常見的方式應該就是用一個index由左而右去掃一次頂多當下再分為2個substring再去個別判斷
 * 如此最多在O(N2)可以完成. 或是用2 pointers的方式, 一左一右2頭開始去掃
 *
 * Time : O(N)
 */

public class FlipStringtoMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int min = Integer.MAX_VALUE;
        int[] value1 = new int[len + 1];
        int[] value2 = new int[len + 1];

        char[] arr = s.toCharArray();

        for (int i = 0; i < len; i++) {
            value1[i + 1] = value1[i];
            if (arr[i] == '1') value1[i + 1]++;
        }

        for (int i = len - 1; i >= 0; i--) {
            value2[i] = value2[i + 1];
            if (arr[i] == '0') value2[i]++;
        }

        for (int i = 0; i <= len; i++) {
            int cur = value1[i] + value2[i];
            min = Math.min(min, cur);

            if (min == 0) break;
        }

        return min;
    }

    private int numOf1to0(String s) {
        int count = 0;
        char[] arr = s.toCharArray();

        for (char c : arr) if (c == '1') count++;

        return count;
    }

    private int numOf0to1(String s) {
        int count = 0;
        char[] arr = s.toCharArray();

        for (char c : arr) if (c == '0') count++;

        return count;
    }

    /* HashMap<String, Integer> map = new HashMap<String, Integer>();

    public int minFlipsMonoIncr(String s) {
        int min = doStringFlips(false, s);

        return min;
    }

    private int doStringFlips(boolean is1Only, String s) {
        if (map.getOrDefault(s, -1) != -1) {
            System.out.println(">>> Here : " + s);
            return map.get(s);
        }

        if (s.isEmpty()) return 0;

        if (is1Only) {
            return numOf0to1(s);
        }

        if (s.length() == 1) return 0;

        char first = s.charAt(0);
        String sub = s.substring(1);
        int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;

        if (first == '0') {
            int strategy1 = doStringFlips(false, sub);
            int strategy2 = 1 + doStringFlips(true, sub);

            val1 = Math.min(strategy1, strategy2);
        }
        else {
            int strategy1 = doStringFlips(true, sub);
            int strategy2 = 1 + doStringFlips(false, sub);

            val2 = Math.min(strategy1 , strategy2);
        }

        int value = Math.min(val1, val2);
        map.put(s, value);

        return value;
    }

    private int numOf0to1(String s) {
        int count = 0;
        char[] arr = s.toCharArray();

        for (char c : arr) if (c == '0') count++;

        return count;
    } */
}