package searchAlgorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 9};
        int indexOfSearchKey = binarySearch(arr, 5);
        System.out.println(indexOfSearchKey);
    }

    private static int binarySearch(int[] arr, int inputNum) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == inputNum) {
                return mid;
            } else if (inputNum < arr[mid]) {
                right = mid - 1;
            } else if (inputNum > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

}
