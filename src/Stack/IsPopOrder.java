package Stack;

import java.util.Stack;

//栈的压入、弹出序列
public class IsPopOrder {

    /**
     * 思路
     * 借用一个辅助栈,依次将压入序列中的元素压入辅助栈,每一次压入后都进行判断,若当前栈顶元素等于要弹出的元素,则直接弹出
     * 弹出后将popIndex（要弹出元素的索引）自增,最终辅助栈为空的话说明true,反之为false
     * @param pushA
     * @param popA
     * @return
     */

    //判断序列popA是否为压入序列pushA的弹出序列
    public boolean isPopOrder(int[] pushA, int[] popA) {
        //鲁棒性检查
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        //辅助栈
        Stack<Integer> stack = new Stack<>();
        //下一个要弹出的元素的索引
        int popIndex = 0;

        for (int i = 0; i < pushA.length; i++) {
            //先将压入序列中的元素压入栈
            stack.push(pushA[i]);
            //判断当前栈顶元素是否为下一个要弹出的元素,如果是就直接弹出,不是就根据压入序列继续压入
            //这里要用while而不能用if,因为有可能连续弹出;用if的话可能导致压入五次而只弹出一次 例如pushA为12345,popA为54321
            while (!stack.isEmpty() && (stack.peek() == popA[popIndex])) {
                stack.pop();
                popIndex++;
            }
        }
        //若最终栈是空的,说明popA就是pushA的弹出序列;反之不是
        return stack.isEmpty();
    }
}
