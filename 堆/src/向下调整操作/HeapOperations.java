package 向下调整操作;

import java.util.Arrays;

public class HeapOperations {
    //O(logn)
    public static void shiftDown(long[] array, int size, int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }

            int rightIndex = leftIndex + 1;
            int minIndex = leftIndex;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }

            if (array[index] <= array[minIndex]) {
                return;
            }

            long t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;

            index = minIndex;
        }
    }

    public static void main(String[] args) {
        long[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37, -1, -1 };
        int size = 10;

        shiftDown(array, size, 0);

        System.out.println(Arrays.toString(array));
    }
}
