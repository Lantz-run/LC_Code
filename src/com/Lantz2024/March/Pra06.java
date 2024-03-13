package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra06
 * <p>Powered by Lantz On 2024-03-07 15:17:50
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra06
 * @since 1.8
 */
public class Pra06 {

}

/**
 * 2575. 找出字符串的可整除数组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 *
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 *
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word = "998244353", m = 3
 * 输出：[1,1,0,0,0,1,1,0,0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 示例 2：
 *
 * 输入：word = "1010", m = 10
 * 输出：[0,1,0,1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 */
class Solution06 {
    public int[] divisibilityArray(String word, int m) {
        char[] w = word.toCharArray();
        int[] ans = new int[w.length];
        long x = 0;
        for(int i = 0; i < w.length; i++){
            x = (x * 10 + (w[i] - '0')) % m; // 用取模 例子：9*10 + 8 --- 9*10 可以被 3（m）整除，但 8 不可以，所以 9*10 + 8 不可以被 3 整除
            if(x == 0){
                ans[i] = 1;
            }
        }
        return ans;
    }
}
