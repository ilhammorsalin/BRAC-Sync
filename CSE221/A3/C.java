import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        long a = Long.parseLong(str[0]);
        long b = Long.parseLong(str[1]);
        long mod = 107;

        String bin = Long.toBinaryString(b);
        long result = 1;

        for (int i = 0; i < bin.length(); i++) {
            result = (result * result) % mod;
            if (bin.charAt(i) == '1') {
                result = (result * a) % mod;
            }
        }
        System.out.println(result);
    }
}