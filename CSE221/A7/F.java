import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        long[][] dist = new long[N + 1][2];
        for (int i = 0; i <= N; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[S][0] = 0;
        pq.add(new long[] { 0, S });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long curDist = curr[0];
            int curNode = (int) curr[1];

            if (curDist > dist[curNode][1])
                continue;

            for (int[] edge : graph.get(curNode)) {
                int neighbor = edge[0];
                int weight = edge[1];
                long newDist = curDist + weight;

                if (newDist < dist[neighbor][0]) {

                    dist[neighbor][1] = dist[neighbor][0];
                    dist[neighbor][0] = newDist;
                    pq.add(new long[] { newDist, neighbor });
                } else if (newDist < dist[neighbor][1] && newDist > dist[neighbor][0]) {

                    dist[neighbor][1] = newDist;
                    pq.add(new long[] { newDist, neighbor });
                }
            }
        }

        if (dist[D][1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[D][1]);
        }
    }
}