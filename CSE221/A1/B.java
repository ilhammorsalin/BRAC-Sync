import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            String arr[][] = new String[n][4];
            for (int i = 0; i < n; i++) {
                String li = br.readLine();
                String sub[] = li.split(" ");
                arr[i] = sub;
            }

            for (int i = 0; i < n; i++) {
                double num1 = Integer.parseInt(arr[i][1]);
                double num2 = Integer.parseInt(arr[i][3]);
                String op = arr[i][2];

                if (op.equals("+")) {
                    System.out.printf("%.6f%n", num1 + num2);
                }
                if (op.equals("-")) {
                    System.out.printf("%.6f%n", num1 - num2);
                }
                if (op.equals("*")) {
                    System.out.printf("%.6f%n", num1 * num2);
                }
                if (op.equals("/")) {
                    if (num2 != 0) {
                        System.out.printf("%.6f%n", num1 / num2);
                    } else {
                        System.out.println("Error: Division by zero.");
                    }
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}
