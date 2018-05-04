package Array;

public class TwoDimensionArrayFind {

    //在二维数组中进行查找
    public boolean Find(int target, int [][] array) {
        //首先获取二维数组的行列
        int row = array.length;//行数
        int column = array[0].length;//列数
        //当前右上角元素所在的行和列
        int currentRow = 0;
        int currentColumn = column - 1;
        //每次选取右上角元素和目标元素进行比较
        while (true) {
            //结束条件的两种判断:一种是当前右上角元素等于要查找的元素,另一种时遍历完了所有都没有找到元素,此时currentRow和currentColumn为row和-1
            if (currentColumn == -1 || currentRow == row) {
                //没有找到目标元素
                return false;
            }
            if (array[currentRow][currentColumn] == target) {
                //当前右上角元素就是要查找的元素
                return true;
            } else if (target > array[currentRow][currentColumn]) {
                //当要查找的元素大于右上角元素时,剔除该行
                currentRow++;
            } else {
                //当要查找的元素小于右上角元素时,剔除该列
                currentColumn--;
            }
        }
    }
}
