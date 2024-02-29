package com.Lantz2024.Krahets2023;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-01-15 16:12:53
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {
    public static void main(String[] args) {

    }
}

/**
 * 237. 删除链表中的节点
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 *
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 *
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 *
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 *
 * 给定节点的值不应该存在于链表中。
 * 链表中的节点数应该减少 1。
 * node 前面的所有值顺序相同。
 * node 后面的所有值顺序相同
 */
class Solution04 {
    public void deleteNode(ListNode node) {
        // 单链表不能往回访问节点，只能从一个节点获取下一个节点的信息
        // 所以只能将下一个节点的信息复制到指定节点中，再将指定节点的下一个节点删除
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
