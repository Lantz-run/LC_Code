package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra03
 * <p>Powered by Lantz On 2024-04-03 11:40:22
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra03
 * @since 1.8
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Pra03 {

}

/**
 * 1379. �ҳ���¡�������е���ͬ�ڵ�
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * �������ö�������ԭʼ�� original �Ϳ�¡�� cloned���Լ�һ��λ��ԭʼ�� original �е�Ŀ��ڵ� target��
 *
 * ���У���¡�� cloned ��ԭʼ�� original ��һ�� ���� ��
 *
 * ���ҳ����� cloned �У��� target ��ͬ �Ľڵ㣬�����ضԸýڵ�����ã��� C/C++ ����ָ��������з��� �ڵ�ָ�룬�������Է��ؽڵ㱾����
 *
 *
 *
 * ע�⣺�� ���� �����ö��������Լ� target �ڵ���и��ġ�ֻ�� ���ضԿ�¡�� cloned �����еĽڵ�����á�
 *
 *
 *
 * ʾ�� 1:
 *
 *
 *
 * ����: tree = [7,4,3,null,null,6,19], target = 3
 * ���: 3
 * ����: ��ͼ�������� original �� cloned��target �ڵ����� original �У�����ɫ��ǡ������� cloned �еĻ���ɫ�Ľڵ㣨����ʾ�����ƣ���
 * ʾ�� 2:
 *
 *
 *
 * ����: tree = [7], target =  7
 * ���: 7
 * ʾ�� 3:
 *
 *
 *
 * ����: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
 * ���: 4
 *
 *
 * ��ʾ��
 *
 * ���нڵ��������ΧΪ [1, 104] ��
 * ͬһ�����У�û��ֵ��ͬ�Ľڵ㡣
 * target �ڵ����� original �е�һ���ڵ㣬���Ҳ����� null ��
 *
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || original == target){
            return cloned;
        }
        TreeNode leftRes = getTargetCopy(original.left, cloned.left, target);
        if(leftRes != null){
            return leftRes;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}
