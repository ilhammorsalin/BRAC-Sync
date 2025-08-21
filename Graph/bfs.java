import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        visited = new boolean[vertices + 1];

        // bfs_Iterative(1);
        bfs_Recursive(1);
    }

    static void bfs_Iterative(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neighbor : adjList.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    static void bfs_Recursive(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        bfs_Rec_Helper(queue);
    }

    static void bfs_Rec_Helper(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int curr = queue.poll();
        System.out.print(curr + " ");

        for (int neighbor : adjList.get(curr)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }

        bfs_Rec_Helper(queue);
    }
}