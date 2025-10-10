import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class shortest1toN {
    static ArrayList<ArrayList<int[]>> adj;
    static int[] dist;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < n - 1; i++) {
                String[] edge = br.readLine().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                int w = Integer.parseInt(edge[2]);
                adj.get(u).add(new int[] { v, w });
                adj.get(v).add(new int[] { u, w });
            }

            // Find shortest path from 1 to n using Dijkstra's algorithm
            int result = dijkstra(1, n);
            System.out.println(result);
        }
    }

    static int dijkstra(int start, int target) {
        dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        // Priority queue: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Initialize distances
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        pq.offer(new int[] { 0, start });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int u = current[1];

            if (visited[u])
                continue; // Skip if already processed
            visited[u] = true;

            if (u == target)
                return dist[u]; // Found target

            // Relax all neighbors
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int weight = edge[1];

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] { dist[v], v });
                }
            }
        }

        return dist[target];
    }
}
