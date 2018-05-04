package ReplaceSpace;

public class Test {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("asd dede qw");
        String string = ReplaceSpace.replace(stringBuffer);
        System.out.println(string);
    }
}
