package UglyNumber;

public class GetUglyNumber {

    /**
     * 思路
     * 创建一个数组存放所有的丑数
     * 所有的丑数*2、*3、*5之后依然是一个丑数,利用这个性质可以避开对非丑数的处理
     * 每次将数组中的元素*2 *3 *5中的最小值放入下一个位置...只可意会不可言传,看代码就知道什么意思了...语言表达能力有限qwq
     */
    public int GetUglyNumber_Solution(int index) {
        //鲁棒性检查
        if (index <= 0) {
            return 0;
        }
        //创建一个存放所有丑数的排序数组
        int[] array = new int[index];
        //第一个丑数为1,之所以放入第一个丑数是因为只要有第一个丑数就可以得到所有丑数,请看思路的第二行
        array[0] = 1;
        //下一个丑数在数组中的索引
        int nextUglyNumberIndex = 1;
        //被这三个指针指向的元素m说明m*2、m*3、m*5还未被放在丑数数组中
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (nextUglyNumberIndex < index) {
            //得到index2、index3、index5指向的元素分别乘以2、3、5的最小值
            int min = min(array[index2] * 2, array[index3] * 3, array[index5] * 5);
            //下一个要存放的丑数就是上述三者的最小值
            array[nextUglyNumberIndex] = min;
            //例如在上面index2指向的元素*2是三者最小值,那么index2指向的元素*2得到的丑数就已经被放在了丑数数组中(注意这个元素*2 、*3还没有被放在数组中),其他同理
            if (array[index2] * 2 == array[nextUglyNumberIndex])
                index2++;
            if (array[index3] * 3 == array[nextUglyNumberIndex])
                index3++;
            if (array[index5] * 5 == array[nextUglyNumberIndex])
                index5++;
            //下一个丑数要存放的位置
            nextUglyNumberIndex++;
        }
        return array[index - 1];
    }

    //得到三个数的最小值
    private int min(int one, int two, int three) {
        int min = one < two ? one : two;
        min = min < three ? min : three;
        return min;
    }
}
