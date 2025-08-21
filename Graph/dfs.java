import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class dfs {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>()); // feeding the adjacency list with empty lists
        }

        for (int i = 0; i < edges; i++) {
            // st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        visited = new boolean[vertices + 1];

        // dfs_Rec(1);
        dfs_Iterative(1);

    }

    static void dfs_Rec(int node) {
        visited[node] = true;
        System.out.println(node + " ");

        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs_Rec(neighbour);
            }
        }
    }

    static void dfs_Iterative(int node) {

        //create stack and init by stack push
        //
        
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!visited[curr]) {
                System.out.println(curr + "");
                visited[curr] = true;
            }

            for (int neighbor : adjList.get(curr)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
