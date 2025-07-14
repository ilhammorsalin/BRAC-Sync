package Sorting;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {6,4,1,9,4,3};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] inputArr) {
        int n = inputArr.length;

        if (n < 2) {
            return;
        }

        int mid = n/2;

        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for(int i=0; i<mid; i++){
            left[i] = inputArr[i];
        }

        for(int i=mid; i<n; i++){
            right[i-mid] = inputArr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(inputArr, left, right);

    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int sizeL = left.length;
        int sizeR = right.length;

        int i = 0, j = 0, k = 0;
        while (j < sizeL && k < sizeR) {
            if (left[j] <= right[k]) {
                arr[i] = left[j];
                j++;
            }

            else {
                arr[i] = right[k];
                k++;
            }
            i++;
        }

        while (j < sizeL) {
            arr[i] = left[j];
            j++;
            i++;
        }

        while(k < sizeR){
            arr[i] = right[k];
            k++;
            i++;
        }


    }
}
