package com.Lantz2024.Krahets2023;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2024-01-10 10:20:05
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 */
public class Pra02 {
    public static void main(String[] args) {

    }
}

class Solution02 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head; // 指向头结点，利用头结点查找节点
        // cur指针空了就代表链表最后一个节点了
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            // 这个和排序大同小异, 这里是移动位置以及节点指针改变指向
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
