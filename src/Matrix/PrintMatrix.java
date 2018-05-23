package Matrix;

import java.util.ArrayList;

public class PrintMatrix {

    //顺时针打印矩阵,不一定是N × N的矩阵,也有可能是M × N的矩阵
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        //获取矩阵的行和列
        int rows = matrix.length;//行数
        int columns = matrix[0].length;//列数
        //鲁棒性检查
        if (rows <= 0 || columns <= 0) {
            return null;
        }
        //最终返回的结果
        ArrayList<Integer> list = new ArrayList<>();
        //每一圈的左上角元素坐标
        int start = 0;
        //从外到内循环打印每一圈，每一次循环打印一圈
        while (rows > start * 2 && columns > start * 2) {
            printEveryCircle(matrix, rows, columns, start, list);//打印一圈
            start++;//每打印完一圈,左上角的xy坐标都分别加1
        }
        return list;
    }

    //打印左上角坐标为(start, start)的一圈 ps:行--->Y  列--->X,这道题的难点在于弄清行列和xy之间的对应关系
    private void printEveryCircle(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> list) {
        //终止坐标（一圈的右下角元素的坐标）
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //从左向右打印一行,这是肯定存在的
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }
        //从上到下打印一列,只有终止行号(endY)大于起始行号才需要这么做
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);//处在同一列(endX)内
            }
        }
        //从右到左打印一行,只有终止行号(endY)大于起始行号，并且终止列号(endX)大于起始列号时才需要这么做
        if (endY > start && endX >start) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);//处在同一行(endY)内
            }
        }
        //从下到上打印一列,只有终止行号(endY)比起始行号至少大2,并且终止列号大于起始列号时才需要这么做
        if (endY >= start + 2 && endX > start) {
            for (int i = endY - 1; i >= start + 1; i--) {
                list.add(matrix[i][start]);
            }
        }
    }
}
