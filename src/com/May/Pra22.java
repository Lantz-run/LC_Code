package com.Lantz2024.May;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra22
 * <p>Powered by Lantz On 2024-05-22 14:56:42
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra22
 * @since 1.8
 */
public class Pra22 {
}

/**
 * 2225. �ҳ�����㳡��һ�����������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���������� matches ���� matches[i] = [winneri, loseri] ��ʾ��һ�������� winneri ������ loseri ��
 *
 * ����һ������Ϊ 2 ���б� answer ��
 *
 * answer[0] ������ û�� ����κα���������б�
 * answer[1] ������ǡ����� һ�� ����������б�
 * �����б��е�ֵ��Ӧ�ð� ���� ˳�򷵻ء�
 *
 * ע�⣺
 *
 * ֻ������Щ���� ����һ�� ��������ҡ�
 * ���ɵĲ���������֤ ������ ����������� ��ͬ ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * �����[[1,2,10],[4,5,7,8]]
 * ���ͣ�
 * ��� 1��2 �� 10 ��û������κα�����
 * ��� 4��5��7 �� 8 ÿ�������һ��������
 * ��� 3��6 �� 9 ÿ�����������������
 * ��ˣ�answer[0] = [1,2,10] �� answer[1] = [4,5,7,8] ��
 * ʾ�� 2��
 *
 * ���룺matches = [[2,3],[1,3],[5,4],[6,4]]
 * �����[[1,2,5,6],[]]
 * ���ͣ�
 * ��� 1��2��5 �� 6 ��û������κα�����
 * ��� 3 �� 4 ÿ�����������������
 * ��ˣ�answer[0] = [1,2,5,6] �� answer[1] = [] ��
 */

class Solution22 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();
        for(int[] m : matches){
            if(!lossCount.containsKey(m[0])){
                lossCount.put(m[0], 0);
            }
            lossCount.merge(m[1], 1, Integer::sum);
        }

        List<List<Integer>> ans = List.of(new ArrayList<>(), new ArrayList<>());
        for(Map.Entry<Integer, Integer> e : lossCount.entrySet()){
            int cnt = e.getValue();
            if(cnt < 2){
                ans.get(cnt).add(e.getKey());
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}