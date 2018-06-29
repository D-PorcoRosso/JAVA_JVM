import java.util.Random;

public class RandomExample {

    private static final Random rnd = new Random();

    static int random( int n ) {
        return Math.abs(rnd.nextInt())%n;
    }

    public static void main(String[] args) {
        int n = 2 * 1234567;
        int[] count = new int[n+1];
        int index = 0;
        for ( int i = 0 ; i < 1000000 ; i++ ) {
            index = random(n);
            count[index]++;
        }
        for ( int i : count ) {
            System.out.println(i);
        }
    }
}