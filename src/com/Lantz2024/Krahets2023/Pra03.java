package com.Lantz2024.Krahets2023;

/**
 * <p>Project: Algorithm20230913 - Pra03
 * <p>Powered by Lantz On 2024-01-11 10:52:45
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra03
 * @since 1.8
 */
public class Pra03 {
    public static void main(String[] args) {

    }
}

class Solution03 {
    public ListNode partition(ListNode head, int x) {
        ListNode sml_list = new ListNode(0), big_list = new ListNode(0);
        ListNode sml = sml_list, big = big_list;
        while(head != null){
            if(head.val < x){
                sml.next = head; // 让sml的指针指向小于x的那个数，也可以说是sml指向小于x的那个节点，或者说将这个节点添加到sml_list链表中
                sml = sml.next; // sml指往后移位
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next; // head头指针往后枚举节点
        }
        sml.next = big_list.next;
        big.next = null;
        return sml_list.next;
    }
}
