package Task2_2;

import java.util.*;

public class Main {

    private static final int SUM = 10;

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 7};
        System.out.println("Исходный массив : " + Arrays.toString(array));
        int[] pairOfNumbers = getPairOfNumbers(array);
        if(pairOfNumbers == null) {
            System.out.println("Массив не содержит чисел, сумма которых равна " + SUM);
        } else {
            System.out.println("Числа, дающие в сумме " + SUM + " : " + Arrays.toString(pairOfNumbers));
        }
    }

    private static int[] getPairOfNumbers(int[] array) {
        if(array != null) {
            List<Integer> list = Arrays.stream(array).boxed().toList();

            for(int num : list) {
                int secondNum = SUM - num;
                if(list.contains(secondNum)) {
                    return new int[]{num, secondNum};
                }
            }
        }
        return null;
    }
}
