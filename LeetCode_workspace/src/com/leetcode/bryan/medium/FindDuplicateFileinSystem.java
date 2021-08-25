package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 *
 * 作法就是以file content為hash map的key, file name(含路徑)當value, 去把全部的file存在hash map裏
 * 再把value大小不為1的抓出來, 這些就是有重復的
 *
 * Time : O(NxM), 假設paths的大小為N, 每個path裏又有M個file
 */

public class FindDuplicateFileinSystem {
    public List <List< String >> findDuplicate(String[] paths) {
        HashMap< String, List <String>> map = new HashMap < > ();

        for (String path: paths) {
            String[] values = path.split(" ");  // <-- 先把每個字串用空白區隔, 區隔後的第0個substring是path, 之後的substring 1, 2, ...就是file name(含file content)

            for (int i = 1; i < values.length; i++) {   // <-- 接著對每個file做處理
                String[] name_cont = values[i].split("\\(");    // <-- 用左括號來區隔, 左括號左邊的字串就是file name

                name_cont[1] = name_cont[1].replace(")", "");   // <-- 左括號右邊的字串就是file content(要同時把右括號拿掉)
                List < String > list = map.getOrDefault(name_cont[1], new ArrayList < String > ());
                list.add(values[0] + "/" + name_cont[0]);

                System.out.println(values[0]);
                System.out.println(name_cont[0]);

                map.put(name_cont[1], list);        // <-- 以file content為key, 將file name存入(含file path)
            }
        }

        List < List < String >> res = new ArrayList< >();

        for (String key: map.keySet()) {
            if (map.get(key).size() > 1)    // 把有重覆content的全部取出
                res.add(map.get(key));
        }

        return res;
    }
}
