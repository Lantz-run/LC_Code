package com.Lantz2024.Krahets2023;

import java.util.HashMap;

/**
 * <p>Project: Algorithm20230913 - Pra11
 * <p>Powered by Lantz On 2024-02-08 23:42:52
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra11
 * @since 1.8
 */
public class Pra11 {

}

/**
 * 387. �ַ����еĵ�һ��Ψһ�ַ�
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ���ַ��� s ���ҵ� ���ĵ�һ�����ظ����ַ����������������� ����������ڣ��򷵻� -1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ����: s = "leetcode"
 * ���: 0
 * ʾ�� 2:
 *
 * ����: s = "loveleetcode"
 * ���: 2
 * ʾ�� 3:
 *
 * ����: s = "aabb"
 * ���: -1
 */
class Solution11 {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] cs = s.toCharArray();
        for(char c : cs){
            // �������������� c������������޸ļ�ֵ��Ϊ(c, False)������c > 1
            dic.put(c, !dic.containsKey(c));
        }
        for(int i = 0; i < cs.length; i++){
            if(dic.get(cs[i])){
                return i;
            }
        }
        return -1;
    }
}
