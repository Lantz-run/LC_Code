package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra17
 * <p>Powered by Lantz On 2024-05-17 12:01:24
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra17
 * @since 1.8
 */
public class Pra17 {
}

/**
 * 826. ���Ź����Դﵽ�������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ���� n �������� m �����ˡ������������飺 difficulty, profit �� worker ������:
 *
 * difficulty[i] ��ʾ�� i ���������Ѷȣ�profit[i] ��ʾ�� i �����������档
 * worker[i] �ǵ� i �����˵����������ù���ֻ������Ѷ�С�ڵ��� worker[i] �Ĺ�����
 * ÿ������ ��� ֻ�ܰ��� һ�� ����������һ���������� ��ɶ�� ��
 *
 * �ٸ����ӣ���� 3 �����˶��������һ�ݱ���Ϊ $1 ��ͬ����������ô������Ϊ $3 �����һ�����˲�������κι�������������Ϊ $0 ��
 * ���� �ڰѹ��˷��䵽������λ���������ܻ�õ�������� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ����: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * ���: 100
 * ����: ���˱�����Ĺ����Ѷ��� [4,4,6,6] ���ֱ��� [20,20,30,30] �����档
 * ʾ�� 2:
 *
 * ����: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * ���:
 */

class Solution17 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for(int i = 0; i < n; i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker); // ��С��������

        // ˫ָ��
        int ans = 0, j = 0, maxProfix = 0;
        for(int w : worker){
            while(j < n && jobs[j][0] <= w){
                maxProfix = Math.max(maxProfix, jobs[j++][1]);
            }
            ans += maxProfix;
        }
        return ans;
    }
}
