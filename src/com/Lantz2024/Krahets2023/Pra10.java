package com.Lantz2024.Krahets2023;

import java.util.HashMap;

/**
 * <p>Project: Algorithm20230913 - Pra10
 * <p>Powered by Lantz On 2024-02-07 23:38:58
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra10
 * @since 1.8
 */
public class Pra10 {

}

/**
 *
 ����
 ��������
 ��������
 ���Խ��
 242. ��Ч����ĸ��λ��
 �ѽ��
 ��
 ��ر�ǩ
 �����ҵ
 ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�

 ע�⣺�� s �� t ��ÿ���ַ����ֵĴ�������ͬ����� s �� t ��Ϊ��ĸ��λ�ʡ�



 ʾ�� 1:

 ����: s = "anagram", t = "nagaram"
 ���: true
 ʾ�� 2:

 ����: s = "rat", t = "car"
 ���: false
 */
class Solution10 {
    // ͨ����ϣ����ַ��������ж���ĸ��λ��
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if(n1 != n2) return false;
        HashMap<Character, Integer> dic = new HashMap<>();
        // ��ϣ���и����ַ���һ
        for(int i = 0; i < n1; i++){
            dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0) + 1);
        }
        // ��ϣ���и����ַ���һ
        for(int i = 0; i < n2; i++){
            dic.put(t.charAt(i), dic.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int val : dic.values()){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
