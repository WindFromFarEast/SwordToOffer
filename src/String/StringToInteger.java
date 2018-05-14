package String;

//将字符串转为整数
public class StringToInteger {

    public int StrToInt(String str) {
        //最终返回的整数
        long num = 0;
        //鲁棒性检查
        if (str == null || str.length() == 0) {
            return (int) num;
        }
        //将字符串转为字符数组
        char[] chArray = str.toCharArray();
        //符号位标识
        boolean minus = false;//默认为正数
        //先检查第一位是否为符号位
        if (chArray[0] == '+') {
            //第一位为正号说明为正数,去除符号位
            chArray = ignoreSymbol(chArray);
        } else if (chArray[0] == '-') {
            //第一位为负号说明为负数
            minus = true;
            //去除符号位
            chArray = ignoreSymbol(chArray);
        }
        //若第一位不是符号位则默认是正数,不需要去除符号位,开始转换
        if (chArray.length > 0) {
            num = StrToInt(chArray, minus);
        }
        //
        return (int) num;
    }

    //剔除第一位符号位
    private char[] ignoreSymbol(char[] chArray) {
        char[] chars = new char[chArray.length - 1];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chArray[i + 1];
        }
        return chars;
    }

    //将去除符号位的字符数组转为整数
    private long StrToInt(char[] chArray, boolean minus) {
        //最终返回的整数
        long num = 0;
        //符号位
        int flag = minus ? -1 : 1;
        //
        for (int i = 0; i < chArray.length; i++) {
            //先判断当前字符是否是0~9
            if (chArray[i] >= '0' && chArray[i] <= '9') {
                num = num * 10 + flag * (chArray[i] - '0');//计算当前值的时候需要将前一位乘以10
                //判断是否正溢出或负溢出
                if ((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)) {
                    //发生溢出直接返回0
                    return 0;
                }
            } else {
                //不是0~9的字符直接返回0
                return 0;
            }
        }
        return num;
    }
}
