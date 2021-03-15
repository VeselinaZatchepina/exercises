package march;

import java.util.ArrayList;

/**
 *
 */
public class CompressedString {

    private static ArrayList characters = new ArrayList();
    private static ArrayList countOfCharacter = new ArrayList();
    private static final String TEMP = "hddgggfdfffffd";

    public static void main(String[] args) {

        defineCharactersAndCounts(TEMP);

        System.out.println(getCompressedString());
    }

    /**
     * Считаем последовательное количество символа и пишем в список символ - количество.
     */
    private static void defineCharactersAndCounts(String value) {
        int countOfChar = 1;
        char currentChar = value.charAt(0);

        for (int i = 1; i < value.length(); i++) {
            if (currentChar == value.charAt(i)) {
                countOfChar++;
            } else {
                writeCharacterAndCount(currentChar, countOfChar);
                countOfChar = 1;
                currentChar = value.charAt(i);
            }
        }
        writeCharacterAndCount(currentChar, countOfChar);
    }

    /**
     * Составляем сжатую строку из символов и количеств этих символов.
     *
     * @return сжатая строка
     */
    private static String getCompressedString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < characters.size(); i++) {
            builder.append(characters.get(i)).append(countOfCharacter.get(i));
        }

        return builder.toString();
    }

    private static void writeCharacterAndCount(char currentChar, int countOfChar) {
        characters.add(currentChar);
        countOfCharacter.add(countOfChar);
    }
}
