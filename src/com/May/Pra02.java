package com.Lantz2024.May;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2024-05-02 09:51:47
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 */
public class Pra02 {
}

/**
 * 857. ��Ӷ K �����˵���ͳɱ�
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * �� n �����ˡ� ������������ quality �� wage �����У�quality[i] ��ʾ�� i �����˵Ĺ����������������������Ϊ wage[i] ��
 *
 * �����������Ӷ k ���������һ�������顣�ڹ�Ӷ һ�� k ������ʱ�����Ǳ��밴����������������֧�����ʣ�
 *
 * �Թ������е�ÿ�����ˣ�Ӧ�����乤��������ͬ���������˵Ĺ��������ı�����֧�����ʡ�
 * �������е�ÿ����������Ӧ���õ����ǵ�����������ʡ�
 * �������� k ������ ����������������ĸ���Ⱥ���������С��� ����ʵ�ʴ𰸵� 10-5 ���ڵĴ𰸽������ܡ���
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺 quality = [10,20,5], wage = [70,50,30], k = 2
 * ����� 105.00000
 * ���ͣ� ������ 0 �Ź���֧�� 70���� 2 �Ź���֧�� 35��
 * ʾ�� 2��
 *
 * ���룺 quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
 * ����� 30.66667
 * ���ͣ� ������ 0 �Ź���֧�� 4���� 2 �ź� 3 �ŷֱ�֧�� 13.33333��
 */

class Solution02 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] id = new Integer[n];
        Arrays.setAll(id, i -> i);
        // ���� r ֵ����
        Arrays.sort(id, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sumQ = 0;
        for(int i = 0; i < k; i++){
            pq.offer(quality[id[i]]);
            sumQ += quality[id[i]];
        }

        // ѡ r ֵ��С�� k ������
        double ans = sumQ * ((double)wage[id[k - 1]] / quality[id[k - 1]]);

        // ����Ĺ��� r ֵ����
        // ���� sumQ ���Ա�С���Ӷ����ܵõ����ŵĴ�
        for(int i = k; i < n; i++){
            int q = quality[id[i]];
            if(q < pq.peek()){
                sumQ -= pq.poll() - q;
                pq.offer(q);
                ans = Math.min(ans, sumQ * ((double)wage[id[i]] / q));
            }
        }
        return ans;
    }
}
