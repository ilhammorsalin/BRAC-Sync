package CSE221.A5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int S = Integer.parseInt(line[2]);
        int D = Integer.parseInt(line[3]);

        
        if (S == D) {
            System.out.println(0);
            System.out.println(S);
            return;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
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

        
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList.get(i));
        }

        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        int[] distance = new int[N + 1];

        queue.add(S);
        visited[S] = true;
        parent[S] = -1;
        distance[S] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == D) {
                break;
            }

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        
        if (!visited[D]) {
            System.out.println(-1);
            return;
        }

        
        ArrayList<Integer> path = new ArrayList<>();
        int current = D;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);

       
        System.out.println(distance[D]);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}