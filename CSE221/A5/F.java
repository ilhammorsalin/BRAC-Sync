import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class F {
    static ArrayList<ArrayList<Integer>> adjList;
    static int[] color;
    static boolean hasCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList.get(u).add(v);
        }

        color = new int[N + 1];
        hasCycle = false;

        for (int i = 1; i <= N; i++) {
            if (color[i] == 0) {
                dfs(i);
                if (hasCycle) {
                    break;
                }
            }
        }

        if (hasCycle) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void dfs(int node) {
        color[node] = 1;

        for (int neighbor : adjList.get(node)) {
            if (color[neighbor] == 1) {
                hasCycle = true;
                return;
            }
            if (color[neighbor] == 0) {
                dfs(neighbor);
                if (hasCycle) {
                    return;
                }
            }
        }

        color[node] = 2;
    }
}