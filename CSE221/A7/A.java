import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            u[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            v[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            w[i] = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            graph.get(u[i]).add(new int[] { v[i], w[i] });
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[S] = 0;

        pq.add(new long[] { 0, S }); 

        while (!pq.isEmpty()) {
            long curr[] = pq.poll();

            long curDist = curr[0]; 
            int curNode = (int) curr[1]; 

            if (curDist > dist[curNode])
                continue;

            for (int[] edge : graph.get(curNode)) {
                int neighbor = edge[0];
                int neighborWeight = edge[1];
                long newDist = neighborWeight + dist[curNode];

                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    parent[neighbor] = curNode;
                    pq.add(new long[] { newDist, neighbor }); 
                }
            }
        }

        if (dist[D] == Long.MAX_VALUE) {
            System.out.println("-1");
        }

        else {
            System.out.println(dist[D]);

            ArrayList<Integer> path = new ArrayList<>();
            int current = D;
            while (current != -1) {
                path.add(current);
                current = parent[current];
            }
            Collections.reverse(path);

            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }

    }
}