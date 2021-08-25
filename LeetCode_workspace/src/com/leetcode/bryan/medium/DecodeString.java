package com.leetcode.bryan.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 *
 *  宣告一個以String為element的stack
 *
 * 1. 遇到左括號or字元則推入stack
 * 2. 遇到數字時則累積起來, 等到累積完畢時(遇到字元)則推入stack
 * 3. 遇到右括號時就開始把stack裏的推出來,一直接到左括號, 接著再推一個是數字. 然後再得出decoded string, 再推入stack
 * 4. 最後將stack裏的東西一一推出, 得到最後的decoded string
 */

public class DecodeString {
    private static String s = "3[a]2[bc]";

    public static String decodeString() {
        Stack<String> stack = new Stack<>();
        int len = s.length();
        String value = "";

        for (int idx = 0; idx < len; idx++) {
            String subString = s.substring(idx, idx+1 );

            int val = -1;

            try {
                val = Integer.valueOf(subString);
            }catch (NumberFormatException ex) {
                ;
            }

            if (val != -1) {
                value += subString;
                continue;
            }

            if (!subString.equals("]")) {
                if (!value.isEmpty()) {
                    stack.push(value);
                    value = "";
                }
                stack.push(subString);
            }
            else {
                String pop = stack.pop();
                String decode = "";

                while (!pop.equals("[")) {
                    decode = pop + decode;
                    pop = stack.pop();
                }

                pop = stack.pop();
                int time = Integer.valueOf(pop);
                String output = "";
                for (int t = 0; t < time; t++) output += decode;
                stack.push(output);
            }
        }

        String out = "";
        while (stack.size() > 0) {
            out = stack.pop() + out;
        }

        return out;
    }
}
