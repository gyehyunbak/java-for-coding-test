package ThisIsJava.ch05.sec09;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldStrArray = {"a", "b", "c"};
        String[] newStrArray = new String[5];
        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
        int i = 0;
        while(i<newStrArray.length) {
            System.out.println(newStrArray[i]);
            i++;
        }
    }
}
