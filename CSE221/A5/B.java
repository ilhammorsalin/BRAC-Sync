import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class B {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        String[] u_line = br.readLine().split(" ");
        String[] v_line = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            int u = Integer.parseInt(u_line[i]);
            int v = Integer.parseInt(v_line[i]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        visited = new boolean[N + 1];
        dfs(1);
        System.out.println();
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");

                int size = adjList.get(vertex).size();

                for (int i = size - 1; i >= 0; i--) {

                    int neighbor = adjList.get(vertex).get(i);

                    if (!visited[neighbor]) {

                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}