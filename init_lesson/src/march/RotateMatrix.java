package march;

import java.util.Arrays;

/**
 * Есть матрица NxN.
 * Каждый пиксель представлен 4 байтами.
 * Написать метод для поворота матрицы на 90*.
 */
public class RotateMatrix {

    private static final int N = 4;
    private static final long[][] tempArray = {{0, 1, 2, 0}, {3, 0, 0, 0}, {4, 0, 0, 0}, {0, 5, 6, 0}};

    public static void main(String[] args) {

        rotateMatrix();
        System.out.println(Arrays.deepToString(tempArray));
    }

    /**
     * По часовой стрелке меняем местами значения
     */
    private static void rotateMatrix() {

        for (int i = 0; i < N / 2; i++) {

            for (int j = i; j < N - i - 1; j++) {

                long temp = tempArray[i][j];

                tempArray[i][j] = tempArray[N - 1 - j][i];
                tempArray[N - 1 - j][i] = tempArray[N - 1 - i][N - 1 - j];
                tempArray[N - 1 - i][N - 1 - j] = tempArray[j][N - 1 - i];
                tempArray[j][N - 1 - i] = temp;
            }
        }

    }
}
