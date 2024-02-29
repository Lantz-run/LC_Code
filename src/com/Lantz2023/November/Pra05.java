package com.Lantz2023.November;

/**
 * LeetCode第十四题：最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Pra05 {
    public static void main(String[] args) {

        Solution05 solution05 = new Solution05();
        String[] strs = {"flower","flow","flight"};
        String result = solution05.longestCommonPrefix(strs);
        System.out.println(result);
    }
}

class Solution05 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        String ans = strs[0]; // 令第一个字符串成为一个可以参照的对象，就是可以方便后面对的字符串进行遍历比较找出最长公共前缀
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 不能超过字符串数组的任意一个子串的长度
            for (; j < ans.length() && j < strs[i].length(); j++) {

                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
            // 如果第一个字符串等于空串，那就没有公共前缀
            if (ans.equals("")){
                return ans;
            }
        }
        return ans;

    }
}