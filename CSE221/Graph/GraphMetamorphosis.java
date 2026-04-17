import java.io.*;
import java.util.*;
public class GraphMetamorphosis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] base = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            for (int j = 1; j <= k; j++) {
                int adjacent = Integer.parseInt(input[j]);
                base[i][adjacent] = 1; }
        }
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pw.print(base[i][j] + " ");}
            pw.println();
        }
        pw.flush();}
}
