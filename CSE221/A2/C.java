import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int target = Integer.parseInt(firstLine[1]);

        String[] line = br.readLine().split(" ");
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(line[i]);
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i][0] + arr[left][0] + arr[right][0];

                if (sum == target) {
                    int idx1 = arr[i][1] + 1;
                    int idx2 = arr[left][1] + 1;
                    int idx3 = arr[right][1] + 1;
                    int[] result = { idx1, idx2, idx3 };
                    Arrays.sort(result);
                    System.out.println(result[0] + " " + result[1] + " " + result[2]);
                    return;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(-1);
    }
}