package com.Lantz2024.January;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra03
 * <p>Powered by Lantz On 2024-01-07 15:16:26
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra03
 * @since 1.8
 */
public class Pra03 {
    public static void main(String[] args) {

    }
}

/**
 * 20. ��Ч������
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ��� s ���ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 *
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ÿ�������Ŷ���һ����Ӧ����ͬ���͵������š�
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "()"
 * �����true
 * ʾ�� 2��
 *
 * ���룺s = "()[]{}"
 * �����true
 * ʾ�� 3��
 *
 * ���룺s = "(]"
 * �����false
 */
class Solution03 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('(', ')'); put('{', '}'); put('[', ']'); put('?', '?');
    }};
    public boolean isValid(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
        for(char c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}