package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-02-07 23:21:43
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {

}
/**
 * 2641. �����������ֵܽڵ� II
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ�ö������ĸ� root �����㽫ÿ���ڵ��ֵ�滻�ɸýڵ������ ���ֵܽڵ�ֵ�ĺ� ��
 *
 * ��������ڵ�����������ͬ����������ǵĸ��ڵ㲻ͬ����ô���ǻ�Ϊ ���ֵ� ��
 *
 * ���㷵���޸�ֵ֮�����ĸ� root ��
 *
 * ע�⣬һ���ڵ�����ָ���Ǵ������ڵ㵽����ڵ㾭���ı�����
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [5,4,9,1,10,null,7]
 * �����[0,0,0,7,7,null,11]
 * ���ͣ���ͼչʾ�˳�ʼ�Ķ��������޸�ÿ���ڵ��ֵ֮��Ķ�������
 * - ֵΪ 5 �Ľڵ�û�����ֵܣ�����ֵ�޸�Ϊ 0 ��
 * - ֵΪ 4 �Ľڵ�û�����ֵܣ�����ֵ�޸�Ϊ 0 ��
 * - ֵΪ 9 �Ľڵ�û�����ֵܣ�����ֵ�޸�Ϊ 0 ��
 * - ֵΪ 1 �Ľڵ���һ�����ֵܣ�ֵΪ 7 ������ֵ�޸�Ϊ 7 ��
 * - ֵΪ 10 �Ľڵ���һ�����ֵܣ�ֵΪ 7 ������ֵ�޸�Ϊ 7 ��
 * - ֵΪ 7 �Ľڵ����������ֵܣ�ֵ�ֱ�Ϊ 1 �� 10 ������ֵ�޸�Ϊ 11 ��
 * ʾ�� 2��
 *
 *
 *
 * ���룺root = [3,1,2]
 * �����[0,0,0]
 * ���ͣ���ͼչʾ�˳�ʼ�Ķ��������޸�ÿ���ڵ��ֵ֮��Ķ�������
 * - ֵΪ 3 �Ľڵ�û�����ֵܣ�����ֵ�޸�Ϊ 0 ��
 * - ֵΪ 1 �Ľڵ�û�����ֵܣ�����ֵ�޸�Ϊ 0 ��
 * - ֵΪ 2 �Ľڵ�û�����ֵܣ�����ֵ�޸�Ϊ 0 ��
 *
 */
class Solution04 {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> q = List.of(root);
        while(!q.isEmpty()){
            List<TreeNode> tmp = q;
            q = new ArrayList<>();

            // ������һ��Ľڵ�ֵ֮��
            int nextLevelSum = 0;
            for(TreeNode node : tmp){
                if(node.left != null){
                    q.add(node.left);
                    nextLevelSum += node.left.val;
                }
                if(node.right != null){
                    q.add(node.right);
                    nextLevelSum += node.right.val;
                }
            }

            // �ٴα�����������һ��Ľڵ�ֵ�������˾Ͳ���ԭ���Ľڵ�ֵ
            for(TreeNode node : tmp){
                int childrenSum = (node.left != null ? node.left.val : 0) +
                        (node.right != null ? node.right.val : 0);
                if(node.left != null) node.left.val = nextLevelSum - childrenSum;
                if(node.right != null) node.right.val = nextLevelSum - childrenSum;
            }
        }
        return root;
    }
}