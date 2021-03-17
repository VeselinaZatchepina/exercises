package march;

/**
 * Дано: double x; x in [0, 1];
 * To binary form.
 * if >= 32 rank -> Error
 */
public class DoubleToBinary {

    public static void main(String[] args) {

        System.out.println(doubleToBinary(0.5));
    }

    private static String doubleToBinary(double value) {
        StringBuilder builder = new StringBuilder();
        builder.append(".");

        while (value > 0) {
            if (builder.length() > 32) {
                return "More than 32 characters";
            }

            // умножаем для определения целой части числа
            double currentResult = value * 2;

            if (currentResult >= 1) {
                builder.append(1);
                value = currentResult - 1;
            } else {
                builder.append(0);
                value = currentResult;
            }
        }

        return builder.toString();
    }
}
