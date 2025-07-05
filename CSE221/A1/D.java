import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int N = Integer.parseInt(br.readLine());
                String[] str = br.readLine().split(" ");

                boolean isSorted = true;

                for (int j = 1; j < N; j++) {
                    if (Integer.parseInt(str[j]) < Integer.parseInt(str[j - 1])) {
                        isSorted = false;
                        break;
                    }
                }

                if (isSorted) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}