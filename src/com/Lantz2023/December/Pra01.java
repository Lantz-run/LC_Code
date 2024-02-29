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
 * LeetCode17: �绰�������ĸ���
 *
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 *
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 *
 * ʾ�� 1��
 *
 * ���룺digits = "23"
 * �����["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * ʾ�� 2��
 *
 * ���룺digits = ""
 * �����[]
 * ʾ�� 3��
 *
 * ���룺digits = "2"
 * �����["a","b","c"]
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
    // �ݹ鷽��
    void iterStr(String str, StringBuilder letter, int index){
        if (index == str.length()){
            res.add(letter.toString());
            return;
        }
        char c = str.charAt(index);
        int pos = c - '0'; // ���Ի�ȡ��Ӧ���±�
        String string = words[pos];
        // ѭ��ʹ�õݹ�
        for (int i = 0; i < string.length(); i++) {
            letter.append(string.charAt(i));
            iterStr(str, letter, index+1);
            letter.deleteCharAt(letter.length()-1); // ÿ�εݹ�֮��Ҫ���Ѿ��ݹ������ĸ��ɾ�ˣ�Ҫ���ͻ����ظ���ĸ����
            // ����abc(1)��def(2)a��d,e,f������ˣ���Ҫ��a��ɾ������Ȼ

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
            letter.append(string.charAt(i)); // ���ַ�����ת���ַ�ƴ������
            iterStr(str, letter, index+1); // ��ʼ�ݹ�
            letter.deleteCharAt(letter.length()-1);
        }
    }
}
