package PlusWithoutTool;

/**
 * 不用加减乘除做加法
 */
public class Add {

    /**
     * 思路
     * 第一步：不考虑进位对每一位相加，这个可以用异或实现
     * 第二步：计算进位，位与后左移一位可以实现
     * 第三步：由于不能使用加法，因此无法将进位直接和异或结果相加，因此需要循环上述两个步骤直到进位为0
     */
    public int Add(int num1,int num2) {
        int sum;//异或结果
        int carry;//进位
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
