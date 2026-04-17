import java.io.*;

public class DegreeDiff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        String[] uStr = br.readLine().split(" ");
        String[] vStr = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int u = Integer.parseInt(uStr[i]);
            int v = Integer.parseInt(vStr[i]);

            outdegree[u]++;
            indegree[v]++;
        }
        for (int i = 1; i <= n; i++) {
            pw.print(indegree[i] - outdegree[i]);
            if (i != n) {
                pw.print(" ");
            }
        }
        pw.flush();
    }
}

