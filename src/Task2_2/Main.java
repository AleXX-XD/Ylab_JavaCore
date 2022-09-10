package Task2_2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 7};
        int sum = 10;
        System.out.println("Исходный массив : " + Arrays.toString(array));
        int[] pairOfNumbers = getPairOfNumbers(array, sum);
        if (pairOfNumbers == null) {
            System.out.println("Массив не содержит чисел, сумма которых равна " + sum);
        } else {
            System.out.println("Числа, дающие в сумме " + sum + " : " + Arrays.toString(pairOfNumbers));
        }
    }

    private static int[] getPairOfNumbers(int[] array, int sum) {
        if (array != null) {
            List<Integer> list = Arrays.stream(array).boxed().toList();

            for (int num : list) {
                int secondNum = sum - num;
                if (list.contains(secondNum)) {
                    return new int[]{num, secondNum};
                }
            }
        }
        return null;
    }
}