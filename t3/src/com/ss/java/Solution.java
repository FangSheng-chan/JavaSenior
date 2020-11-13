package com.ss.java;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int bit[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bit[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (--bit[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
