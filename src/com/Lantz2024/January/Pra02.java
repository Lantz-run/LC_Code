package com.Lantz2024.January;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2024-01-07 09:01:30
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 */
public class Pra02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        String r = "aa";
        String m = "aab";
        boolean result = solution02.canConstruct(r, m);
        System.out.println(result);
    }
}

class Solution02 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[30];
        // c - 'a' ���ַ� c ת��Ϊһ���� 0 �� 25 ������
        for(char c : magazine.toCharArray()) cnt[c-'a']++;
        // ���ʳ��ֵ�Ƶ���Ƿ�Ϊ���������ǿ�r:"aa"���ֵĴ����Ƿ��m�е���ȣ���Ⱦ͵���ƥ���ˣ������
        // m�г����˸������Ǿ�˵��r�е��ַ����˾ͱ���eg2�����
        for(char c : ransomNote.toCharArray()) if(--cnt[c-'a'] < 0) return false;
        return true;
    }
}
