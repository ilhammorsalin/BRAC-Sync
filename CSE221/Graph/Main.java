import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);
        LinkedList<Integer>[] graph = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (gcd(i, j) == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        for (int q = 0; q < Q; q++) {
            String[] line = br.readLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);

            if (K > graph[X].size()) {
                out.println(-1);
            } else {
                out.println(graph[X].get(K - 1));
            }
        }

        out.flush();
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
