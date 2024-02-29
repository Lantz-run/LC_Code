package com.Lantz2024.February;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra14
 * <p>Powered by Lantz On 2024-02-17 10:04:15
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra14
 * @since 1.8
 */
public class Pra14 {

}

/**
 * 429. N 叉树的层序遍历
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
class Solution14 {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> vals = new ArrayList<>();
            int n = q.size();
            while(n-- > 0){
                Node node = q.poll();
                vals.add(node.val);
                q.addAll(node.children);
            }
            ans.add(vals);
        }
        return ans;
    }
}
