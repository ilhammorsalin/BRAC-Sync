import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int s = Integer.parseInt(line[2]);
        int q = Integer.parseInt(line[3]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        String[] sourceLine = br.readLine().split(" ");
        int[] sources = new int[s];
        for (int i = 0; i < s; i++) {
            sources[i] = Integer.parseInt(sourceLine[i]);
        }

        String[] destLine = br.readLine().split(" ");
        int[] destinations = new int[q];
        for (int i = 0; i < q; i++) {
            destinations[i] = Integer.parseInt(destLine[i]);
        }

        int[] dist = multiBFS(adj, sources, n);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int dest = destinations[i];
            if (dist[dest] == -1) {
                result.append(-1);
            } else {
                result.append(dist[dest]);
            }
            if (i < q - 1)
                result.append(" ");
        }
        System.out.println(result.toString());
    }

    static int[] multiBFS(ArrayList<ArrayList<Integer>> adj, int[] sources, int n) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
        }

        for (int source : sources) {
            dist[source] = 0;
            visited[source] = true;
            q.offer(source);
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }

        return dist;
    }
}
