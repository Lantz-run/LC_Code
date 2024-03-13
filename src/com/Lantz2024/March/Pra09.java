package com.Lantz2024.March;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Project: Algorithm20230913 - Pra09
 * <p>Powered by Lantz On 2024-03-12 15:00:17
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra09
 * @since 1.8
 */
public class Pra09 {

}

/**
 * 1261. ������Ⱦ�Ķ������в���Ԫ��
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ��������������Ķ�������
 *
 * root.val == 0
 * ��� treeNode.val == x �� treeNode.left != null����ô treeNode.left.val == 2 * x + 1
 * ��� treeNode.val == x �� treeNode.right != null����ô treeNode.right.val == 2 * x + 2
 * ��������������ܵ�����Ⱦ�������е� treeNode.val ������� -1��
 *
 * �����Ȼ�ԭ��������Ȼ��ʵ�� FindElements �ࣺ
 *
 * FindElements(TreeNode* root) ������Ⱦ�Ķ�������ʼ����������Ҫ�Ȱ�����ԭ��
 * bool find(int target) �ж�Ŀ��ֵ target �Ƿ�����ڻ�ԭ��Ķ������в����ؽ����
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * �����
 * [null,false,true]
 * ���ͣ�
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 * ʾ�� 2��
 *
 *
 *
 * ���룺
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * �����
 * [null,true,true,false]
 * ���ͣ�
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 * ʾ�� 3��
 *
 *
 *
 * ���룺
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * �����
 * [null,true,false,false,true]
 * ���ͣ�
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 */
class FindElements {
    private final Set<Integer> s = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    public boolean find(int target) {
        return s.contains(target);
    }

    private void dfs(TreeNode node, int val){
        if(node == null){
            return;
        }
        s.add(val);
        dfs(node.left, val * 2 + 1);
        dfs(node.right, val * 2 + 2);
    }
}
