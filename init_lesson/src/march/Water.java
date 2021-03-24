package march;

/**
 * Дан массив высот - найти площадь воды в углублениях.
 */
public class Water {

    public static void main(String[] args) {
        System.out.println(getWater(new int[]{1, 2, 1, 3, 2, 1}));
    }

    /**
     * Подход two pointer
     */
    private static int getWater(int[] heights) {

        if (heights.length == 0) return 0;

        int leftIndex = 0;
        int rightIndex = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (leftIndex < rightIndex) {
            if (heights[leftIndex] < heights[rightIndex]) {
                leftMax = getMaxValue(leftMax, heights[leftIndex]);
                result += leftMax - heights[leftIndex];
                leftIndex++;
            } else {
                rightMax = getMaxValue(rightMax, heights[rightIndex]);
                result += rightMax - heights[rightIndex];
                rightIndex--;
            }
        }
        return result;
    }

    private static int getMaxValue(int first, int second) {

        return Math.max(first, second);
    }
}