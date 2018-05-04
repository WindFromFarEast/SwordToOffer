package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//字符串的排列
public class Permulation {

    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);//字典排序
        }
        return (ArrayList)res;
    }

    //对i位置及其之后的字符进行排列
    /**
     * 对i位置及其之后的字符进行排列的整体递归思路：
     * 将字符串看成位置为i的字符和后面所有字符的组合
     * 每次递归都进行下面的三步：
     * 1、将位置为i的字符依次和自己以及后面的字符交换位置,此时i位置的字符固定
     * 2、对后面的所有字符进行排列(递归)
     * 3、将位置交换回来
     */
    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            //递归停止条件
            String val = String.valueOf(cs);
            if (!list.contains(val))
            list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
