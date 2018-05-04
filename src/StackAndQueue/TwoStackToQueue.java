package StackAndQueue;

import java.util.Stack;

//用两个栈实现一个队列
public class TwoStackToQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //向队列中插入元素
    public void push(int node) {
        stack1.push(node);
    }

    //删除队头元素
    public int pop() {
        //若stack2不为空,则先删除stack2的栈顶元素,stack2的栈顶元素就是队头元素
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        //若stack2为空,那么首先将stack1的所有元素弹出放到stack2,此时stack2的元素顺序和原本stack1相反
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        //再弹出stack2的栈顶元素,
        return stack2.pop();
    }
}
