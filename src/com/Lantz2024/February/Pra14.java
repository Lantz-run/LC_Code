package com.Lantz2024.February;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra14
 * <p>Powered by Lantz On 2024-02-17 10:04:15
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra14
 * @since 1.8
 */
public class Pra14 {

}

/**
 * 429. N �����Ĳ������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ�� N ������������ڵ�ֵ�Ĳ�����������������ң�����������
 *
 * �������л��������ò��������ÿ���ӽڵ㶼�� null ֵ�ָ����μ�ʾ������
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [1,null,3,2,4,null,5,6]
 * �����[[1],[3,2,4],[5,6]]
 * ʾ�� 2��
 *
 *
 *
 * ���룺root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * �����[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
class Solution14 {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> vals = new ArrayList<>();
            int n = q.size();
            while(n-- > 0){
                Node node = q.poll();
                vals.add(node.val);
                q.addAll(node.children);
            }
            ans.add(vals);
        }
        return ans;
    }
}
