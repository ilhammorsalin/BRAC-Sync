import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long MOD = 1000000007L;

        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            long[] arr = new long[str.length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Long.parseLong(str[j]);
            }
            int power = Integer.parseInt(br.readLine());

            long[] result = matPow(arr, power, MOD);

            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] % MOD + " ");
                if (j == 1) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    public static long[] matPow(long[] arr, int a, long MOD) {
        long[] res = {1, 0, 0, 1};
        long[] b = arr.clone();
        while (a > 0) {
            if (a % 2 == 1) {
                res = multiply(res, b, MOD);
            }
            b = multiply(b, b, MOD);
            a /= 2;
        }
        return res;
    }

    public static long[] multiply(long[] a, long[] b, long MOD) {
        long[] product = new long[4];
        product[0] = (a[0] * b[0] + a[1] * b[2]) % MOD;
        product[1] = (a[0] * b[1] + a[1] * b[3]) % MOD;
        product[2] = (a[2] * b[0] + a[3] * b[2]) % MOD;
        product[3] = (a[2] * b[1] + a[3] * b[3]) % MOD;
        return product;
    }
}