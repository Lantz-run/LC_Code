package com.Lantz2024.May;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra28
 * <p>Powered by Lantz On 2024-05-28 10:07:28
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra28
 * @since 1.8
 */
public class Pra28 {
}

/**
 * 2951. �ҳ���ֵ
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ������ mountain ������������ҳ����� mountain �е����� ��ֵ��
 *
 * ��������ʽ���ظ��������� ��ֵ ���±꣬˳���� ��
 *
 * ע�⣺
 *
 * ��ֵ ��ָһ���ϸ����������Ԫ�ص�Ԫ�ء�
 * ����ĵ�һ�������һ��Ԫ�� �� �Ƿ�ֵ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺mountain = [2,4,4]
 * �����[]
 * ���ͣ�mountain[0] �� mountain[2] �������Ƿ�ֵ����Ϊ����������ĵ�һ�������һ��Ԫ�ء�
 * mountain[1] Ҳ�������Ƿ�ֵ����Ϊ�����ϸ���� mountain[2] ��
 * ��ˣ���Ϊ [] ��
 * ʾ�� 2��
 *
 * ���룺mountain = [1,4,3,8,5]
 * �����[1,3]
 * ���ͣ�mountain[0] �� mountain[4] �������Ƿ�ֵ����Ϊ����������ĵ�һ�������һ��Ԫ�ء�
 * mountain[2] Ҳ�������Ƿ�ֵ����Ϊ�����ϸ���� mountain[3] �� mountain[1] ��
 * ���� mountain[1] �� mountain[3] �ϸ�������ǵ�����Ԫ�ء�
 * ��ˣ����� [1,3]
 */


class Solution28 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < mountain.length - 1; i++){
            if(mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]){
                ans.add(i);
            }
        }
        return ans;
    }
}
