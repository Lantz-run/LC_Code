package com.Lantz2024.Krahets2023;

import java.util.HashMap;

/**
 * <p>Project: Algorithm20230913 - Pra10
 * <p>Powered by Lantz On 2024-02-07 23:38:58
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra10
 * @since 1.8
 */
public class Pra10 {

}

/**
 *
 代码
 测试用例
 测试用例
 测试结果
 242. 有效的字母异位词
 已解答
 简单
 相关标签
 相关企业
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。



 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 */
class Solution10 {
    // 通过哈希表的字符增减来判断字母异位词
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if(n1 != n2) return false;
        HashMap<Character, Integer> dic = new HashMap<>();
        // 哈希表中各个字符加一
        for(int i = 0; i < n1; i++){
            dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 哈希表中各个字符减一
        for(int i = 0; i < n2; i++){
            dic.put(t.charAt(i), dic.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int val : dic.values()){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
