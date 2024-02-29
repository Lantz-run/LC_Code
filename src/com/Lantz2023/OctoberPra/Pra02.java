package com.Lantz2023.OctoberPra;

/**
 * LeetCode�ڶ��⣺�������
 * �������� �ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ��� ���� �ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢 һλ ����
 *
 * ���룺l1 = [2,4,3], l2 = [5,6,4]
 * �����[7,0,8]
 * ���ͣ�342 + 465 = 807.
 *
 * ʾ�� 2��
 * ���룺l1 = [0], l2 = [0]
 * �����[0]
 *
 * ʾ�� 3��
 * ���룺l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * �����[8,9,9,9,0,0,0,1]
 */
public class Pra02 {
    public static void main(String[] args) {

        // ��������
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);

        Solution2 solution2 = new Solution2();
        ListNode result = solution2.addTwoNumbers(l1, l2);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


class Solution2{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode pre = new ListNode(); // ����ͷ�ڵ�ָ��
        ListNode cur = pre; // ������ǰ�ڵ�ָ��
        int carry = 0; // ������λ

        while (l1 != null || l2 != null){

            int x = l1 != null ? l1.val : 0; // l1ÿ����λ��ֵ
            int y = l2 != null ? l2.val : 0; // l2ÿ����λ��ֵ
            int sum = x + y + carry; // ��

            carry = sum / 10; // ���λ������ý�λ����ͨ��int��������ȡʮλ��
            sum = sum % 10; // ʵ�ʴ����������

            // ÿһ������Ҫ������һ���ڵ���
            cur.next = new ListNode(sum); // ����һ���µĽڵ������洢��һλ��
            cur = cur.next; // ��ǰָ��ָ����һ���ڵ�

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;

            }
            if (carry == 1){
                cur.next = new ListNode(carry); // ��l1 > l2ʱ��û�нڵ�洢��λ������Ҫ����һ���ڵ����洢
            }

        }
        return pre.next; // ��ͷ��㿪ʼ����ֵ
    }
}