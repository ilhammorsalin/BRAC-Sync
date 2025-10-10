import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class D {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] dist;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 1: Find the farthest node from node 1
        int farthest1 = bfs(1);

        // Step 2: Find the farthest node from farthest1
        int farthest2 = bfs(farthest1);

        // The diameter is the distance between farthest1 and farthest2
        System.out.println(dist[farthest2]);
        System.out.println(farthest1 + " " + farthest2);
    }

    static int bfs(int start) {
        dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;
        dist[start] = 0;

        int farthestNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.offer(v);

                    if (dist[v] > maxDist) {
                        maxDist = dist[v];
                        farthestNode = v;
                    }
                }
            }
        }

        return farthestNode;
    }
}