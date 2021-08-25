package com.leetcode.bryan.easy;

public class ReplaceAllMarktoAvoidConsecutiveRepeatingCharacters {
    String s = "z?a";

    public String modifyString() {
        int len = s.length();
        char arr[] = s.toCharArray();

        for (int i = 0; i < len; i++)
            if (arr[i] == '?') removeQuestionMark(i, arr);

        return String.valueOf(arr);
    }

    private void removeQuestionMark(int start, char[] arr) {
        if (start > 0) {
            arr[start] = arr[start - 1];
            arr[start] += 1;
            if (arr[start] > 0x7a) arr[start] -= 26;
        }
        else arr[start] = 'a';

        if (start + 1 < arr.length && arr[start + 1] != '?') {
            if (arr[start] == arr[start + 1]) arr[start] += 1;
            if (arr[start] > 0x7a) arr[start] -= 26;
        }
    }
}
