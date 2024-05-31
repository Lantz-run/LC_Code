package com.Lantz2024.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra29
 * <p>Powered by Lantz On 2024-05-29 10:27:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra29
 * @since 1.8
 */
public class Pra29 {
}

/**
 * 2981. �ҳ������������ε���������ַ��� I
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ������СдӢ����ĸ��ɵ��ַ��� s ��
 *
 * ���һ���ַ������ɵ�һ�ַ���ɣ���ô������Ϊ ���� �ַ��������磬�ַ��� "abc" ���������ַ��������ַ��� "ddd"��"zz" �� "f" �������ַ�����
 *
 * ������ s �г��� �������� �� ��������ַ��� �ĳ��ȣ���������ڳ����������ε��������ַ������򷵻� -1 ��
 *
 * ���ַ��� ���ַ����е�һ������ �ǿ� �ַ����С�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "aaaa"
 * �����2
 * ���ͣ��������ε���������ַ����� "aa" �����ַ��� "aaaa"��"aaaa" �� "aaaa"��
 * ����֤����󳤶��� 2 ��
 * ʾ�� 2��
 *
 * ���룺s = "abcdef"
 * �����-1
 * ���ͣ������ڳ����������ε��������ַ�������˷��� -1 ��
 * ʾ�� 3��
 *
 * ���룺s = "abcaba"
 * �����1
 * ���ͣ��������ε���������ַ����� "a" �����ַ��� "abcaba"��"abcaba" �� "abcaba"��
 * ����֤����󳤶��� 1
 */


class Solution29 {
    public int maximumLength(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for(int i = 0; i < s.length; i++){
            cnt++;
            if(i + 1 == s.length || s[i] != s[i + 1]){
                groups[s[i] - 'a'].add(cnt); // ͳ�������ַ�����
                cnt = 0;
            }
        }

        int ans = 0;
        for(List<Integer> a : groups){
            if(a.isEmpty()) continue;
            a.sort(Collections.reverseOrder());
            a.add(0);
            a.add(0); // ���軹����λ�մ� )
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));

        }
        return ans > 0 ? ans : -1;

    }
}
