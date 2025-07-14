import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(str[i]);
        }

        long count = mergeSort(arr);

        System.out.println(count);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static long mergeSort(long[] arr) {
        int n = arr.length;
        int mid = n / 2;

        if (n <= 1) {
            return 0L;
        }

        long[] left = new long[mid];
        long[] right = new long[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        long countL = mergeSort(left);
        long countR = mergeSort(right);

        long countMerge = merge(arr, left, right);

        return countL + countR + countMerge;
    }

    public static long merge(long[] A, long[] left, long[] right) {
        long count = 0L;

        int sizeL = left.length;
        int sizeR = right.length;

        int i = 0, j = 0, k = 0;

        while (j < sizeL && k < sizeR) {
            if (left[j] <= right[k]) {
                A[i++] = left[j++];
            } else {
                A[i++] = right[k++];
                count += sizeL - j;
            }
        }

        while (j < sizeL) {
            A[i++] = left[j++];
        }
        while (k < sizeR) {
            A[i++] = right[k++];
        }

        return count;
    }
}