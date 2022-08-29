package Task1_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] testArray1 = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] testArray2 = new int[]{8,6,4,4,6,8,0,2,9,1};
        assert (Arrays.equals(mergeSort(testArray1), new int[]{0,1,2,3,4,5,6,7,8,9})) : "Ошибка сортировки";
        assert (Arrays.equals(mergeSort(testArray2), new int[]{0,1,2,4,4,6,6,8,8,9})) : "Ошибка сортировки";

        int[] array = new int[]{5,6,3,2,5,1,4,9,1};
        System.out.println("Исходный массив :");
        printArray(array);
        assert (Arrays.equals(mergeSort(array), new int[]{1,1,2,3,4,5,5,6,9})) : "Ошибка сортировки";
        System.out.println("\n");
        System.out.println("Отсортированный массив :");
        printArray(mergeSort(array));
    }

    private static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size = size * 2;
        }
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start,
                              int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            if (src1End - src1Start >= 0) System.arraycopy(src1, src1Start, dest, src1Start, src1End - src1Start);
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}