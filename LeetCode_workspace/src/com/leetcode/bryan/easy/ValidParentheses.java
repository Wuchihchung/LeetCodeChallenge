package com.leetcode.bryan.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * 1.遇左括號先推進stack
 * 2.遇到右括號則判斷 :
 *  2-1 : 若此時stack side是0的話則fail
 *  2-2 : 若推出stack的右括號不是對應的右括號的話則fail
 * 3.最後確認stack的side, 若是0表示所有左右括號都對稱存在, success
 *
 * Time : O(n)
 */

public class ValidParentheses {
    private static String s = "()[]{}";

    public static boolean isValid() {
        boolean b = false;
        HashMap<String, Integer> hash1 = new HashMap<>();
        hash1.put("(", 1);
        hash1.put("[", 2);
        hash1.put("{", 3);

        HashMap<String, String> hash2 = new HashMap<>();
        hash2.put(")", "(");
        hash2.put("]", "[");
        hash2.put("}", "{");

        Stack<String> stack = new Stack<>();
        for (int idx = 0; idx < s.length(); idx++) {
            String subString = s.substring(idx, idx + 1);

            if (hash1.getOrDefault(subString, -1) != -1) stack.push(subString);
            else if (!hash2.getOrDefault(subString, "!").equals("!")) {
                if (stack.size() > 0) {
                    String pop = stack.pop();
                    String s1 = hash2.getOrDefault(subString, "!");

                    if (!s1.equals(pop)) {
                        //System.out.println("False");
                        b = false;
                        return b;
                    }
                }
                else
                    return b;
            }
        }

        if (stack.size() == 0)
            //System.out.println("True");
            b = true;

        return b;
    }
}
