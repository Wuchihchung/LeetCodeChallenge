package com.leetcode.bryan.easy;


/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * 1. 因為最多一位有示26種可能的顯示, 所以就把total number除以26, 商往高位去處理, 餘數看是多少, 對應到A~Z來顯示
 * 2. 愈左邊是愈高位數, 所以商是要往高位數去處理
 * 3. if判斷那邊是一個特別的處理, 當整除26的case, 是要show 'Z', 所以商要減1, 並且改show 'Z'.
 *    Ex : total = 26, => 商是1, 餘是0, 所以要改成商=0, show 'Z'. total = 52, 商=2, 餘=0, 要改成商=1, show 'Z'
 *    這部份很不順, 有機會要再想一下, 是不是改除以27會比較順
 *
 * Time : O(log(26, n)), 應該可以算是constant time
 */

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        int quo = -1;
        int rem = 0;
        String result = "";

        while (columnNumber != 0) {
            quo = columnNumber / 26;
            rem = columnNumber % 26;

            if (quo >= 1 && rem == 0) {
                quo -= 1;
                rem = 26;
            }

            char current = (char)(rem + 0x40);
            result = String.valueOf(current) + result;

            columnNumber = quo;
        }

        return result;
    }
}
