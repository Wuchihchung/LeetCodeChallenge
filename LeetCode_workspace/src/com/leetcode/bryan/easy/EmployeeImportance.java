package com.leetcode.bryan.easy;

import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/employee-importance/
 *
 *  宣告一個hash map, key是employee id, value是整個employee的instance
 * 1. 先走一遍employee List, 把所有的employee都存入hash map裏
 * 2. 由該id開始recursive的把所有subordinate都拉出來加總其importance
 *
 */

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();

        int size = employees.size();

        for (int idx = 0; idx < size; idx++) {
            Employee employee = employees.get(idx);
            map.put(employee.id, employee);
        }

        return getAllImportance(map, id);
    }

    public int getAllImportance(HashMap<Integer, Employee> map, Integer id) {
        Employee current = map.get(id);
        List<Integer> list = current.subordinates;
        int importance = current.importance;

        for (Integer subId : list) {
            importance += getAllImportance(map, subId);
        }

        return importance;
    }
}
