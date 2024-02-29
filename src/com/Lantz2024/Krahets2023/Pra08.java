package com.Lantz2024.Krahets2023;

/**
 * <p>Project: Algorithm20230913 - Pra08
 * <p>Powered by Lantz On 2024-01-29 23:44:22
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra08
 * @since 1.8
 */
public class Pra08 {
    public static void main(String[] args) {
        int multi = 0;
        String s = "3[a]2[bc]";
        int i = 4;
        multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i))); // 扩位
        System.out.println(multi);

        Solution08 solution08 = new Solution08();
        String s1 = "3[a2[c]]";
        String re = solution08.decodeString(s1);
        System.out.println(re);
    }
}

/**
 * 394. 字符串解码
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz
 */
class Solution08 {
    public String decodeString(String s){
        return dfs(s, 0)[0];
    }
    // i 是索引
    public String[] dfs(String s, int i){
        StringBuilder res = new StringBuilder();
        int multi = 0; // 进位
        while (i < s.length()){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i))); // 扩位
            }else if (s.charAt(i) == ']'){
                return new String[] {String.valueOf(i), res.toString()};
            } else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i+1); // 遇到'['就用新的一个字符串数组记录
                i = Integer.parseInt(tmp[0]); // 更新索引
                while (multi > 0){
                    res.append(tmp[1]); // 因索引为 0 的是'['
                    multi--;
                }
            }else{
                res.append(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        return new String[] {res.toString()};
    }
}