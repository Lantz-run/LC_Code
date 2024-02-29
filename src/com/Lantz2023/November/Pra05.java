package com.Lantz2023.November;

/**
 * LeetCode��ʮ���⣺�����ǰ׺
 *
 * ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 *
 * ʾ�� 1��
 *
 * ���룺strs = ["flower","flow","flight"]
 * �����"fl"
 * ʾ�� 2��
 *
 * ���룺strs = ["dog","racecar","car"]
 * �����""
 * ���ͣ����벻���ڹ���ǰ׺��
 */
public class Pra05 {
    public static void main(String[] args) {

        Solution05 solution05 = new Solution05();
        String[] strs = {"flower","flow","flight"};
        String result = solution05.longestCommonPrefix(strs);
        System.out.println(result);
    }
}

class Solution05 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        String ans = strs[0]; // ���һ���ַ�����Ϊһ�����Բ��յĶ��󣬾��ǿ��Է������Ե��ַ������б����Ƚ��ҳ������ǰ׺
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // ���ܳ����ַ������������һ���Ӵ��ĳ���
            for (; j < ans.length() && j < strs[i].length(); j++) {

                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
            // �����һ���ַ������ڿմ����Ǿ�û�й���ǰ׺
            if (ans.equals("")){
                return ans;
            }
        }
        return ans;

    }
}