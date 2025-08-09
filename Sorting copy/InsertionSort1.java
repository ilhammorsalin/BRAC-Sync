
import java.util.Arrays;

public class InsertionSort1 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 1, 2, 3};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    tools.swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}


