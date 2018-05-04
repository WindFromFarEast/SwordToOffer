package RepeatNumber_3;

public class Duplicate {

    private Duplicate() { }

    //返回数组array中一个重复的元素
    public static boolean duplicate(int[] array, int[] duplication) {
        //检查array是否为空
        if (array == null || array.length <= 0) {
            throw new RuntimeException("Invalid Input");
        }
        //检查array中元素是否满足在0~n-1的范围内
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] >= array.length) {
                throw new RuntimeException("Invalid Element");
            }
        }
        //当前元素m
        int m;
        for (int i = 0; i < array.length; i++) {
            m = array[i];
            if (m != i) {
                //若当前元素m和下标i不相等,比较当前元素m和array[m]
                if (m == array[m]) {
                    //当前元素m和array[m]相等,m就是重复元素
                    duplication[0] = m;
                    return true;
                } else {
                    //当前元素m和array[m]不相等,交换两者位置,把m放到正确的位置上
                    swap(array, m, i);
                }
            }
        }
        //没有重复元素
        return false;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
