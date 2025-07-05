import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
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
                System.out.println(arr[0]);
                return;
            }

            boolean changed = true;

            while (changed) {
                changed = false;
                for (int i = 0; i < n - 1; i++) {
                    if ((arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) || (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0)) {
                        if (arr[i] > arr[i + 1]) {
                            int temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;
                            changed = true;
                        }
                    }

                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}
