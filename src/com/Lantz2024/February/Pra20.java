package com.Lantz2024.February;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra20
 * <p>Powered by Lantz On 2024-02-23 11:06:15
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra20
 * @since 1.8
 */
public class Pra20 {

}

/**
 * 2583. 二叉树中的第 K 大层和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵二叉树的根节点 root 和一个正整数 k 。
 *
 * 树中的 层和 是指 同一层 上节点值的总和。
 *
 * 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。
 *
 * 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [5,8,9,2,1,3,7,4,6], k = 2
 * 输出：13
 * 解释：树中每一层的层和分别是：
 * - Level 1: 5
 * - Level 2: 8 + 9 = 17
 * - Level 3: 2 + 1 + 3 + 7 = 13
 * - Level 4: 4 + 6 = 10
 * 第 2 大的层和等于 13 。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,2,null,3], k = 1
 * 输出：3
 * 解释：最大的层和是 3 。
 */
class Solution20 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            long sum = 0;
            while(n-- > 0){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

            }
            res.add(sum);
        }
        int m = res.size();
        if(k > m){
            return -1;
        }
        Collections.sort(res);
        return res.get(m - k);
    }
}
