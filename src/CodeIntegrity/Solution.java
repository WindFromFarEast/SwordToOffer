package CodeIntegrity;

//代码的完整性
public class Solution {

    public boolean invalidInput = false;

    //求base的exponent次方,不考虑大数问题
    public double Power(double base, int exponent) {
        //最终返回值
        double result = 0;
        //首先进行无效输入判定,底数为0指数为负数时无意义
        //由于double数据类型之间无法直接比较,需要转换成字符串后再进行比较
        String stringBase = String.valueOf(base);
        String zeroBase = String.valueOf(0);
        if (stringBase.equals(zeroBase) && exponent < 0) {
            invalidInput = true;//使用一个类成员变量来区别是由于错误输入返回的0还是正常运行返回的0
            return 0;
        }
        //求出指数的绝对值
        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = 0 - exponent;
        }
        //求出指数为绝对值的情况下的指数算数结果
        result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            //若指数为负数,需要进行一次倒数
            result = 1 / result;
        }
        return result;
    }


    public double powerWithUnsignedExponent(double base, int absExponent) {
        double result = 1;
        for (int i = 1; i <= absExponent; i++) {
            result = result * base;
        }
        return result;
    }

    //打印从1到最大的n位数,这种方法在n很大的时候会发生溢出,不可取
//    public static void print1ToMaxN(int n) {
//        //先求出最大的n位数+1
//        int maxNumber = 1;
//        for (int i = 1; i <=n; i++) {
//            maxNumber = maxNumber * 10;
//        }
//        //再从1打印到maxNumber-1
//        for (int i = 1; i < maxNumber; i++) {
//            System.out.println(i);
//        }
//    }

    //将数组array中的奇数放在数组的前半部分,偶数放在数组的后半部分,但是这种方式会打乱奇数和奇数、偶数和偶数之间的相对位置
    public void reorderOddEven(int[] array) {
        //首先进行无效输入判断
        if (array.length == 0 || array.length == 1) {
            return;
        }
        //首先定义两个指针分别指向数组的第一个元素和最后一个元素
        int index1 = 0;
        int index2 = array.length - 1;
        //如果第一个指针指向的是偶数,第二个指针指向的是奇数,并且第一个指针位于第二个指针之前,交换两个指针指向的元素位置
        //若第一个指针碰到偶数,就停在原地,等第二个指针碰到奇数;反之由第二个指针等第一个指针
        while (index1 < index2) {
            if (array[index1] % 2 == 0 && array[index2] % 2 == 1) {
                swap(array, index1, index2);
            } else if (array[index1] % 2 == 1){
                index1++;
            } else if (array[index2] % 2 == 0){
                index2--;
            }
        }
    }

    //不打乱奇数和奇数、偶数和偶数相对位置的算法
    public void reorderOddEvenTwo(int[] array) {
        //首先进行无效输入判断
        if (array.length == 0 || array.length == 1) {
            return;
        }
        //统计数组中奇数的个数oddCount
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                oddCount++;
            }
        }
        //创建一个新数组,在这个数组中,oddCount之前的位置都放奇数,之后的位置都放偶数
        int[] newArray = new int[array.length];
        int oddIndex = 0;//在新数组中指向奇数位置的指针
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                //奇数放在前面的oddCount个位置
                newArray[oddIndex++] = array[i];
            } else {
                //偶数放在oddCount及之后的位置
                newArray[oddCount++] = array[i];
            }
        }
        //再用新的数组覆盖旧数组
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }

    //交换数组中两个元素的位置
    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
