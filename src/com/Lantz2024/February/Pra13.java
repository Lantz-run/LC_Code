package com.Lantz2024.February;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra13
 * <p>Powered by Lantz On 2024-02-16 11:12:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra13
 * @since 1.8
 */
public class Pra13 {

}

/**
 * 103. �������ľ���β������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����������ĸ��ڵ� root ��������ڵ�ֵ�� ����β������ �������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [3,9,20,null,null,15,7]
 * �����[[3],[20,9],[15,7]]
 * ʾ�� 2��
 *
 * ���룺root = [1]
 * �����[[1]]
 * ʾ�� 3��
 *
 * ���룺root = []
 * �����[]
 */
class Solution13 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        // ����ż����ͷ�ת
        for(boolean flag = false; !q.isEmpty(); flag = !flag){
            int n = q.size();
            List<Integer> vals = new ArrayList<>();
            while(n-- > 0){
                TreeNode node = q.poll();
                vals.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(flag) Collections.reverse(vals);
            ans.add(vals);
        }
        return ans;

    }
}
