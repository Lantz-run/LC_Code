package com.Lantz2023.December;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra01
 * <p>Powered by Lantz On 2023-12-16 21:44:32
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra01
 * @since 1.8
 *
 * LeetCode17: 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class Pra01 {
    public static void main(String[] args) {
        Solution01_1 solution01 = new Solution01_1();
        String digits = "23";
        List<String> result = solution01.letterCombinations(digits);
        System.out.println(result);
    }
}

class Solution01 {

    String[] words = {" ", "*","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }
    List<String> res = new ArrayList<>();
    // 递归方法
    void iterStr(String str, StringBuilder letter, int index){
        if (index == str.length()){
            res.add(letter.toString());
            return;
        }
        char c = str.charAt(index);
        int pos = c - '0'; // 可以获取对应的下标
        String string = words[pos];
        // 循环使用递归
        for (int i = 0; i < string.length(); i++) {
            letter.append(string.charAt(i));
            iterStr(str, letter, index+1);
            letter.deleteCharAt(letter.length()-1); // 每次递归之后都要把已经递归过的字母给删了，要不就会有重复字母出现
            // 比如abc(1)和def(2)a和d,e,f都组合了，就要把a给删除，虽然

        }
    }
}

class Solution01_1{
    String[] str_letters = {" ", "*","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits){
        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        iterStr(digits, new StringBuilder(), 0);
        return res;
    }
    List<String> res = new ArrayList<>();
    void iterStr(String str, StringBuilder letter, int index){
        if (index == str.length()){
            res.add(letter.toString());
            return;
        }
        char c = str.charAt(index);
        int pos = c - '0';
        String string = str_letters[pos];
        for (int i = 0; i < string.length(); i++) {
            letter.append(string.charAt(i)); // 将字符数组转成字符拼接起来
            iterStr(str, letter, index+1); // 开始递归
            letter.deleteCharAt(letter.length()-1);
        }
    }
}
