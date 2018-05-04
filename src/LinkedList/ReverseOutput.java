package LinkedList;

import java.util.Stack;

//从尾到头输出链表
public class ReverseOutput {

    private ReverseOutput() { }

    public static void print(ListNode listNode) {
        //首先创建一个栈
        Stack<Integer> stack = new Stack<>();
        //从头到尾遍历链表，将节点的值放入栈中
        while (listNode != null) {
            stack.push(listNode.value);
            listNode = listNode.next;
        }
        //将栈中的元素依次弹出,则实现了从尾到头输出链表元素的功能
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
