package march;

/**
 * Есть 2 числа M, N и две позиции битов i, j;
 * Нужен метод для вставки M в N таким образом, чтобы число M занимало позицию с бита j по i.
 * i, j таковы, что M гарантированно поместится в этот промежуток
 * Например: N = 10000000000, M = 10011, i = 2, j = 6; => N = 10001001100
 */
public class InsertNumber {

    private static final int A = 5; // 101
    private static final int B = 4; // 100
    private static final int START = 1;
    private static final int END = 3;

    public static void main(String[] args) {
        System.out.println(insertNumber2(A, B, START, END));
    }

    private static int insertNumber(int whereInsertNum, int forInsertNum, int start, int end) {

        // Переводим биты для вставки в единицы (whereInsertNum | (1 << c))
        // Переводим биты для вставки в нули (whereInsertNum ^ (1 << c))
        for (int c = start; c <= end; c++) {
            whereInsertNum = (whereInsertNum | (1 << c)) ^ (1 << c);
        }

        // Вставляем нужные биты
        return whereInsertNum | (forInsertNum << start);
    }

    private static int insertNumber2(int whereInsertNum, int forInsertNum, int start, int end) {

        // Единцы сдвигаем на end + 1 -> 11110000
        int leftPartOfMask = ~0 << (end + 1);
        // Единцу сдвигаем на start и вычитаем 1 -> 00011
        int rightPartOfMask = ((1 << start) - 1);
        // Получаем маску с обнуленными битами по нужным индексам -> 11110011
        int mask = leftPartOfMask | rightPartOfMask;

        // Обнуляем в числе куда надо вставить биты по нужным позициям
        int whereInsertNumCleared = whereInsertNum & mask;
        // Сдвигаем число для вставки на нужную позицию (start)
        int forInsertNumShifted = forInsertNum << start;

        // Устанавливаем биты
        return whereInsertNumCleared | forInsertNumShifted;
    }
}
