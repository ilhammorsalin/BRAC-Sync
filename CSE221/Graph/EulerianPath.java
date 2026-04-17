import java.io.*;
import java.util.*;

public class EulerianPath {
    static int n, m, oddCount;
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
         degree = new int[n + 1];
        String[] uinp = br.readLine().split(" ");
        String[] vinp = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int u = Integer.parseInt(uinp[i]);
            int v = Integer.parseInt(vinp[i]);
            degree[u]++;
            degree[v]++;
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount == 0 || oddCount == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
