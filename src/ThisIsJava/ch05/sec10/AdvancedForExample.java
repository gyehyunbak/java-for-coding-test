package ThisIsJava.ch05.sec10;

public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = {95, 71, 84, 93, 46};
        int sum = 0;
        for(int score : scores) {
            sum = sum + score;
        }
        System.out.println(sum);
        double avg = (double) sum / scores.length;
        System.out.println(avg);
    }
}
