package march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Найти 2 непарных числа в массиве.
 */
public class UnpairedNumbers {

    private static int[] tempArray = new int[]{2, 2, 1, 4, 4, 5, 1, 7, 5, 3};

    public static void main(String[] args) {

        System.out.println(getUnpairedNumbers3());
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

    private static List<Integer> getUnpairedNumbers2() {

        HashMap<Integer, Integer> numbersMap = new HashMap<>();
        ArrayList<Integer> unpairedNumbers = new ArrayList<Integer>();

        for (int value : tempArray) {
            numbersMap.put(value, numbersMap.getOrDefault(value, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : numbersMap.entrySet()) {
            // Если количество повторений цифры  % 2 != 0, то она не парная
            if (e.getValue() % 2 != 0) {
                unpairedNumbers.add(e.getKey());
            }
        }

        return unpairedNumbers;
    }

    private static List<Integer> getUnpairedNumbers3() {

        ArrayList<Integer> unpairedNumbers = new ArrayList<Integer>();

        // xor двух непарных элементов
        int xor = 0;
        for (int value : tempArray) {
            xor ^= value;
        }

        // изменяем результат на некоторую величину
        int new_xor = xor & ~(xor - 1);

        int x = 0;
        int y = 0;
        for (int value : tempArray) {
            if ((value & new_xor) == new_xor) {
                x = x ^ value;
            } else {
                y = y ^ value;
            }
        }

        unpairedNumbers.add(x);
        unpairedNumbers.add(y);

        return unpairedNumbers;
    }
}
