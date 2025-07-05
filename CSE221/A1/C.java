import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            long arr[] = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(br.readLine());
            }

            for (int i = 0; i < n; i++) {
                System.out.println((arr[i] * (arr[i] + 1) / 2));
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}
