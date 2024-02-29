package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra15
 * <p>Powered by Lantz On 2024-02-18 10:01:12
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra15
 * @since 1.8
 */
public class Pra15 {

}

/**
 * 589. N ������ǰ�����
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ����һ�� n �����ĸ��ڵ�  root ������ ��ڵ�ֵ�� ǰ����� ��
 *
 * n ���� �������а���������������л���ʾ��ÿ���ӽڵ��ɿ�ֵ null �ָ�����μ�ʾ������
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [1,null,3,2,4,null,5,6]
 * �����[1,3,5,6,2,4]
 * ʾ�� 2��
 *
 *
 *
 * ���룺root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * �����[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
class Solution15 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    private void dfs(Node node, List<Integer> res){
        if(node == null) return;
        res.add(node.val);
        for(Node n : node.children){
            dfs(n, res);
        }
    }
}
