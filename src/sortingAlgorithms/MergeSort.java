package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 8, 9, 2, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int arr[], int left, int mid, int right) {
        int arrLen1 = mid - left + 1;
        int arrLen2 = right - mid;
        int L[] = new int[arrLen1];
        int R[] = new int[arrLen2];
        for (int i = 0; i < arrLen1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < arrLen2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;// Initial indexes of first and second arrays
        int k = left;// Initial index of merged array
        while (i < arrLen1 && j < arrLen2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            } else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
        while (i < arrLen1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < arrLen2) {
            arr[k++] = R[j++];
            j++;
            k++;
        }
    }

}
