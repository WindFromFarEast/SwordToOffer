package HowManyOne;

//二进制数中有多少个1
public class HowManyOne {

    //返回n对应的二进制数中有多少个1,该方法在n为负数的时候会发生死循环,不可取
//    public static int numberOf1(int n) {
//        //1的个数
//        int count = 0;
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                count++;
//            }
//            n = n >> 1;
//        }
//        return count;
//    }

    //通过flag的左移依次判断n的各个位数是否为1
//    public static int numberOf1(int n) {
//        int count = 0;
//        int flag = 1;
//        while (flag != 0) {
//            if ((n & flag) != 0) {
//                count++;
//            }
//            flag = flag << 1;
//        }
//        return count;
//    }

    //最完美的方法,n有多少个1就进行多少次操作
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            //n不为0就肯定有1,首先进行count++操作
            count++;
            //将n最右边的1变成0
            n = n & (n-1);
        }
        return count;
    }
}
