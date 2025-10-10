import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[S] = weights[S];
        pq.add(new long[] { weights[S], S });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long curDist = curr[0];
            int curNode = (int) curr[1];

            if (curDist > dist[curNode])
                continue;

            for (int neighbor : graph.get(curNode)) {
                long newDist = dist[curNode] + weights[neighbor];

                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.add(new long[] { newDist, neighbor });
                }
            }
        }

        if (dist[D] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[D]);
        }
    }
}