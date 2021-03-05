package initlesson;

/**
 * Написать функцию int updateBit(int num, int i) - установить bit == 1 в числе num по позиции i.
 */
public class UpdateBitExercise {

    public static void main(String[] args) {

        // input data
        int num = 1;
        int position = 1;

        System.out.println(updateBit(num, position));
    }

    private static int updateBit(int num, int position) {
        return num | (1 << position);
    }
}