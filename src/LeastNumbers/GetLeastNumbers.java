package LeastNumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//最小的k个数(topk问题)
public class GetLeastNumbers {

    /**
     * 思路
     * 使用最大堆来存放最小的k个数,当堆中的数不足k个的时候直接放入堆中即可
     * 若堆中的数已经有k个(堆满),则将元素和堆中最大的那个数比较(堆顶元素),比最大的数小,则删去堆顶元素,插入新元素,否则抛弃该元素
     */
    //找出数组中最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        //最终返回的结果
        ArrayList<Integer> resultList = new ArrayList<>();
        //鲁棒性检查
        if (input.length == 0 || k > input.length || k == 0) {
            return resultList;
        }
        //使用最大堆(优先队列)来存放最小的k个数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//实现最大堆的关键,因为PriorityQueue默认是最小堆
            }
        });
        //下面就是思路的实现
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() != k) {
                //堆没有满,则直接向堆中加入元素
                maxHeap.offer(input[i]);
            } else {
                //堆已满则和堆顶元素比较
                if (input[i] < maxHeap.peek()) {
                    maxHeap.poll();//删除堆顶元素
                    maxHeap.offer(input[i]);//加入新元素
                }
            }
        }
        //
        for (Integer integer : maxHeap) {
            resultList.add(integer);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] array = {1,2};
        int[] newArray = array;
        newArray[0] = 3;
    }
}
