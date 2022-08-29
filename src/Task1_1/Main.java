package Task1_1;

public class Main {

    private static final int ARRAY_HEIGHT = 9;
    private static final int ARRAY_WIDTH = 9;
    private static final int BOUND = 3;         //Ограничение количества цифр в генерируемых числах (не более 15)
    private static int numberForCalculation = 0;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        long[][] array = new long[ARRAY_HEIGHT][ARRAY_WIDTH];
        initializingArray(array);

        System.out.println(ANSI_PURPLE + "Матрица " + ARRAY_HEIGHT + " х " + ARRAY_WIDTH + " :");
        int countLinesForColor = Math.round((float) array.length / 3);
        String color = "";
        for (int i = 0; i < array.length; i++) {
            if (i < countLinesForColor) {
                color = ANSI_RESET;
            } else if (i < countLinesForColor * 2) {
                color = ANSI_BLUE;
            } else if (i < countLinesForColor * 3) {
                color = ANSI_RED;
            }
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(color + " " + array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ANSI_GREEN + "\nМаксимальное значение = " + getMaxNumber(array));
        System.out.println("Минимальное значение = " + getMinNumber(array));
        System.out.println("Среднее значение = " + getAvgValue(array));
    }

    private static void initializingArray(long[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = generateNumber();
            }
        }
    }

    private static long generateNumber() {
        long value1 = System.currentTimeMillis();
        long value2 = value1 - (value1 / 1000) * 1000;
        numberForCalculation += value2 - value1;
        double finalValue = Math.abs((double) value2 / numberForCalculation);
        String number = (Double.toString(finalValue));
        number = number.substring(0, number.length() - 4);

        long range = 1;
        for (int i = 1; i < Math.min(BOUND, 15); i++) {
            range = range * 10;
        }
        double result = Double.parseDouble(number) * range;
        return Math.round(result) - 1;
    }

    private static long getMaxNumber(long[][] array) {
        long max = Long.MIN_VALUE;
        for (long[] longs : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (max < longs[j]) {
                    max = longs[j];
                }
            }
        }
        return max;
    }

    private static long getMinNumber(long[][] array) {
        long min = Long.MAX_VALUE;
        for (long[] longs : array) {
            for (int j = 0; j < array[0].length; j++) {
                if (min > longs[j]) {
                    min = longs[j];
                }
            }
        }
        return min;
    }

    private static float getAvgValue(long[][] array) {
        long sum = 0;
        long count = 0;
        for (long[] longs : array) {
            for (int j = 0; j < array[0].length; j++) {
                sum += longs[j];
                count++;
            }
        }
        return (float) sum / count;
    }
}