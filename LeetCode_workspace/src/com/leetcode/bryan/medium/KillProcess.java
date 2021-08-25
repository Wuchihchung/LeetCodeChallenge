package com.leetcode.bryan.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/kill-process/
 *
 * 精神上就是把所有的pid放到一個hash map裏, hash key是pid, hash value是一個Node的structure, Node裏有pid和sub nodes的list
 * 接著要kill時就是找出要被kill的pid的所有sub nodes, 並且recursive的找出所有sub nodes的sub sub nodes
 *
 * Time : O(n)
 */

public class KillProcess {
    class Node {
        int val;
        List < Node > children = new ArrayList < > ();
    }

    public List < Integer > k(List < Integer > pid, List < Integer > ppid, int kill) {
        HashMap < Integer, Node > map = new HashMap < > ();

        for (int id: pid) {
            Node node = new Node();
            node.val = id;
            map.put(id, node);
        }

        for (int i = 0; i < ppid.size(); i++) {
            int val = ppid.get(i);

            if (val > 0) {
                Node par = map.get(val);    // 把parent process的node instance從map裏拿出來
                par.children.add(map.get(pid.get(i)));  // map.get(pid.get(i)) -> 把child process的node instance從map裏拿出來
            }
        }

        List < Integer > l = new ArrayList < > ();
        l.add(kill);
        getAllChildren(map.get(kill), l);
        return l;
    }

    public void getAllChildren(Node pn, List < Integer > l) {
        for (Node n: pn.children) {
            l.add(n.val);
            getAllChildren(n, l);
        }
    }
}
