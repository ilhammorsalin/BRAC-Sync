import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

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
        }

        long[] distFromS = dijkstra(graph, S, N);
        long[] distFromT = dijkstra(graph, T, N);

        long minTime = Long.MAX_VALUE;
        int meetingNode = -1;

        for (int i = 1; i <= N; i++) {
            if (distFromS[i] != Long.MAX_VALUE && distFromT[i] != Long.MAX_VALUE) {
                long meetTime = Math.max(distFromS[i], distFromT[i]);
                if (meetTime < minTime || (meetTime == minTime && i < meetingNode)) {
                    minTime = meetTime;
                    meetingNode = i;
                }
            }
        }

        if (meetingNode == -1) {
            System.out.println(-1);
        } else {
            System.out.println(minTime + " " + meetingNode);
        }
    }

    static long[] dijkstra(ArrayList<ArrayList<int[]>> graph, int start, int N) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[start] = 0;
        pq.add(new long[] { 0, start });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long curDist = curr[0];
            int curNode = (int) curr[1];

            if (curDist > dist[curNode])
                continue;

            for (int[] edge : graph.get(curNode)) {
                int neighbor = edge[0];
                int weight = edge[1];
                long newDist = dist[curNode] + weight;

                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.add(new long[] { newDist, neighbor });
                }
            }
        }

        return dist;
    }
}