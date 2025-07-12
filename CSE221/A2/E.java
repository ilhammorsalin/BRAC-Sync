import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        String[] arrStr = br.readLine().split(" ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int left = 0, sum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > k && left <= i) {
                sum -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLen);
        System.out.println(sb);
    }
}