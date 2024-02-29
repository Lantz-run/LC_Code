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
                sml.next = head; // ��sml��ָ��ָ��С��x���Ǹ�����Ҳ����˵��smlָ��С��x���Ǹ��ڵ㣬����˵������ڵ���ӵ�sml_list������
                sml = sml.next; // smlָ������λ
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next; // headͷָ������ö�ٽڵ�
        }
        sml.next = big_list.next;
        big.next = null;
        return sml_list.next;
    }
}
