package RotateArray;

import java.util.NoSuchElementException;

//旋转数组中的最小数
public class Solution {

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            throw new NoSuchElementException();
        }
        //二分查找法的两个指针
        int index1 = 0;
        int index2 = array.length - 1;
        //中间数字的指针
        int midIndex = 0;
        //一旦发现该旋转数组的第一个数字小于最后一个数字,就可以断定该数组整个有序,可以直接返回第一个数字.
        if (array[index1] < array[index2]) {
            return array[index1];
        }
        //
        while (index2 - index1 != 1) {
            midIndex = index1 + (index2 - index1) / 2;
            if (array[midIndex] >= array[index1]) {
                //若中间数字大于第一个指针指向的数字,说明中间数字处在前半段递增子序列
                index1 = midIndex;
            } else if (array[midIndex] <= array[index2]) {
                //若中间数字小于第二个指针指向的数字,说明中间数字处在后半段递增子序列
                index2 = midIndex;
            }
        }
        return array[index2];
    }
}
