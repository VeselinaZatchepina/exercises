package initlesson;

import java.util.ArrayList;

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
    private static final int N = 7;
    private static ArrayList<Integer> cache = new ArrayList<Integer>();

    public static void main(String[] args) {
        cache.add(0, 1);
        System.out.println(countWithCache(N));
    }

    private static int countWithCache(int value) {
        if (value < 0) return 0;
        if (value == 0) return cache.get(0);

        try {
            return cache.get(value);
        } catch (Exception e) {
            cache.add(value, countWithCache(value - 1) + countWithCache(value - 2) + countWithCache(value - 3));
            return cache.get(value);
        }
    }

    private static int countWithoutCache(int value) {
        if (value < 0) return 0;
        if (value == 0) return 1;

        return countWithoutCache(value - 1) + countWithoutCache(value - 2) + countWithoutCache(value - 3);
    }
}
