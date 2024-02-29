package com.Lantz2024.February;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2024-02-10 22:29:38
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 */
public class Pra07 {

}

/**
 * 94. 二叉树的中序遍历
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 */
class Solution07 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }
    // 中序遍历：左-打印-右
    private void dfs(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }
}