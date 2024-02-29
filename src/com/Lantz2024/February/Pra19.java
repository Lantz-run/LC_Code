package com.Lantz2024.February;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra19
 * <p>Powered by Lantz On 2024-02-21 10:16:46
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra19
 * @since 1.8
 */
public class Pra19 {

}

/**
 * 889. ����ǰ��ͺ���������������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ���������������飬preorder �� postorder ������ preorder ��һ������ ���ظ� ֵ�Ķ�������ǰ�������postorder ��ͬһ�����ĺ���������ع������ض�������
 *
 * ������ڶ���𰸣������Է������� �κ� һ����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * �����[1,2,3,4,5,6,7]
 * ʾ�� 2:
 *
 * ����: preorder = [1], postorder = [1]
 * ���: [1]
 */
class Solution19 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        int leftSize = indexOf(postorder, preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n-1);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);
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
