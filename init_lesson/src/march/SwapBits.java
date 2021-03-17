package march;

/**
 * Входные данные: int x. Необходимо поменять четные и нечетные биты местами (0 и 1, 2 и 3 и тд).
 */
public class SwapBits {

    private static final int evenMask = 0xAAAAAAAA; // 10101010101010101010101010101010
    private static final int oddMask = 0x55555555; // 01010101010101010101010101010101
    private static final int N = 2;

    public static void main(String[] args) {
        System.out.println(swapBits(N));
    }

    /**
     * Накладываем маску для получения четных и нечетных битов.
     * Сдвигаем четные направо, нечетные налево -> И объединяем операцией |.
     */
    private static int swapBits(int num) {
        return (num & evenMask) >> 1 | (num & oddMask) << 1;
    }
}
