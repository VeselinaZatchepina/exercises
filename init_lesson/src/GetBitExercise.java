
/**
 * Написать функцию int getBit (int num, int i) для получения i-го бита числа num.
 */
public class GetBitExercise {

    public static void main(String[] args) {

        // input data
        int num = 4;
        int position = 2;

        System.out.println(getBit(num, position));
    }

    private static int getBit(int num, int position) {
        return (num >> position) & 1;
    }
}
