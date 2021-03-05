package march;

/**
 * if (x==a) x=b; if (x==b) x=a;
 * Написать в одну строчку, через битовые операции.
 */
public class InOneLine {

    private static final int A = 2;
    private static final int B = 33;
    private static final int X = A;

    public static void main(String[] args) {
        System.out.println(getBit(X, A, B));
    }

    private static int getBit(int x, int a, int b) {
        return ((x ^ a) | b) & ((x ^ b) | a);
    }
}
