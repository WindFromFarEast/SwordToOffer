package Stack;

import java.util.Stack;

//包含min函数的栈
public class MinFunctionStack {

    //数据栈
    private Stack<Integer> dataStack = new Stack<>();
    //辅助栈
    private Stack<Integer> auxStack = new Stack<>();

    //入栈
    public void push(int node) {
        dataStack.push(node);
        if (auxStack.isEmpty()) {
            //辅助栈为空直接压入即可
            auxStack.push(node);
        } else {
            //获取辅助栈栈顶元素,注意此时不弹出只是单纯的获取
            int min = auxStack.peek();
            //比较辅助栈栈顶元素和要压入数据栈的元素的大小,若辅助栈栈顶元素大于要压入数据栈的元素的大小,则同时往
            //辅助栈压入该元素,否则向辅助栈压入一个大小等于辅助栈栈顶元素的元素
            if (min > node) {
                auxStack.push(node);
            } else {
                auxStack.push(auxStack.peek());
            }
        }
    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            dataStack.pop();
            auxStack.pop();
        }
    }

    public int top() {
        if (!dataStack.isEmpty()) {
            return dataStack.peek();
        } else {
            //返回-1表示栈为空
            return -1;
        }
    }

    public int min() {
        if (!auxStack.isEmpty()) {
            return auxStack.peek();
        } else {
            return -1;
        }
    }
}
