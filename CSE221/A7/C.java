import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // Bi-directional roads
            graph.get(u).add(new int[] { v, w });
            graph.get(v).add(new int[] { u, w });
        }

        int[] danger = new int[N + 1];
        Arrays.fill(danger, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        danger[1] = 0;
        pq.add(new int[] { 0, 1 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int curDanger = curr[0];
            int curNode = curr[1];

            if (curDanger > danger[curNode])
                continue;

            for (int[] edge : graph.get(curNode)) {
                int neighbor = edge[0];
                int weight = edge[1];

                int newDanger = Math.max(danger[curNode], weight);

                if (newDanger < danger[neighbor]) {
                    danger[neighbor] = newDanger;
                    pq.add(new int[] { newDanger, neighbor });
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (danger[i] == Integer.MAX_VALUE) {
                sb.append(-1);
            } else {
                sb.append(danger[i]);
            }
            if (i < N)
                sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}