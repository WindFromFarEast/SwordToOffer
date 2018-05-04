package Fibonacci;

//青蛙跳台阶问题,本质就是斐波那契数列
public class JumpFloor {

    //n层台阶的跳法总数
    public int jumpFloor(int n) {
        //前两层台阶的跳法总数分别为1和2
        int[] result = {1,2};
        if (n < 3) {
            return result[n - 1];
        }
        //
        int fNMinusOne = 2;//f(n-1)
        int fNMinusTwo = 1;//f(n-2)
        int fN = 0;//f(n)
        for (int i = 3; i <= n; i++) {
            fN = fNMinusOne + fNMinusTwo;
            fNMinusTwo = fNMinusOne;
            fNMinusOne = fN;
        }
        return fN;
    }
}
