
/**
 * Написать функцию int updateBit(int num, int i, int bit) - установить bit в числе num по позиции i.
 */
public class UpdateBitExercise {

    public static void main(String[] args) {

        // input data
        int num = 5;
        int position = 0;
        boolean bit = true;

        System.out.println(updateBit(num, position, bit));
    }

    private static int updateBit(int num, int position, boolean bit) {
        int result;
        int mask = 1 << position;

        if (bit) {
            result = num | mask;
        } else {
            result = num & (~mask);
        }

        return result;
    }
}

// If bit == false (0)

// 0 bit on position 0
// 001 << position 001 ^ 110 &
// 5 101 -> 100 4
// 4 100 -> 100 4
// 3 011 -> 010 2

// 0 bit on position 1
// 001 << position 010 ^ 101 &
// 5 101 -> 101 5
// 4 100 -> 100 4
// 3 011 -> 001 1

// 0 bit on position 2
// 001 << position 100 ^011 &
// 5 101 -> 001 1
// 4 100 -> 000 0
// 3 011 -> 011 3


// If bit == true (1)

// 1 bit on position 0
// 001 << position 001 |
// 5 101 -> 101 5
// 4 100 -> 101 5
// 3 011 -> 011 3

// 1 bit on position 1
// 001 << position 010 |
// 5 101 -> 111 7
// 4 100 -> 110 6
// 3 011 -> 011 3

// 1 bit on position 2
// 001 << position 100 |
// 5 101 -> 101 5
// 4 100 -> 100 4
// 3 011 -> 111 7
