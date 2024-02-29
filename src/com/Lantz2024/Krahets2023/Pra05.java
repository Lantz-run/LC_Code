package com.Lantz2024.Krahets2023;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra05
 * <p>Powered by Lantz On 2024-01-17 16:56:46
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra05
 * @since 1.8
 */
public class Pra05 {
    public static void main(String[] args) {

    }
}

class Solution05 {
    public Node copyRandomList(Node head) {
        Node cur = head;
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        // ������ԭ�ڵ�->�½ڵ㡱
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4������ָ��next��random��ָ��
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}