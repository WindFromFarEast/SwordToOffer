package RepeatNumber_3;

public class DuplicateTwo {

    private DuplicateTwo() { }

    /**
     * 获取数组array中的重复元素,不允许修改数组array
     * @param array
     * @return repeat number,若不存在返回-1,非法输入返回-2
     */
    public static int getDuplication(int[] array) {
        //先判断数组是否为空
        if (array == null || array.length <= 0) {
            return -2;
        }
        //再判断数组元素是否满足在1~n的范围内
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 1 || array[i] > array.length - 1) {
                return -2;
            }
        }
        //利用二分查找的思想
        int start = 1;
        int end = array.length - 1;
        while (start <= end) {
            //数组元素大小的中值
            int mid = start + (end - start) / 2;
            //统计大小在start~mid和mid+1~end范围内元素的个数,若个数大于对应区间应该有的个数,则该区间内有重复数字
            int count = countRange(array, start, mid);//元素大小在start~mid范围内的元素个数
            //start等于end时,若数组内这个大小的元素大于一个,那么这个元素就是重复元素
            if (start == end) {
                if (count > 1) {
                    return start;
                }
                break;
            }
            if (count > (mid - start) + 1) {
                //元素大小在start~mid范围内的元素有重复
                end = mid;
            } else {
                //元素大小在mid+1~end范围内的元素有重复
                start = mid + 1;
            }
        }
        return -1;
    }

    //统计数组array中元素大小在[start,end]的元素个数
    private static int countRange(int[] array, int start, int end) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= start && array[i] <= end) {
                count++;
            }
        }
        return count;
    }
}
