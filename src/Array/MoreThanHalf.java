package Array;

//数组中出现次数超过一半的数字
public class MoreThanHalf {

    /**
     * 思路
     * 使用两个变量number和times,前者记录数字,后者记录该数字出现次数
     * 遍历到下一个数字m的时候,若m与number相等,则次数加一,不相等则减一
     * 若次数为0,那么number就保存下一个数字m,次数变为1
     * 最终我们要找的数字就是最后一次把次数设为1的number
     * 例如：{1,1,2,1,4}
     * 记录步骤如下：
     * number  times
     *   1       1
     *   1       2
     *   1       1
     *   1       2
     *   1       1
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        //鲁棒性检查
        if (array.length == 0) {
            //无效输入返回0
            return 0;
        }
        //首先将数组第一个元素记录下来,次数置1
        int number = array[0];
        int times = 1;
        //最终返回值,其值为最后一次把次数置为1的number
        int result = array[0];
        //循环遍历整个数组
        for (int i = 1; i < array.length; i++) {
            if (array[i] == number) {
                //当前元素和number相等,次数加一
                times++;
            } else if (times == 0){
                //当前元素和number不相等,并且次数为0,记录当前元素,次数置一
                number = array[i];
                times = 1;
                result = number;//使用result记录下最后一次将times置1的元素
            } else {
                //当前元素和number不相等,次数减一
                times--;
            }
        }
        //判断result出现次数是否超过数组长度一半,因为前面的判断方法只适用于数组中有超过一半长度的元素存在的情况
        if (!checkMoreThanHalf(array, result)) {
            result = 0;
        }
        return result;
    }

    //判断数组中元素target出现次数是否超过数组长度的一半,有则返回true,没有则返回false
    private boolean checkMoreThanHalf(int[] array, int target) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                times++;
            }
        }
        if (times > array.length / 2) {
            return true;
        } else {
            return false;
        }
    }
}
