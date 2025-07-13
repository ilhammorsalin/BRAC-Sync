import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
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

        int[] freq = new int[n + 2];

        int left = 0, maxLen = 0, distinct = 0;
        for (int right = 0; right < n; right++) {
            freq[arr[right]]++;
            if (freq[arr[right]] == 1)
                distinct++;
            while (distinct > k) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0)
                    distinct--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        StringBuilder output = new StringBuilder();
        output.append(maxLen);
        System.out.println(output);

    }
}