package com.Lantz2023.December;


/**
 * <p>Project: Algorithm20230913 - Pra03
 * <p>Powered by Lantz On 2023-12-27 20:37:05
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra03
 * @since 1.8
 */
public class Pra03 {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
//        ListNode head = [1,2,3,4,5];
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}
class Solution03 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(0);
        p.next = head;

        int i = 0;
        while (p.next != null && i < n-1){
            p = p.next;
            ++i;
        }
        ListNode q = p.next;
        p.next = p.next.next;
        return p.next;
    }
}
