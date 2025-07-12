import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String[] parts = br.readLine().split(" ");

            long k_th = Long.parseLong(parts[0]);
            long divisible = Long.parseLong(parts[1]);

            long blocks = (k_th - 1) / (divisible - 1);
            long ans = k_th + blocks;

            output.append(ans).append("\n");
        }

        System.out.print(output);
    }
}