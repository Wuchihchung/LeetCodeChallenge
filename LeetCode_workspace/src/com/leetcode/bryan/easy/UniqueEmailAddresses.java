package com.leetcode.bryan.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 */

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashMap<String, List<String>> domailMap = new HashMap<>();

        for (String email : emails) {
            int index = email.indexOf('@');
            if (index == -1) continue;

            String name = email.substring(0, index);
            String domain = email.substring(index + 1);

            index = email.indexOf('+');
            if (index != -1)
                name = email.substring(0, index);

            name = name.replace(".", "");

            List<String> listName = domailMap.getOrDefault(domain, new ArrayList<>());
            if (listName.indexOf(name) == -1) listName.add(name);

            domailMap.put(domain, listName);
        }

        int count = 0;
        for (String domain : domailMap.keySet()) {
            List<String> list = domailMap.get(domain);
            count += list.size();
        }

        return count;
    }
}