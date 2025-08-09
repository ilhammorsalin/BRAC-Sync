

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 3, 9, 7, 6, 8};
        Sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void Sort(int[] arr, int l, int h) {
        if (l < h) {
            int j = Partition(arr, l, h);
            Sort(arr, l, (j - 1));
            Sort(arr, (j + 1), h);
        }
    }

    public static int  Partition(int[] arr, int l, int h) {
        int i = l, j = h;
        int pivot = arr[l];
        while (i < j) {
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
