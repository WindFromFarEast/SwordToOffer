package Array;

//统计一个数字K在排序数组中出现的次数
public class NumberOfK {

    /**
     * 思路
     * 由于是排序数组,因此使用二分法，先找到第一个k的位置，再找到最后一个k的位置
     */
    public int GetNumberOfK(int [] array , int k) {
        //鲁棒性检查
        if (array.length == 0) {
            return 0;
        }
        //第一个k的位置
        int firstIndex = getFirstK(array, k);
        //最后一个k的位置
        int lastIndex = getLastK(array, k);
        //不存在k的情况
        if (firstIndex == -1 || lastIndex == -1) {
            return 0;
        }
        return lastIndex - firstIndex + 1;
    }

    //找到第一个k的位置
    private int getFirstK(int[] array, int k) {
        //第一个k的位置,默认不存在
        int firstIndex = -1;
        //二分法的左右边界
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            //中间位置
            int mid = left + (right - left) / 2;
            //先判断中间的数是否为k
            if (array[mid] == k) {
                //中间数为k
                if (mid == 0) {
                    //中间数为k并且也是第一个数时直接返回就可以
                    return mid;
                }
                if (array[mid - 1] != k) {
                    //中间数为k并且其前面一个数不是k,那么mid就是第一个k的位置
                    firstIndex = mid;
                    break;
                } else {
                    //中间数为k但是前面一个数也是k,那么说明中间这个k不是第一个k,在前半段继续查找
                    right = mid - 1;
                }
            } else {
                //中间的数不是k,继续二分查找k
                if (array[mid] > k) {
                    //中间的数大于k,在前半段继续查找
                    right = mid - 1;
                } else {
                    //中间的数小于k,在后半段继续查找
                    left = mid + 1;
                }
            }
        }
        return firstIndex;
    }

    //找到最后一个k的位置,思路与前面基本一致,不同的只是判断最后一个k的条件变成了下一个元素是否依然为k
    private int getLastK(int[] array, int k) {
        //最后一个k的位置,默认不存在
        int lastIndex = -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k) {
                if (mid == array.length - 1) {
                    //中间数为k并且也是最后一个数时直接返回就可以
                    return mid;
                }
                if (array[mid + 1] != k) {
                    lastIndex = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[mid] < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return lastIndex;
    }
}
