package com.Lantz2023.OctoberPra;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode第三题：无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *  示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *  示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Pra03 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String str = "abcabcdab";
        int result = solution3.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>(); // 便于快速查找和记录
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))){ //charAt():返回指定索引处的char值
               left = Math.max(left, hashMap.get(s.charAt(i))+1); //
            }
            // 不管是否更新left，都要更新s.charAt(i)的位置，因为要读取到后面的字符
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}

class Solution3_1{
    public int length(String str){

        if (str.length() == 0) return 0;

        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))){
                left = Math.max(left, hashMap.get(str.charAt(i))+1);
            }
            hashMap.put(str.charAt(i), i);
            max = Math.max(max, i-left+1);
        }

        return max;
    }
}