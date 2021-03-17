package march;

/**
 * Входные данные: int a, int b. Необходимо посчитать количество битов, чтобы a->b.
 */
public class CountOfBits {

    private static final int A = 29;
    private static final int B = 15;

    public static void main(String[] args) {
        System.out.println(getDiffCount(A, B));
    }

    private static int getDiffCount(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }
}
