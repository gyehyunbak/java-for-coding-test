package ThisIsJava.ch05.sec06;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {
        //배열 변수 선언과 배열 생성
        int[] arr1 = new int[3];
        //배열 항목의 초기값 출력
        for(int i=0; i<3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println();
        //배열 항목의 값 변경
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        //배열 항목의 변경 값 출력
        for(int i=0; i<3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println("\n");
    }
}
