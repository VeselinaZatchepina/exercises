package initlesson;

/**
 * Определить, является ли заданная строка результатом перестановки символов другой строки.
 */
public class Exercise {

    private static final int COUNT_OF_CHARS = 26; // [a(97)..z(122)]

    private static int[] firstCharCountArray = new int[COUNT_OF_CHARS];
    private static int[] secondCharCountArray = new int[COUNT_OF_CHARS];

    public static void main(String[] args) {
        String firstString = "asdfqgh";
        String secondString = "qhfdasg";

        printIsStringsContainsTheSameChars(firstString, secondString);
    }

    private static void printIsStringsContainsTheSameChars(String firstString, String secondString) {
        defineCharsCount(firstString, firstCharCountArray);
        defineCharsCount(secondString, secondCharCountArray);

        System.out.println(isStringsContainsTheSameChars());
    }

    /**
     * @param value         строка, для подсчета количества каждого символа в диапазоне от [a(97)..z(122)]
     * @param arrayForCount массив для записи общего количества каждого символа из диапазона.
     */
    private static void defineCharsCount(String value, int[] arrayForCount) {
        for (int i = 0; i < value.length(); i++) {
            arrayForCount[value.charAt(i) - 'a']++;
        }
    }

    private static boolean isStringsContainsTheSameChars() {
        for (int i = 0; i < COUNT_OF_CHARS; i++) {
            if (firstCharCountArray[i] != secondCharCountArray[i]) {
                return false;
            }
        }

        return true;
    }
}
