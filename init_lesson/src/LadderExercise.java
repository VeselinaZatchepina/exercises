
/**
 * Определить, сколько существует способов добраться с нулевой до N ступеней с шагом 1, 2, 3.
 * (Динамическое программирование)
 */
public class LadderExercise {

    /**
     * 0 ступень - 1 вариант
     * 1 ступень - 1 вариант
     * 2 ступень - 2 варианта
     * 3 ступень - 4 варианта
     * 4 ступень - 7 вариантов
     * ...
     */
    // Количество сутпеней
    private static final int N = 4;

    public static void main(String[] args) {
        System.out.println(count(N));
    }

    private static int count(int value) {
        if (value < 0) return 0;
        if (value == 0) return 1;

        return count(value - 1) + count(value - 2) + count(value - 3);
    }
}
