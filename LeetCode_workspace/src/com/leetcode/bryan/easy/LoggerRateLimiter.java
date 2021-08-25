package com.leetcode.bryan.easy;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 *
 * Time : O(1)
 */

public class LoggerRateLimiter {

    HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int value = map.getOrDefault(message, -1);

        if (value == -1 || timestamp >= value) {
            map.put(message, timestamp + 10);
            return true;
        }

        return false;
    }
}
