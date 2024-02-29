package com.Lantz2024.February;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra17
 * <p>Powered by Lantz On 2024-02-20 10:14:43
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra17
 * @since 1.8
 */
public class Pra17 {

}

/**
 * 105. ��ǰ��������������й��������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ���������������� preorder �� inorder ������ preorder �Ƕ���������������� inorder ��ͬһ����������������빹�����������������ڵ㡣
 *
 *
 *
 * ʾ�� 1:
 *
 *
 * ����: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * ���: [3,9,20,null,null,15,7]
 * ʾ�� 2:
 *
 * ����: preorder = [-1], inorder = [-1]
 * ���: [-1]
 */
class Solution17 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        int leftSize = indexOf(inorder, preorder[0]); //�������Ĵ�С
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize); // copyOfRange() ����һ����Χ������ҿ�����
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);
    }
    // ����x �� a �е��±꣬ȷ�� x һ���� a ��
    private int indexOf(int[] a, int x){
        for(int i = 0; ; i++){
            if(a[i] == x){
                return i;
            }
        }
    }
}
