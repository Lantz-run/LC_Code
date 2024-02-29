package com.Lantz2024.February;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra12
 * <p>Powered by Lantz On 2024-02-15 09:46:10
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra12
 * @since 1.8
 */
public class Pra12 {

}

/**
 * 107. �������Ĳ������ II
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����������ĸ��ڵ� root ��������ڵ�ֵ �Ե����ϵĲ������ �� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [3,9,20,null,null,15,7]
 * �����[[15,7],[9,20],[3]]
 * ʾ�� 2��
 *
 * ���룺root = [1]
 * �����[[1]]
 * ʾ�� 3��
 *
 * ���룺root = []
 * �����[]
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> vals = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = q.poll();
                vals.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

            }
            ans.add(vals);
        }
        Collections.reverse(ans); // �����ֱ�ӷ�ת
        return ans;
    }
}
