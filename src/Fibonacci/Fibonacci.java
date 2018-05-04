package Fibonacci;

//斐波那契数列
public class Fibonacci {

    //求斐波那契数列的第n项,基础递归解法,效率最低
    public long fibonacciOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciOne(n - 1) + fibonacciOne(n - 2);
    }

    //求斐波那契数列的第n项,从下往上计算,优化了效率
    public static int fibonacciTwo(int n) {
        int[] result = {0,1};
        if (n < 2) {
            return result[n];
        }
        int fibNMinusOne = 1;//f(n-1)
        int fibNMinusTwo = 0;//f(n-2)
        int fibN = 0;//f(n)
        //从下往上计算
        for (int i = 2; i <= n; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
}
