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
        multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i))); // ��λ
        System.out.println(multi);

        Solution08 solution08 = new Solution08();
        String s1 = "3[a2[c]]";
        String re = solution08.decodeString(s1);
        System.out.println(re);
    }
}

/**
 * 394. �ַ�������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ������������ַ������������������ַ�����
 *
 * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
 *
 * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
 *
 * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻������� 3a �� 2[4] �����롣
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "3[a]2[bc]"
 * �����"aaabcbc"
 * ʾ�� 2��
 *
 * ���룺s = "3[a2[c]]"
 * �����"accaccacc"
 * ʾ�� 3��
 *
 * ���룺s = "2[abc]3[cd]ef"
 * �����"abcabccdcdcdef"
 * ʾ�� 4��
 *
 * ���룺s = "abc3[cd]xyz"
 * �����"abccdcdcdxyz
 */
class Solution08 {
    public String decodeString(String s){
        return dfs(s, 0)[0];
    }
    // i ������
    public String[] dfs(String s, int i){
        StringBuilder res = new StringBuilder();
        int multi = 0; // ��λ
        while (i < s.length()){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i))); // ��λ
            }else if (s.charAt(i) == ']'){
                return new String[] {String.valueOf(i), res.toString()};
            } else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i+1); // ����'['�����µ�һ���ַ��������¼
                i = Integer.parseInt(tmp[0]); // ��������
                while (multi > 0){
                    res.append(tmp[1]); // ������Ϊ 0 ����'['
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