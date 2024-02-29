package com.Lantz2023.OctoberPra;

/**
 * LeetCode第二题：两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class Pra02 {
    public static void main(String[] args) {

        // 创建链表
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

        ListNode pre = new ListNode(); // 创建头节点指针
        ListNode cur = pre; // 创建当前节点指针
        int carry = 0; // 创建进位

        while (l1 != null || l2 != null){

            int x = l1 != null ? l1.val : 0; // l1每个数位的值
            int y = l2 != null ? l2.val : 0; // l2每个数位的值
            int sum = x + y + carry; // 和

            carry = sum / 10; // 求进位数，获得进位数；通过int整除法，取十位数
            sum = sum % 10; // 实际存入链表的数

            // 每一个数都要保存在一个节点中
            cur.next = new ListNode(sum); // 创建一个新的节点用来存储下一位数
            cur = cur.next; // 当前指针指向下一个节点

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;

            }
            if (carry == 1){
                cur.next = new ListNode(carry); // 当l1 > l2时，没有节点存储进位数，就要创建一个节点对其存储
            }

        }
        return pre.next; // 从头结点开始返回值
    }
}