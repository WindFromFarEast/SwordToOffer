package String;

import java.util.HashMap;
import java.util.Map;

//字符串中第一个只出现一次的字符,返回其在字符串中的位置
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }

        //使用哈希表,key为字符,value为字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        //第一次遍历字符串,将每个字符及其出现次数存放到哈希表中
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int times = map.getOrDefault(ch, 0);
            map.put(ch, ++times);
        }
        //第二次遍历字符串,找到第一个只出现一次的字符
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int times = map.get(ch);
            if (times == 1) {
                return i;
            }
        }
        //返回-1表示没有只出现一次的字符
        return -1;
    }
}
