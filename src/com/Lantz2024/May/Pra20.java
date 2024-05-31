package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra20
 * <p>Powered by Lantz On 2024-05-20 15:04:56
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra20
 * @since 1.8
 */
public class Pra20 {
}

/**
 * 1542. �ҳ���ĳ������ַ���
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���ַ��� s ���뷵�� s ����� �������ַ��� �ĳ��ȡ�
 *
 * ���������ַ�����������������������������
 *
 * ���ַ����� s ��һ���ǿ����ַ���
 * ��������������ַ������󣬸��ַ������Ա��һ�������ַ���
 *
 *
 * ʾ�� 1��
 *
 * ���룺s = "3242415"
 * �����5
 * ���ͣ�"24241" ����ĳ������ַ������������е��ַ��󣬿��Եõ����� "24142"
 * ʾ�� 2��
 *
 * ���룺s = "12345678"
 * �����1
 * ʾ�� 3��
 *
 * ���룺s = "213123"
 * �����6
 * ���ͣ�"213123" ����ĳ������ַ������������е��ַ��󣬿��Եõ����� "231132"
 * ʾ�� 4��
 *
 * ���룺s = "00"
 * �����2
 */

class Solution20 {
    private static final int D = 10; // s �е��ַ�������

    public int longestAwesome(String s) {
        int n = s.length();
        int[] pos = new int[1 << D];
        Arrays.fill(pos, n);
        pos[0] = -1; // pre[-1] = 0
        int ans = 0;
        int pre = 0;
        for(int i = 0; i < n; i++){
            pre ^= 1 << (s.charAt(i) - '0');
            for(int d = 0; d < D; d++){
                ans = Math.max(ans, i - pos[pre ^ (1 << d)]); // ����
            }
            ans = Math.max(ans, i - pos[pre]); // ż��
            if(pos[pre] == n){ // �״�����ֵΪ pre ��ǰ׺���ͣ���¼���±� i
                pos[pre] = i;
            }
        }
        return ans;
    }
}
