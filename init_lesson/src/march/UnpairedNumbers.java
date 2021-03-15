package march;

import java.util.ArrayList;
import java.util.List;

/**
 * Найти 2 непарных числа в массиве.
 */
public class UnpairedNumbers {

    private static int[] tempArray = new int[]{2, 2, 1, 4, 4, 5, 1, 6};

    public static void main(String[] args) {

        System.out.println(getUnpairedNumbers());
    }

    /**
     * Общая идея:
     * Проходим по циклу, проверяя дает ли операция xor с текущим числом - 0.
     * Если дойдя до конца массива xor не дала 0 - значит это число непарное.
     * Записываем непарные числа в список.
     */
    private static List<Integer> getUnpairedNumbers() {

        ArrayList<Integer> unpairedNumbers = new ArrayList<Integer>();
        Integer currentUnpairedNumber = null;

        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray.length; j++) {

                // Исключаем xor самого числа на себя
                if (i == j) continue;

                if ((tempArray[i] ^ tempArray[j]) != 0) {
                    currentUnpairedNumber = tempArray[i];
                } else {
                    // Если xor дала 0, то цикл прерываем
                    currentUnpairedNumber = null;
                    break;
                }
            }

            // Записываем итоговую непарную цифру в список
            if (currentUnpairedNumber != null) {
                unpairedNumbers.add(currentUnpairedNumber);
                currentUnpairedNumber = null;
            }
        }

        return unpairedNumbers;
    }
}
