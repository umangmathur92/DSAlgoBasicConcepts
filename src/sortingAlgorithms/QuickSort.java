package sortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

    //https://www.youtube.com/watch?v=COk73cpQbFQ

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 8, 9, 2, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {//Instead of this, we can also write if(start>=end) {return;}
            int partitionIndex = partition(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, pIndex, i);//swap arr[pIndex] with arr[i]
                pIndex++;
            }
        }
        swap(arr, pIndex, end);//swap arr[pIndex] with arr[end]
        return pIndex;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int swapTemp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = swapTemp;
    }

}