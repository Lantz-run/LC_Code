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
 * 237. ɾ�������еĽڵ�
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��һ��������� head��������ɾ�������е�һ���ڵ� node��
 *
 * ����һ����Ҫɾ���Ľڵ� node ���㽫 �޷����� ��һ���ڵ�  head��
 *
 * ���������ֵ���� Ψһ�ģ����ұ�֤�����Ľڵ� node ���������е����һ���ڵ㡣
 *
 * ɾ�������Ľڵ㡣ע�⣬ɾ���ڵ㲢����ָ���ڴ���ɾ�������������˼�ǣ�
 *
 * �����ڵ��ֵ��Ӧ�ô����������С�
 * �����еĽڵ���Ӧ�ü��� 1��
 * node ǰ�������ֵ˳����ͬ��
 * node ���������ֵ˳����ͬ
 */
class Solution04 {
    public void deleteNode(ListNode node) {
        // �����������ط��ʽڵ㣬ֻ�ܴ�һ���ڵ��ȡ��һ���ڵ����Ϣ
        // ����ֻ�ܽ���һ���ڵ����Ϣ���Ƶ�ָ���ڵ��У��ٽ�ָ���ڵ����һ���ڵ�ɾ��
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
