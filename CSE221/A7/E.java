import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            graph.get(u[i]).add(new int[] { v[i], w[i] });
        }

        long[][] dist = new long[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[1][0] = 0;
        dist[1][1] = 0;
        pq.add(new long[] { 0, 1, 0 });
        pq.add(new long[] { 0, 1, 1 });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long curDist = curr[0];
            int curNode = (int) curr[1];
            int lastParity = (int) curr[2];

            if (curDist > dist[curNode][lastParity])
                continue;

            for (int[] edge : graph.get(curNode)) {
                int neighbor = edge[0];
                int weight = edge[1];
                int edgeParity = weight % 2;

                // Can only take this edge if it has different parity than last edge
                if (edgeParity != lastParity) {
                    long newDist = dist[curNode][lastParity] + weight;

                    if (newDist < dist[neighbor][edgeParity]) {
                        dist[neighbor][edgeParity] = newDist;
                        pq.add(new long[] { newDist, neighbor, edgeParity });
                    }
                }
            }
        }

        long result = Math.min(dist[N][0], dist[N][1]);
        if (result == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}