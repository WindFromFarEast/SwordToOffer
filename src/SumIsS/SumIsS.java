package SumIsS;

import java.util.ArrayList;

//找到数组中和为s的两个数字(数组为递增数组)
public class SumIsS {

    /**
     * 思路
     * 从两头分别向中间遍历，若两元素的和sum小于s，那么就再遍历较小数字后面的数字（由于是递增数组因此较小数组后面的数字比较大）
     * sum大于s的话，就再遍历较大数字前面的数字（同理前面的数字较小）
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int s) {
        //最终返回的list,里面存放的两个数就是最终结果
        ArrayList<Integer> resultList = new ArrayList<>();
        //鲁棒性检查
        if (array.length < 2) {
            return resultList;
        }
        //指向较小元素的指针和较大元素的指针
        int start = 0;
        int end = array.length - 1;
        //
        while (start < end) {
            int sum = array[start] + array[end];
            if (sum == s) {
                resultList.add(array[start]);
                resultList.add(array[end]);
                break;
            } else if (sum < s) {
                start++;
            } else {
                end--;
            }
        }
        //
        return resultList;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        SumIsS sumIsS = new SumIsS();
        ArrayList<Integer> list = sumIsS.findNumbersWithSum(array, 9);
        System.out.println(list);
    }
}
