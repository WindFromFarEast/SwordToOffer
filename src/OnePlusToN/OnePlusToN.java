package OnePlusToN;

//1+2+...+n 不允许使用乘除法、for、while、if、else、switch、case
public class OnePlusToN {

    /**
     * 递归实现,利用逻辑与的短路特性实现递归终止
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean needContinue = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
