package march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Убрать все последующие гласные, кроме первой.
 */
public class DeleteNextVowels {

    private static List<Character> vowels = Arrays.asList('a', 'e', 'y', 'u', 'i', 'o');
    private static List<Integer> vowelsCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
    private static String s1 = "aawwyyaafay";

    public static void main(String[] args) {

        deleteNextVowels();

        System.out.println(s1);
    }

    private static void deleteNextVowels() {
        for (int i = 0; i < s1.length(); i++) {

            char currentChar = s1.charAt(i);

            if (vowels.contains(currentChar)) {

                int index = vowels.indexOf(currentChar);

                if (vowelsCount.get(index) == 0) {
                    vowelsCount.add(index, vowelsCount.get(index) + 1);
                } else {
                    s1 = s1.substring(0, i) + s1.substring(i + 1);
                    i--;
                }
            }
        }
    }
}
