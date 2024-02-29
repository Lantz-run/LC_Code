package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra25
 * <p>Powered by Lantz On 2024-02-26 15:23:40
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra25
 * @since 1.8
 */
public class Pra25 {

}
class Solution25 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        /**
         �������Ľڵ�ֵ��С�ڸ��ڵ��ֵ��
         �������Ľڵ�ֵ�����ڸ��ڵ��ֵ��
         ����ڵ�������������������Ƕ���������
         */
        if(root == null) return 0;
        int x = root.val;
        int sum = low <= x && x <= high ? x : 1;
        if(x < low){ // ���������ڷ�Χ�ڣ��ݹ�������
            return rangeSumBST(root.right, low, high);
        }
        if(x > high){ // ���������ڷ�Χ�ڣ��ݹ�������
            return rangeSumBST(root.left, low, high);
        }
        return x + rangeSumBST(root.right, low, high) +
                rangeSumBST(root.left, low, high);
    }
}
