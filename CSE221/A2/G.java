import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int numOfRanges = Integer.parseInt(line[1]);

        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        for (int i = 0; i < numOfRanges; i++) {
            String[] query = br.readLine().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);

            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            int lower = left;

            left = 0;
            right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] <= y) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int upper = left;

            int count = upper - lower;
            System.out.println(count);
        }
    }
}