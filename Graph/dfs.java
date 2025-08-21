import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class dfs {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");

        int vertices = Integer.parseInt(line[0]);
        int edges = Integer.parseInt(line[1]);

        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            String[] edge = br.readLine().split(" ");
            int src = Integer.parseInt(edge[0]);
            int dst = Integer.parseInt(edge[1]);

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        visited = new boolean[vertices + 1];

        // dfs_Rec(1);
        dfs_Iterative(1);
    }

    static void dfs_Rec(int node) {
        visited[node] = true;
        StringBuilder result = new StringBuilder();
        dfs_Rec_Helper(node, result);
        System.out.print(result.toString().trim());
    }

    static void dfs_Rec_Helper(int node, StringBuilder result) {
        visited[node] = true;
        result.append(node).append(" ");

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs_Rec_Helper(neighbour, result);
            }
        }
    }

    static void dfs_Iterative(int node) {
        StringBuilder result = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(node);
        visited[node] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            result.append(curr).append(" ");

            for (int neighbor : adjList.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        System.out.print(result.toString().trim());
    }
}