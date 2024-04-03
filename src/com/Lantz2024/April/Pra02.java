package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2024-04-02 15:25:59
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 */
public class Pra02 {

}

/**
 * 894. ���п��ܵ��������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ������ n �������ҳ����п��ܺ� n ���ڵ�� ������� �������б���ʽ���ء�����ÿ������ÿ���ڵ㶼������� Node.val == 0 ��
 *
 * �𰸵�ÿ��Ԫ�ض���һ����������ĸ��ڵ㡣����԰� ����˳�� �������յ���������б�
 *
 * ������� ��һ�������������ÿ���ڵ�ǡ���� 0 �� 2 ���ӽڵ㡣
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺n = 7
 * �����[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
 * [0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * ʾ�� 2��
 *
 * ���룺n = 3
 * �����[[0,0,0]]
 *
 *
 * ��ʾ��
 *
 * 1 <= n <= 20
 */
class Solution02 {
    private static final List<TreeNode>[] f = new ArrayList[11];
    static {
        Arrays.setAll(f, i -> new ArrayList<>());
        f[1].add(new TreeNode());
        for (int i = 2; i < f.length; i++) { // ����f[i]
            for (int j = 1; j < i; j++) { // ö��������Ҷ����
                for (TreeNode left : f[j]) { // ö��������
                    for (TreeNode right : f[i - j]) { // ö��������
                        f[i].add(new TreeNode(0, left, right));
                    }
                }
            }
        }

    }

    public List<TreeNode> allPossibleFBT(int n) {
        return f[n % 2 > 0 ? (n + 1) / 2 : 0];
    }
}
