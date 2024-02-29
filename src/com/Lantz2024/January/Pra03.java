package com.Lantz2024.January;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra03
 * <p>Powered by Lantz On 2024-01-07 15:16:26
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra03
 * @since 1.8
 */
public class Pra03 {
    public static void main(String[] args) {

    }
}

/**
 * 20. 有效的括号
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 */
class Solution03 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('(', ')'); put('{', '}'); put('[', ']'); put('?', '?');
    }};
    public boolean isValid(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
        for(char c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}