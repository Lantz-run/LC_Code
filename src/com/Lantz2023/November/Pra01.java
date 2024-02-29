package com.Lantz2023.November;

/**
 * LeetCode第十题： 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3：
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 *
 * 提示：
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 */
public class Pra01 {
    public static void main(String[] args) {

        Solution01 solution01 = new Solution01();
        String s = "";
        String p = "a*";
        boolean result = solution01.isMatch(s, p);
        System.out.println(result);
    }
}

class Solution01 {
    public boolean isMatch(String s, String p) {
        // 转换为一个字符数组能更好地获取下标
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = p.toCharArray();

        // 使用二维数组对s，p两个字符串是否能够匹配
        boolean[][] dp = new boolean[charArray1.length + 1][charArray2.length + 1];

        /**
         * base case: 是用p去匹配s
         *  case1：s, p 都为空 -> 肯定能够匹配
         *  case2：s为空，p不为空 -> 这个要看 p是否带有'.' or '*'
         *  case3：s不为空，p为空 -> 这个不匹配，因为根据题意，匹配的成与否是由 p决定的
         */
        dp[0][0] = true; // 两个字符串都是空，能够匹配上

        // case2
        for (int j = 1; j <= charArray2.length; j++) {
            if (charArray2[j-1] == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        /**
         * !!!: '*' 匹配零个或多个前面的那一个元素, 那一个元素指的就是这个星号所在的那一串字符串的元素，而不是另外一个字符串（s）的元素
         */
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                if (charArray1[i-1] == charArray2[j-1] || charArray2[j-1] =='.'){
                    dp[i][j] = dp[i-1][j-1]; // a1-例子：s="aab", p="aabb*"

                } else if (charArray2[j-1] == '*') { // a2-例子：s="aab",p="aab*"
                    if (charArray1[i-1] == charArray2[j-2] || charArray2[j-2] == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j]; // '*'匹配一次或者多次的情况

                    }else {
                        dp[i][j] = dp[i][j-2]; // a3-例子: s="aabb"（或s="aabbb"都行）,p="aab*"
                    }

                }
            }
        }

        return dp[charArray1.length][charArray2.length];
    }
}

class Solution01_1{
    public boolean isMatch(String s, String p){
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        /**
         * base case: 是用p去匹配s
         *  case1：s, p 都为空 -> 肯定能够匹配
         *  case2：s为空，p不为空 -> 这个要看 p是否带有'.' or '*'
         *  case3：s不为空，p为空 -> 这个不匹配，因为根据题意，匹配的成与否是由 p决定的
         */
        boolean dp[][] = new boolean[cs.length+1][cp.length+1];
        dp[0][0] = true;
        // case2: s="", p="ab*c"
        for (int i = 1; i <= cp.length; i++) {
            if (cp[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i = 1; i <= cs.length; i++) {
            for (int j = 0; j <= cp.length; j++) {

            }
        }
        

        return false;
    }
}
