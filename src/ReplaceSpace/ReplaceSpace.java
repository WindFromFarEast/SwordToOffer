package ReplaceSpace;

public class ReplaceSpace {

    private ReplaceSpace() { }

    //将字符串中的空格替换成%20，时间复杂度为O(n)
    public static String replace(StringBuffer str) {
        //首先判断输入的合理性
        if (str == null || str.length() == 0) {
            return null;
        }
        //字符串所含空格数
        int spaceNum = 0;
        //计算字符串中的空格数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        //旧字符串的末尾索引
        int indexOld = str.length() - 1;
        //将字符串长度更新为所有空格都替换成%20后的长度
        int newLength = str.length() + spaceNum * 2;
        str.setLength(newLength);
        //新字符串的末尾索引
        int indexNew = newLength - 1;
        //使用两个指向旧字符串末尾和新字符串末尾的索引indexOld和indexNew，若indexOld指向的字符不是空格，则将这个字符复制到
        //indexNew指向的位置，并且indexNew和indexOld分别向前移动一个位置
        //若indexOld指向的位置是空格，则indexNew向前移动三格，并将移动过的格子赋值为%20，indexOld向前移动一格
        while (indexOld < indexNew && indexOld >= 0) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
                indexOld--;
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld--));
            }
        }
        return str.toString();
    }

}
