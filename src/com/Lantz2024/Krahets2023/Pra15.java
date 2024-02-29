package com.Lantz2024.Krahets2023;

/**
 * <p>Project: Algorithm20230913 - Pra15
 * <p>Powered by Lantz On 2024-02-25 21:50:55
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra15
 * @since 1.8
 */
public class Pra15 {

}

/**
 * 876. ������м���
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ���㵥�����ͷ��� head �������ҳ�������������м��㡣
 *
 * ����������м��㣬�򷵻صڶ����м��㡣
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺head = [1,2,3,4,5]
 * �����[3,4,5]
 * ���ͣ�����ֻ��һ���м��㣬ֵΪ 3 ��
 * ʾ�� 2��
 *
 *
 * ���룺head = [1,2,3,4,5,6]
 * �����[4,5,6]
 * ���ͣ��������������м��㣬ֵ�ֱ�Ϊ 3 �� 4 �����صڶ�����㡣
 */
class Solution15{
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
