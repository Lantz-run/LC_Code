package com.Lantz2023.OctoberPra;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode�����⣺���ظ��ַ�����Ӵ�
 *
 * ����һ���ַ��� s �������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 *
 * ʾ�� 1:
 * ����: s = "abcabcbb"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 *
 *  ʾ�� 2:
 * ����: s = "bbbbb"
 * ���: 1
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 *
 *  ʾ�� 3:
 * ����: s = "pwwkew"
 * ���: 3
 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
 *      ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���
 */
public class Pra03 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String str = "abcabcdab";
        int result = solution3.lengthOfLongestSubstring(str);
        System.out.println(result);
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>(); // ���ڿ��ٲ��Һͼ�¼
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))){ //charAt():����ָ����������charֵ
               left = Math.max(left, hashMap.get(s.charAt(i))+1); //
            }
            // �����Ƿ����left����Ҫ����s.charAt(i)��λ�ã���ΪҪ��ȡ��������ַ�
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}

class Solution3_1{
    public int length(String str){

        if (str.length() == 0) return 0;

        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))){
                left = Math.max(left, hashMap.get(str.charAt(i))+1);
            }
            hashMap.put(str.charAt(i), i);
            max = Math.max(max, i-left+1);
        }

        return max;
    }
}