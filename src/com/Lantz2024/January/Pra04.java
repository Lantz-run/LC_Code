package com.Lantz2024.January;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-01-17 12:27:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {
    public static void main(String[] args) {

    }
}

/**
 * 22. 括号生成
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
class Solution04 {
    private int n;
    private char[] path;
    private final List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2];
        dfs(0, 0);
        return ans;
    }
    public void dfs(int i, int open){ // open是左括号的数目
        if(i == n * 2){ // 边界条件，当i等于2n时, 构造字符串
            ans.add(new String(path));
            return;
        }
        if(open < n){ // 左括号
            path[i] = '(';
            dfs(i+1, open+1);
        }
        if(i-open < open){ // 右括号小于左括号的数目，就选右括号
            path[i] = ')';
            dfs(i+1, open);
        }
    }
}