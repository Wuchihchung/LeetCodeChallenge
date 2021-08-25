package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 *
 */

class Data {
    public String value;
    public int timestamp;

    public Data (String v, int time) {
        value = v;
        timestamp = time;
    }
}

public class TimeBasedKeyValueStore {
    private HashMap<String, HashMap<Integer, String>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> mapValue = map.getOrDefault(key, new HashMap<>());
        mapValue.put(timestamp, value);
        map.put(key, mapValue);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        HashMap<Integer, String> mapValue = map.get(key);
        if (mapValue.containsKey(timestamp)) return mapValue.get(timestamp);
        else {
            int stamp = timestamp;

            while (stamp >= 1) {
                stamp--;
                if (mapValue.containsKey(stamp)) return mapValue.get(stamp);
            }
        }

        return "";
    }
}
