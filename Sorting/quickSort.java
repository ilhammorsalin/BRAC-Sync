import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class quickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        HashMap hash = new HashMap<Integer, Integer>();
        
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l, j = r;

        while (i < j) {
            while (i <= r && arr[i] <= pivot)
                i++;
            while (j >= l && arr[j] > pivot)
                j--;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);


        return j;



    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int j = partition(arr, l, r);
            quickSort(arr, l, j - 1);
            quickSort(arr, j + 1, r);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}