package com.Lantz2024.Krahets2023;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra13
 * <p>Powered by Lantz On 2024-02-17 10:51:43
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra13
 * @since 1.8
 */
public class Pra13 {

}

/**
 * 409. ����Ĵ�
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ��������д��ĸ��Сд��ĸ���ַ��� s ������ ͨ����Щ��ĸ����ɵ� ��Ļ��Ĵ� ��
 *
 * �ڹ�������У���ע�� ���ִ�Сд ������ "Aa" ���ܵ���һ�������ַ�����
 *
 *
 *
 * ʾ�� 1:
 *
 * ����:s = "abccccdd"
 * ���:7
 * ����:
 * ���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
 * ʾ�� 2:
 *
 * ����:s = "a"
 * ���:1
 * ʾ�� 3��
 *
 * ����:s = "aaaaaccc"
 * ���:7
 */
class Solution13 {
    public int longestPalindrome(String s) {
        // ͳ��ÿһ���ַ����ֵĴ���
        HashMap<Character, Integer> counter = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            counter.merge(s.charAt(i), 1, (a, b) -> a + b);
        }
        int res = 0, odd = 0; // ���ĳ���ַ�����ż��������Թ��ɻ��Ĵ�
        for(Map.Entry<Character, Integer> kv : counter.entrySet()){
            // ����ȥ�ַ����ֵĴ���
            int count = kv.getValue();
            int rem = count % 2;
            res += count - rem;
            // ������ַ����ֵĴ���������������Ϊ1
            if(rem == 1) odd = 1;
        }
        return res + odd;
    }
}
