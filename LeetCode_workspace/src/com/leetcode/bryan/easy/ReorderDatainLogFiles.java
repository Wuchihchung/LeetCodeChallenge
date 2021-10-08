package com.leetcode.bryan.easy;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Amazon
 * https://leetcode.com/problems/reorder-data-in-log-files/
 *
 *
 */

public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);

                boolean isDigit_c1 = Character.isDigit(c1);
                boolean isDigit_c2 = Character.isDigit(c2);

                if (!isDigit_c1 && !isDigit_c2) {
                    int space1 = s1.indexOf(' ');
                    String id1 = s1.substring(0, space1);
                    String let1 = s1.substring(space1 + 1);

                    int space2 = s2.indexOf(' ');
                    String id2 = s2.substring(0, space2);
                    String let2 = s2.substring(space2 + 1);

                    int diff = let1.compareTo(let2);
                    if (diff == 0) return id1.compareTo(id2);
                    else return diff;
                }

                if (!isDigit_c1 && isDigit_c2) return 1;
                if (isDigit_c1 && !isDigit_c2) return -1;

                return 0;
            }
        });

        return logs;
    }
}