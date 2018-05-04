package Array;

//连续子数组的最大和
public class GreatestSumOfSubArray {

    /**
     * 思路
     * 当前和sum，最大和maxSum
     * 当前和sum是某一个子数组的和,若sum<=0,则说明当前元素加上这个sum反而会比当前元素小,因此舍弃之前的sum
     * 若sum>0，则正常和当前元素相加
     * 每次得到sum都要和maxSum做比较,若sum更大,则将maxSum更新
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        //鲁棒性检查
        if (array.length == 0) {
            return 0;
        }
        //最终返回结果
        int sum = 0;//当前和
        int maxSum = 0x80000000;//当前最大和
        //
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) {
                //当前子数组的和小于0,加上当前元素的话反而会比当前元素小,因此丢弃当前和,置为当前元素
                sum = array[i];
            } else {
                sum += array[i];
            }

            if (sum > maxSum) {
                //与之前最大和比较
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
