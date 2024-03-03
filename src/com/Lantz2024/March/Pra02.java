package com.Lantz2024.March;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2024-03-03 16:10:41
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 */
public class Pra02 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
    }
}
class MyStack {
    private Queue<Integer> In;
    private Queue<Integer> Out;
    public MyStack() {
        In = new LinkedList<Integer>();
        Out = new LinkedList<Integer>(); // ��������
    }

    public void push(int x) {
        Out.offer(x);
        while(!In.isEmpty()){
            Out.offer(In.poll());
        }
        // ������������Ӧ����1-2-3-4��������Ӧ����4-3-2-1, Ȼ�󽻻��������������
        Queue<Integer> tmp = In;
        In = Out;
        Out = tmp;
    }

    public int pop() {
        return In.poll();
    }

    public int top() {
        return In.peek();
    }

    public boolean empty() {
        return In.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */