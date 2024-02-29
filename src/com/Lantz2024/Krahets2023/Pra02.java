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
        ListNode cur = head; // ָ��ͷ��㣬����ͷ�����ҽڵ�
        // curָ����˾ʹ����������һ���ڵ���
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            // ����������ͬС��, �������ƶ�λ���Լ��ڵ�ָ��ı�ָ��
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
