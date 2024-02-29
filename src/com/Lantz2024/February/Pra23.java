package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra23
 * <p>Powered by Lantz On 2024-02-25 17:05:38
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra23
 * @since 1.8
 */
public class Pra23 {

}
class Solution23 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         ��������������Ϊ�գ��������������нڵ��ֵ��С�ڸ��ڵ��ֵ
         ��������������Ϊ�գ��������������нڵ��ֵ�����ڸ��ڵ��ֵ
         ������������Ҳ�ֱ�Ϊ����������
         */
        int x = root.val;
        if(p.val < x && q.val < x){ // p, q ����������
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > x && q.val > x){ // p, q ����������
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // ����

    }
}
