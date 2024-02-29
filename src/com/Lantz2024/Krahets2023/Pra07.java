package com.Lantz2024.Krahets2023;

import java.util.Stack;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2024-01-27 23:29:27
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 */
public class Pra07 {
    public static void main(String[] args) {

    }
}

/**
 * 232. ��ջʵ�ֶ���
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * �����ʹ������ջʵ�������ȳ����С�����Ӧ��֧��һ�����֧�ֵ����в�����push��pop��peek��empty����
 *
 * ʵ�� MyQueue �ࣺ
 *
 * void push(int x) ��Ԫ�� x �Ƶ����е�ĩβ
 * int pop() �Ӷ��еĿ�ͷ�Ƴ�������Ԫ��
 * int peek() ���ض��п�ͷ��Ԫ��
 * boolean empty() �������Ϊ�գ����� true �����򣬷��� false
 * ˵����
 *
 * �� ֻ�� ʹ�ñ�׼��ջ���� ���� Ҳ����ֻ�� push to top, peek/pop from top, size, �� is empty �����ǺϷ��ġ�
 * ����ʹ�õ�����Ҳ��֧��ջ�������ʹ�� list ���� deque��˫�˶��У���ģ��һ��ջ��ֻҪ�Ǳ�׼��ջ�������ɡ�
 *
 *
 * ʾ�� 1��
 *
 * ���룺
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * �����
 * [null, null, null, 1, 1, false]
 *
 * ���ͣ�
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
class MyQueue {
    private Stack<Integer> In;
    private Stack<Integer> Out;

    public MyQueue() {
        In = new Stack();
        Out = new Stack();
    }

    public void push(int x) {
        In.push(x);
    }

    public int pop() {
        int peek = peek();
        Out.pop(); // ���е���Ԫ�ش����ŵ����ջҲҪ����Ԫ�أ���Ȼ��һֱ��ջ���棬����ջ����Ϊ��
        return peek;
    }

    public int peek() {
        if(!Out.isEmpty()) return Out.peek();
        if(In.isEmpty()) return -1;
        while(!In.isEmpty()){
            Out.push(In.pop());
        }
        return Out.peek();
    }

    public boolean empty() {
        return In.isEmpty() && Out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */