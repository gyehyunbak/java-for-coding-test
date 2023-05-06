package ThisIsJava.ch05.sec06;

public class ArrayCreateByValueListExample1 {
    public static void main(String[] args) {
        //배열 변수 선언과 배열 생성
        String[] season = {"Spring", "Summer", "Fall", "Winter"};

        //배열의 항목값 읽기
        System.out.println("Season[0] : " + season[0]);
        System.out.println("Season[1] : " + season[1]);
        System.out.println("Season[2] : " + season[2]);
        System.out.println("Season[3] : " + season[3]);

        //인덱스 1번의 항목의 값 변경
        season[1] = "여름";
        System.out.println("Season[1] : " + season[1]);
        System.out.println();

        //배열 변수 선언과 배열 생성
        int[] scores = {83, 90, 87};

        //총합과 평균 구하기
        int sum = 0;
        for(int i=0; i<scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("Total Sum : " + sum);
        double avg = (double) sum / scores.length;
        System.out.println("Average : " + avg);
    }
}
