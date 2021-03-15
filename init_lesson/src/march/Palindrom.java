package march;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Определить, является ли строка палиндромом (tabacocabat - читается одинаково и слева направо и справа налево).
 */
public class Palindrom {

    private static final String TEMP = "tabacocabat";

    public static void main(String[] args) {

        Pair<List<Character>, List<Integer>> result = defineCharsCount(TEMP);

        System.out.println(isStringIsPalindrom(result.component2()));
    }

    /**
     * @param value строка, которую проверяем является ли она палиндромом.
     * @return списки из уникальных символов и их количеств.
     */
    private static Pair<List<Character>, List<Integer>> defineCharsCount(String value) {
        ArrayList<Character> charList = new ArrayList<Character>();
        ArrayList<Integer> countList = new ArrayList<Integer>();

        for (int i = 0; i < value.length(); i++) {

            char currentChar = value.charAt(i);
            Integer currentCharCount = 0;

            for (int j = 0; j < value.length(); j++) {
                if (value.charAt(j) == currentChar && (!charList.contains(value.charAt(j)))) {
                    currentCharCount++;
                }
            }

            charList.add(currentChar);
            countList.add(currentCharCount);
        }

        return new Pair(charList, countList);
    }

    /**
     * Если количество нечтных колчеств символов > 1 - то строка не палиндром, иначе является.
     */
    private static String isStringIsPalindrom(List<Integer> listOfCount) {

        int countOfOdd = 0;

        for (Integer integer : listOfCount) {
            if (integer % 2 != 0) {
                countOfOdd++;
            }
        }

        if (countOfOdd > 1) {
            return "NO";
        } else {
            return "YES";
        }
    }
}
