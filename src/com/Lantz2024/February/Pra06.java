package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra06
 * <p>Powered by Lantz On 2024-02-09 20:32:05
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra06
 * @since 1.8
 */
public class Pra06 {

}

/**
 * 236. �������������������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 *
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T �������ڵ� p��q������������ȱ�ʾΪһ���ڵ� x��
 * ���� x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * �����3
 * ���ͣ��ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3 ��
 * ʾ�� 2��
 *
 *
 * ���룺root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * �����5
 * ���ͣ��ڵ� 5 �ͽڵ� 4 ��������������ǽڵ� 5 ����Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��
 * ʾ�� 3��
 *
 * ���룺root = [1,2], p = 1, q = 2
 * �����1
 */
class Solution06 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        // �������
        return left != null ? left : right;
    }
}
