package com.Lantz2024.Krahets2023;

import java.util.HashMap;

/**
 * <p>Project: Algorithm20230913 - Pra11
 * <p>Powered by Lantz On 2024-02-08 23:42:52
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra11
 * @since 1.8
 */
public class Pra11 {

}

/**
 * 387. 字符串中的第一个唯一字符
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 */
class Solution11 {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] cs = s.toCharArray();
        for(char c : cs){
            // 如果不包含就添加 c，如果包含就修改键值对为(c, False)，代表c > 1
            dic.put(c, !dic.containsKey(c));
        }
        for(int i = 0; i < cs.length; i++){
            if(dic.get(cs[i])){
                return i;
            }
        }
        return -1;
    }
}
