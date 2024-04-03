package com.Lantz2024.March;

import java.util.LinkedList;

/**
 * <p>Project: Algorithm20230913 - Pra25
 * <p>Powered by Lantz On 2024-03-31 14:59:30
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra25
 * @since 1.8
 */
public class Pra25 {

}

/**
 * 331. 验证二叉树的前序序列化
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *
 *
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的
 *
 * 例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * 注意：不允许重建树。
 *
 *
 *
 * 示例 1:
 *
 * 输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: preorder = "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: preorder = "9,#,#,1"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= preorder.length <= 104
 * preorder 由以逗号 “，” 分隔的 [0,100] 范围内的整数和 “#” 组成
 */

class Solution25 {
    public boolean isValidSerialization(String preorder) {
        // 二叉树的入度和出度
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node : nodes){
            diff--;
            if(diff < 0){
                return false;
            }
            if(!node.equals("#")){
                diff += 2;
            }
        }
        return diff == 0;
    }
}

/**
 * 如输入： "9,3,4,#,#,1,#,#,2,#,6,#,#"?，当遇到 x,#,# 的时候，就把它变为 #。
 *
 * 模拟一遍过程：
 *
 * [9,3,4,#,#] => [9,3,#]，继续
 * [9,3,#,1,#,#] => [9,3,#,#] => [9,#] ，继续
 * [9,#2,#,6,#,#] => [9,#,2,#,#] => [9,#,#] => [#]，结束
 *
 */
class Solution25_1 {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        for(String node : preorder.split(",")){
            stack.push(node);
            while(stack.size() >= 3 && stack.get(0).equals("#")
                    && stack.get(1).equals("#")
                    && !stack.get(2).equals("#")){
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}
