package sort;

import java.util.NoSuchElementException;

//快速排序
public class QuickSort {

    public void quickSort(int[] array) {
        if (array.length == 0) {
            throw new NoSuchElementException();
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = partition(array, start, end);
            quickSort(array, start, mid - 1);
            quickSort(array, mid + 1, end);
        } else {
            return;
        }
    }

    private int partition(int[] array, int start, int end) {
        int v = array[start];
        int j = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < v) {
                swap(array, ++j, i);
            }
        }
        swap(array, start, j);
        return j;
    }

    private void swap(int[] array, int i, int i1) {
        int temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = {1,5,3,6,8,3,4,6,7};
        sort.quickSort(array);
        System.out.println(array.toString());
    }
}
