package com.Lantz2024.Krahets2023;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra13
 * <p>Powered by Lantz On 2024-02-17 10:51:43
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra13
 * @since 1.8
 */
public class Pra13 {

}

/**
 * 409. 最长回文串
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输出:1
 * 示例 3：
 *
 * 输入:s = "aaaaaccc"
 * 输出:7
 */
class Solution13 {
    public int longestPalindrome(String s) {
        // 统计每一个字符出现的次数
        HashMap<Character, Integer> counter = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            counter.merge(s.charAt(i), 1, (a, b) -> a + b);
        }
        int res = 0, odd = 0; // 如果某个字符出现偶数次则可以构成回文串
        for(Map.Entry<Character, Integer> kv : counter.entrySet()){
            // 向下去字符出现的次数
            int count = kv.getValue();
            int rem = count % 2;
            res += count - rem;
            // 如果该字符出现的次数是奇数，重置为1
            if(rem == 1) odd = 1;
        }
        return res + odd;
    }
}
