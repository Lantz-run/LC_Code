package com.Lantz2024.April;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra18
 * <p>Powered by Lantz On 2024-04-18 08:54:28
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra18
 * @since 1.8
 */
public class Pra18 {

}

/**
 * 2007. ��˫�������л�ԭԭ����
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * һ���������� original ����ת���һ�� ˫�� ���� changed ��ת�䷽ʽΪ�� original ��ÿ��Ԫ�� ֵ���� 2 ���������У�Ȼ������Ԫ�� ������� ��
 *
 * ����һ������ changed ����� change �� ˫�� ���飬��ô���㷵�� original���飬�����뷵�ؿ����顣original ��Ԫ�ؿ����� ���� ˳�򷵻ء�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺changed = [1,3,4,2,6,8]
 * �����[1,3,4]
 * ���ͣ�һ�����ܵ� original ����Ϊ [1,3,4] :
 * - �� 1 ���� 2 ���õ� 1 * 2 = 2 ��
 * - �� 3 ���� 2 ���õ� 3 * 2 = 6 ��
 * - �� 4 ���� 2 ���õ� 4 * 2 = 8 ��
 * �������ܵ�ԭ���鷽��Ϊ [4,3,1] ���� [3,1,4] ��
 * ʾ�� 2��
 *
 * ���룺changed = [6,3,0,1]
 * �����[]
 * ���ͣ�changed ����һ��˫�����顣
 * ʾ�� 3��
 *
 * ���룺changed = [1]
 * �����[]
 * ���ͣ�changed ����һ��˫�����顣
 *
 */

class Solution18 {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int n = changed.length;
        int[] ans = new int[n / 2];
        int ansIdx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int x : changed){
            if(!q.isEmpty()){
                if(q.peek() < x){
                    return new int[0]; // �޷�ƥ��
                }
                if(q.peek() == x){ // ƥ�Գɹ�
                    q.poll(); // ������
                    continue;
                }
            }
            if(ansIdx == ans.length){
                return new int[0];
            }
            ans[ansIdx++] = x;
            q.offer(x * 2); // ���˫�����
        }
        return ans;
    }
}
