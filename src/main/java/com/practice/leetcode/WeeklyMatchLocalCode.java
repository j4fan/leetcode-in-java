package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @date 2019-06-09
 */
public class WeeklyMatchLocalCode {

    static class Solution {
        public String[] findOcurrences(String text, String first, String second) {
            if (text.length() <= 0) return new String[0];
            String[] texts = text.split(" ");
            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < texts.length; i++) {
                if (texts[i].equals(first)) {
                    if (i + 1 < texts.length && texts[i + 1].equals(second)) {
                        if (i + 2 < texts.length) {
                            resultList.add(texts[i + 2]);
                        }
                    }
                }
            }
            return resultList.toArray(new String[0]);
        }
    }

    static class Solution4 {
        public String smallestSubsequence(String text) {
            TreeMap map = new TreeMap();
            for (int i = 0; i < text.length(); i++) {
                if (!map.containsKey(text.charAt(i))) {
                    map.put(text.charAt(i), 1);
                }
            }
            StringBuffer sb = new StringBuffer();
            for (Object i : map.keySet()) {
                sb.append(i.toString());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        String text = "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa";
//        String first = "kcyxdfnoa";
//        String second = "jkypmsxd";
//        String[] strings = new Solution().findOcurrences(text,first,second);
        String text = "leetcode";
        String s = new Solution4().smallestSubsequence(text);
        System.out.println(s);
    }
}
