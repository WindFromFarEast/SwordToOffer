package String;

//翻转字符串,但是每个单词内的顺序不变 "I am a student." ----> "student. a am I"
public class ReverseString {

    /**
     * 思路
     * 先翻转整个字符串,再翻转每个单词,注意每个单词之间以空格分隔
     */
    public String ReverseSentence(String str) {
        //鲁棒性检查
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            return "";
        }
        //获取字符串的第一个位置和最后一个位置
        int start = 0;
        int end = str.length() - 1;
        //将字符串转为字符数组
        char[] string = str.toCharArray();
        //翻转整个字符串
        reverseWord(string, start, end);
        //为了从头开始翻转每个单词需要将end重置
        end = 0;
        //翻转字符串中的每个单词
        while (start < str.length()) {
            //要翻转最后一个单词时需要防止下标越界
            if (end == str.length()) {
                end--;
                reverseWord(string, start, end);
                break;
            }
            //
            if (string[end] != ' ') {
                end++;
            } else {
                reverseWord(string, start, end - 1);
                start = end + 1;
                end = start;
            }
        }
        return new String(string);
    }

    //翻转一个单词
    private void reverseWord(char[] string, int start, int end) {
        while (start < end) {
            char temp = string[start];
            string[start] = string[end];
            string[end] = temp;
            start++;
            end--;
        }
    }
}
