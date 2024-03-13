package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra06
 * <p>Powered by Lantz On 2024-03-07 15:17:50
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra06
 * @since 1.8
 */
public class Pra06 {

}

/**
 * 2575. �ҳ��ַ����Ŀ���������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ���ַ��� word ������Ϊ n ���ɴ� 0 �� 9 ��������ɡ������һ�������� m ��
 *
 * word �� ���������� div  ��һ������Ϊ n ���������飬�����㣺
 *
 * ��� word[0,...,i] ����ʾ�� ��ֵ �ܱ� m ������div[i] = 1
 * ����div[i] = 0
 * ���� word �Ŀ��������顣
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺word = "998244353", m = 3
 * �����[1,1,0,0,0,1,1,0,0]
 * ���ͣ����� 4 ��ǰ׺���Ա� 3 ������"9"��"99"��"998244" �� "9982443" ��
 * ʾ�� 2��
 *
 * ���룺word = "1010", m = 10
 * �����[0,1,0,1]
 * ���ͣ����� 2 ��ǰ׺���Ա� 10 ������"10" �� "1010" ��
 */
class Solution06 {
    public int[] divisibilityArray(String word, int m) {
        char[] w = word.toCharArray();
        int[] ans = new int[w.length];
        long x = 0;
        for(int i = 0; i < w.length; i++){
            x = (x * 10 + (w[i] - '0')) % m; // ��ȡģ ���ӣ�9*10 + 8 --- 9*10 ���Ա� 3��m���������� 8 �����ԣ����� 9*10 + 8 �����Ա� 3 ����
            if(x == 0){
                ans[i] = 1;
            }
        }
        return ans;
    }
}
