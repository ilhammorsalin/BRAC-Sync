import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int count = mergeSort(arr);

        System.out.println(count);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int mergeSort(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        if (n <= 1) {
            return 0;
        }

        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        int countL = mergeSort(left);
        int countR = mergeSort(right);

        int countMerge = merge(arr, left, right);

        return countL + countR + countMerge;
    }

    public static int merge(int[] A, int[] left, int[] right) {
        int count = 0;

        int sizeL = left.length;
        int sizeR = right.length;

        int i = 0, j = 0, k = 0;

        while (j < sizeL && k < sizeR) {
            if (left[j] <= right[k]) {
                A[i++] = left[j++];
            } else if (left[j] > (right[k]) * (right[k])) {
                A[i++] = right[k++];
                count++;
            } else {
                A[i++] = right[k++];
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