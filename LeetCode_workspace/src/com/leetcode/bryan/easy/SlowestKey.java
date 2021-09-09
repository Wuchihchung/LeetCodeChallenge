package com.leetcode.bryan.easy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/slowest-key/
 */

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int slowDur = releaseTimes[0];
        int index = 0;
        int half = releaseTimes[releaseTimes.length - 1] / 2;

        for (int i = 1; i < keysPressed.length(); i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];

            if (duration > slowDur) {
                index = i;
                slowDur = duration;
            } else if (duration == slowDur) {
                char cur = keysPressed.charAt(i);
                char pre = keysPressed.charAt(index);

                if (cur > pre) index = i;
            }

            if (slowDur > half) break;
        }

        return keysPressed.charAt(index);
    }
}