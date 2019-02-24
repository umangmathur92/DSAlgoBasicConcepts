package sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 8, 9, 2, 7};
        int[] sortedArr = bubbleSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int curr = arr[j];
                int next = arr[j + 1];
                if (curr > next) {
                    arr[j + 1] = curr;
                    arr[j] = next;
                }
            }
        }
        return arr;
    }

    private static int[] bubbleSortOptimized(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (arr[i + 1] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
        return arr;
    }

}