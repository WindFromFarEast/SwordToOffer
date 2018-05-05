package Array;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class NumsAppearOnce {

    /**
     * 思路
     * 根据异或的性质：任何数异或自己都为0
     * 因此从前往后异或，最终结果为两个只出现一次的数字相异或的值
     * 根据异或的结果将数组分成两个子数组：
     * 分组的依据：异或结果的第一个为1的位的位置为index,那么将index位置的位为1的分在一组，为0的分在另一组
     * 再对两组依次异或，结果就是只出现一次的数字
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //鲁棒性检查
        if (array.length < 2) {
            return;
        }
        //从头到尾的异或结果
        int result = array[0];
        //从头到尾依次异或,最终结果为两个只出现一次的数字的异或结果
        for (int i = 1; i <= array.length - 1; i++) {
            result = result ^ array[i];
        }
        //找到异或结果中第一个为1的位的位置
        int indexOf1 = findFirstBitIs1(result);
        //根据第一个为1的位的位置将数组划分为两个子数组
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    //找到异或结果中第一个为1的位的位置(从右边开始,第一位的位置为0)
    private int findFirstBitIs1(int result) {
        //异或结果中第一个为1的位的位置(从0开始)
        int index = 0;
        //与1位与,若结果为0(说明result的最右边为0)就将result右移一位,index自增
        while ((result & 1) == 0) {
            result = result >> 1;
            index++;
        }
        return index;
    }

    //判断数字num的index位是否为1
    private boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }
}
