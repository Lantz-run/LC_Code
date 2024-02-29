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
 * 232. 用栈实现队列
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
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
        Out.pop(); // 队列弹出元素代表着倒序的栈也要弹出元素，不然会一直在栈里面，导致栈不能为空
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