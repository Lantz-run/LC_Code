package com.Lantz2024.Krahets2023;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra12
 * <p>Powered by Lantz On 2024-02-09 21:01:18
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra12
 * @since 1.8
 */
public class Pra12 {

}

/**
 * 205. ͬ���ַ���
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ���������ַ��� s �� t ���ж������Ƿ���ͬ���ġ�
 *
 * ��� s �е��ַ����԰�ĳ��ӳ���ϵ�滻�õ� t ����ô�������ַ�����ͬ���ġ�
 *
 * ÿ�����ֵ��ַ���Ӧ��ӳ�䵽��һ���ַ���ͬʱ���ı��ַ���˳�򡣲�ͬ�ַ�����ӳ�䵽ͬһ���ַ��ϣ���ͬ�ַ�ֻ��ӳ�䵽ͬһ���ַ��ϣ��ַ�����ӳ�䵽�Լ�����
 *
 *
 *
 * ʾ�� 1:
 *
 * ���룺s = "egg", t = "add"
 * �����true
 * ʾ�� 2��
 *
 * ���룺s = "foo", t = "bar"
 * �����false
 * ʾ�� 3��
 *
 * ���룺s = "paper", t = "title"
 * �����true
 */
class Solution12 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i), b = t.charAt(i);
            // �ж������ַ������ַ��Ƿ�Ϊһ�Զ���������������ü�ֵ�������
            if(s2t.containsKey(a) && s2t.get(a) != b ||
                    t2s.containsKey(b) && t2s.get(b) != a){
                return false;
            }
            // s2t: a->b, t2s: b->a
            s2t.put(a, b);
            t2s.put(b, a);
        }
        return true;
    }
}