package com.Lantz2024.February;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra11
 * <p>Powered by Lantz On 2024-02-14 14:11:14
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra11
 * @since 1.8
 */
public class Pra11 {

}

/**
 * 102. �������Ĳ������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����������ĸ��ڵ� root ��������ڵ�ֵ�� ������� �� �������أ������ҷ������нڵ㣩��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [3,9,20,null,null,15,7]
 * �����[[3],[9,20],[15,7]]
 * ʾ�� 2��
 *
 * ���룺root = [1]
 * �����[[1]]
 * ʾ�� 3��
 *
 * ���룺root = []
 * �����[]
 */
class Solution11 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // ���ö���
        if(root == null) return List.of(); // ֱ�ӷ���
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
        return ans;
    }

}
