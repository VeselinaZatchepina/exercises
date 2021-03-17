package march;

/**
 * Существует мето isSubstring - он проверяет является ли одно слово подстрокой другого.
 * Есть 2 строки s1 s2. Нужно проверить, получена ли s1 циклическим сдвигом из s2.
 * isSubstring можно вызвать только 1 раз.
 * waterbottle <- erbottlewat
 */
public class CyclicShift {

    private static final String firstString = "abcd";
    private static final String secondString = "cdab";

    /**
     * Решение без использования метода isSubstring.
     */
    public static void main(String[] args) {

        System.out.println(
                firstString.equals(reverseToRightShiftedString())
                        || firstString.equals(reverseToLeftShiftedString())
        );
    }

    /**
     * Проверяем сдвинута ли строка по часовой стрелке
     */
    private static String reverseToRightShiftedString() {

        // Индекс первого символа первой строки во второй строке
        int index = secondString.indexOf(firstString.charAt(0));

        StringBuilder builder = new StringBuilder();

        // Конкатенируем символы строки от index до конца циклически сдвинутой строки
        for (int i = index; i < secondString.length(); i++) {
            builder.append(secondString.charAt(i));
        }

        // Конкатенируем символы строки от 0 до index циклически сдвинутой строки
        for (int i = 0; i < index; i++) {
            builder.append(secondString.charAt(i));
        }

        return builder.toString();
    }

    /**
     * Проверяем сдвинута ли строка против часовой стрелки
     */
    private static String reverseToLeftShiftedString() {

        // Индекс первого символа первой строки во второй строке
        int index = secondString.indexOf(firstString.charAt(0));

        StringBuilder builder = new StringBuilder();

        // Конкатенируем символы строки от index до начала циклически сдвинутой строки
        for (int i = index; i >= 0; i--) {
            builder.append(secondString.charAt(i));
        }

        // Конкатенируем символы строки от длины второй строки до index циклически сдвинутой строки
        for (int i = secondString.length() - 1; i > index; i--) {
            builder.append(secondString.charAt(i));
        }

        return builder.toString();
    }

}
