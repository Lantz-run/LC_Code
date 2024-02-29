package com.Lantz2024.February;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra18
 * <p>Powered by Lantz On 2024-02-21 09:32:27
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra18
 * @since 1.8
 */
public class Pra18 {

}

/**
 * 106. �����������������й��������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ���������������� inorder �� postorder ������ inorder �Ƕ���������������� postorder ��ͬһ�����ĺ�����������㹹�첢������� ������ ��
 *
 *
 *
 * ʾ�� 1:
 *
 *
 * ���룺inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * �����[3,9,20,null,null,15,7]
 * ʾ�� 2:
 *
 * ���룺inorder = [-1], postorder = [-1]
 * �����[-1]
 */
class Solution18 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n == 0){
            return null;
        }
        //  postorder[n-1] �Ƕ������ĸ�
        int leftSize = indexOf(inorder, postorder[n-1]); // �������Ĵ�С
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, 1 + leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = buildTree(in1, post1);
        TreeNode right = buildTree(in2, post2);
        return new TreeNode(postorder[n-1], left, right);
    }
    // ȷ�� x һ���� a ����
    private int indexOf(int[] a, int x){
        for(int i = 0; ; i++){
            if(a[i] == x){
                return i;
            }
        }
    }
}
