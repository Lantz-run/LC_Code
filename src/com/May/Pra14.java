package com.Lantz2024.May;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra14
 * <p>Powered by Lantz On 2024-05-14 15:56:28
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra14
 * @since 1.8
 */
public class Pra14 {
}

/**
 * 2244. �������������Ҫ����������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ���������� tasks ������ tasks[i] ��ʾ������Ѷȼ�����ÿһ���У��������� 2 ������ 3 �� ��ͬ�Ѷȼ��� ������
 *
 * �����������������Ҫ�� ���� ����������޷�����������񣬷��� -1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺tasks = [2,2,3,3,2,4,4,4,4,4]
 * �����4
 * ���ͣ�Ҫ�������������һ�����ܵļƻ��ǣ�
 * - ��һ�֣�����Ѷȼ���Ϊ 2 �� 3 ������
 * - �ڶ��֣�����Ѷȼ���Ϊ 3 �� 2 ������
 * - �����֣�����Ѷȼ���Ϊ 4 �� 3 ������
 * - �����֣�����Ѷȼ���Ϊ 4 �� 2 ������
 * ����֤�����޷������� 4 �ֵ��������������������Դ�Ϊ 4 ��
 * ʾ�� 2��
 *
 * ���룺tasks = [2,3,3]
 * �����-1
 * ���ͣ��Ѷȼ���Ϊ 2 ������ֻ�� 1 ������ÿһ��ִ���У�ֻ��ѡ����� 2 ������ 3 ����ͬ�Ѷȼ����������ˣ��޷�����������񣬴�Ϊ -1 ��
 */

class Solution14 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int t : tasks){
            cnt.merge(t, 1, Integer::sum);
        }
        int ans = 0;
        for(int c : cnt.values()){
            if(c == 1){
                return -1;
            }
            ans += (c + 2) / 3;
        }
        return ans;
    }
}