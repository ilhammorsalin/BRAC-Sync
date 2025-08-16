import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int Vertices = Integer.parseInt(line[0]);
        int Edges = Integer.parseInt(line[1]);

        int[] degree = new int[Vertices + 1];

        String[] uStr = br.readLine().split(" ");
        String[] vStr = br.readLine().split(" ");

        for (int i = 0; i < Edges; i++) {
            int u = Integer.parseInt(uStr[i]);
            int v = Integer.parseInt(vStr[i]);
            degree[u]++;
            degree[v]++;
        }

        int oddCount = 0;
        for (int i = 1; i <= Vertices; i++) {
            if (degree[i] % 2 != 0) oddCount++;
        }

        if (oddCount == 0 || oddCount == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}