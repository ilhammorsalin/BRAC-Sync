package CSE221.A5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int S = Integer.parseInt(line[2]);
        int D = Integer.parseInt(line[3]);
        int K = Integer.parseInt(line[4]);

        if (S == D) {
            if (S == K) {
                System.out.println(0);
                System.out.println(S);
            } else {
                System.out.println(-1);
            }
            return;
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList.get(u).add(v);
        }

        int[] distFromS = bfs(adjList, S, N);
        int[] distFromK = bfs(adjList, K, N);

        if (distFromS[K] == -1 || distFromK[D] == -1) {
            System.out.println(-1);
            return;
        }

        int[] parentS = bfsWithParent(adjList, S, N);
        int[] parentK = bfsWithParent(adjList, K, N);

        ArrayList<Integer> pathStoK = getPath(parentS, S, K);
        ArrayList<Integer> pathKtoD = getPath(parentK, K, D);

        if (pathStoK == null || pathKtoD == null) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> fullPath = new ArrayList<>();
        fullPath.addAll(pathStoK);
        for (int i = 1; i < pathKtoD.size(); i++) {
            fullPath.add(pathKtoD.get(i));
        }

        System.out.println(fullPath.size() - 1);
        for (int i = 0; i < fullPath.size(); i++) {
            System.out.print(fullPath.get(i));
            if (i < fullPath.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static int[] bfs(ArrayList<ArrayList<Integer>> adjList, int start, int N) {
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            distance[i] = -1;
        }

        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distance;
    }

    static int[] bfsWithParent(ArrayList<ArrayList<Integer>> adjList, int start, int N) {
        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            parent[i] = -1;
        }

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        return parent;
    }

    static ArrayList<Integer> getPath(int[] parent, int start, int end) {
        if (parent[end] == -1 && start != end) {
            return null;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int current = end;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);
        return path;
    }
}