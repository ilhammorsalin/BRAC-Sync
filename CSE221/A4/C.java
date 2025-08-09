import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Edges = Integer.parseInt(br.readLine());
        int[][] adjMatrix = new int[Edges][Edges];

        for (int i = 0; i < Edges; i++) {
            String[] line = br.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            for (int j = 1; j <= k; j++) {
                int v = Integer.parseInt(line[j]);
                adjMatrix[i][v] = 1;
            }
        }

        for (int i = 0; i < Edges; i++) {
            for (int j = 0; j < Edges; j++) {
                System.out.print(adjMatrix[i][j]);
                if (j < Edges - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
