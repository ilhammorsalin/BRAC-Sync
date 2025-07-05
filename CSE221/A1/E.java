import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String str[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            if (n == 1) {
                System.out.println("YES");
                return;
            }
            if (n == 2) {
                if (arr[0] <= arr[1]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                return;
            }

            boolean changed = true;
            while (changed) {
                changed = false;

                for (int i = 0; i < n - 2; i++) {

                    if (arr[i] > arr[i + 2]) {

                        int temp = arr[i];
                        arr[i] = arr[i + 2];
                        arr[i + 2] = temp;
                        changed = true;
                    }
                }
            }

            boolean isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}
