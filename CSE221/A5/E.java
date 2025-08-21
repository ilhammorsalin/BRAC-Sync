import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class E {
    static ArrayList<ArrayList<Integer>> adjList;
    static int[] subtreeSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int R = Integer.parseInt(line[1]);

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(R);

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            int X = Integer.parseInt(br.readLine());
            System.out.println(subtreeSize[X]);
        }
    }

    static int dfs(int node) {
        visited[node] = true;
        subtreeSize[node] = 1;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                subtreeSize[node] += dfs(neighbor);
            }
        }

        return subtreeSize[node];
    }
}