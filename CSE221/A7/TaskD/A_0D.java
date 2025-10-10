public class A_0D {

//AAQ

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// public class A {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         StringBuilder sb = new StringBuilder();

//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int S = Integer.parseInt(st.nextToken());
//         int D = Integer.parseInt(st.nextToken());

//         int[] u = new int[M];
//         int[] v = new int[M];
//         int[] w = new int[M];

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < M; i++)
//             u[i] = Integer.parseInt(st.nextToken());

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < M; i++)
//             v[i] = Integer.parseInt(st.nextToken());

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < M; i++)
//             w[i] = Integer.parseInt(st.nextToken());

//         ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
//         for (int i = 0; i <= N; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int i = 0; i < M; i++) {
//             graph.get(u[i]).add(new int[] { v[i], w[i] });
//         }

//         long[] dist = new long[N + 1];
//         Arrays.fill(dist, Long.MAX_VALUE);
//         int[] parent = new int[N + 1];
//         Arrays.fill(parent, -1);

//         PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
//         dist[S] = 0;

//         pq.add(new long[] { 0, S });

//         while (!pq.isEmpty()) {
//             long curr[] = pq.poll();

//             long curDist = curr[0];
//             int curNode = (int) curr[1];

//             if (curDist > dist[curNode])
//                 continue;

//             for (int[] edge : graph.get(curNode)) {
//                 int neighbor = edge[0];
//                 int neighborWeight = edge[1];
//                 long newDist = neighborWeight + dist[curNode];

//                 if (newDist < dist[neighbor]) {
//                     dist[neighbor] = newDist;
//                     parent[neighbor] = curNode;
//                     pq.add(new long[] { newDist, neighbor });
//                 }
//             }
//         }

//         if (dist[D] == Long.MAX_VALUE) {
//             System.out.println("-1");
//         }

//         else {
//             System.out.println(dist[D]);

//             ArrayList<Integer> path = new ArrayList<>();
//             int current = D;
//             while (current != -1) {
//                 path.add(current);
//                 current = parent[current];
//             }
//             Collections.reverse(path);

//             for (int i = 0; i < path.size(); i++) {
//                 System.out.print(path.get(i));
//                 if (i < path.size() - 1)
//                     System.out.print(" ");
//             }
//             System.out.println();
//         }

//     }
// }

//BBQ

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// public class B {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int S = Integer.parseInt(st.nextToken());
//         int T = Integer.parseInt(st.nextToken());

//         ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
//         for (int i = 0; i <= N; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(br.readLine());
//             int u = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//             int w = Integer.parseInt(st.nextToken());
//             graph.get(u).add(new int[] { v, w });
//         }

//         long[] distFromS = dijkstra(graph, S, N);
//         long[] distFromT = dijkstra(graph, T, N);

//         long minTime = Long.MAX_VALUE;
//         int meetingNode = -1;

//         for (int i = 1; i <= N; i++) {
//             if (distFromS[i] != Long.MAX_VALUE && distFromT[i] != Long.MAX_VALUE) {
//                 long meetTime = Math.max(distFromS[i], distFromT[i]);
//                 if (meetTime < minTime || (meetTime == minTime && i < meetingNode)) {
//                     minTime = meetTime;
//                     meetingNode = i;
//                 }
//             }
//         }

//         if (meetingNode == -1) {
//             System.out.println(-1);
//         } else {
//             System.out.println(minTime + " " + meetingNode);
//         }
//     }

//     static long[] dijkstra(ArrayList<ArrayList<int[]>> graph, int start, int N) {
//         long[] dist = new long[N + 1];
//         Arrays.fill(dist, Long.MAX_VALUE);

//         PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
//         dist[start] = 0;
//         pq.add(new long[] { 0, start });

//         while (!pq.isEmpty()) {
//             long[] curr = pq.poll();
//             long curDist = curr[0];
//             int curNode = (int) curr[1];

//             if (curDist > dist[curNode])
//                 continue;

//             for (int[] edge : graph.get(curNode)) {
//                 int neighbor = edge[0];
//                 int weight = edge[1];
//                 long newDist = dist[curNode] + weight;

//                 if (newDist < dist[neighbor]) {
//                     dist[neighbor] = newDist;
//                     pq.add(new long[] { newDist, neighbor });
//                 }
//             }
//         }

//         return dist;
//     }
// }

//CCQ

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// public class C {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());

//         ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
//         for (int i = 0; i <= N; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(br.readLine());
//             int u = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//             int w = Integer.parseInt(st.nextToken());

//             // Bi-directional roads
//             graph.get(u).add(new int[] { v, w });
//             graph.get(v).add(new int[] { u, w });
//         }

//         int[] danger = new int[N + 1];
//         Arrays.fill(danger, Integer.MAX_VALUE);

//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
//         danger[1] = 0;
//         pq.add(new int[] { 0, 1 });

//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             int curDanger = curr[0];
//             int curNode = curr[1];

//             if (curDanger > danger[curNode])
//                 continue;

//             for (int[] edge : graph.get(curNode)) {
//                 int neighbor = edge[0];
//                 int weight = edge[1];

//                 int newDanger = Math.max(danger[curNode], weight);

//                 if (newDanger < danger[neighbor]) {
//                     danger[neighbor] = newDanger;
//                     pq.add(new int[] { newDanger, neighbor });
//                 }
//             }
//         }

//         StringBuilder sb = new StringBuilder();
//         for (int i = 1; i <= N; i++) {
//             if (danger[i] == Integer.MAX_VALUE) {
//                 sb.append(-1);
//             } else {
//                 sb.append(danger[i]);
//             }
//             if (i < N)
//                 sb.append(" ");
//         }
//         System.out.println(sb.toString());
//     }
// }

//DDQ

// public class D {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int S = Integer.parseInt(st.nextToken());
//         int D = Integer.parseInt(st.nextToken());

//         int[] weights = new int[N + 1];
//         st = new StringTokenizer(br.readLine());
//         for (int i = 1; i <= N; i++) {
//             weights[i] = Integer.parseInt(st.nextToken());
//         }

//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i <= N; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(br.readLine());
//             int u = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//             graph.get(u).add(v);
//         }

//         long[] dist = new long[N + 1];
//         Arrays.fill(dist, Long.MAX_VALUE);

//         PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
//         dist[S] = weights[S];
//         pq.add(new long[] { weights[S], S });

//         while (!pq.isEmpty()) {
//             long[] curr = pq.poll();
//             long curDist = curr[0];
//             int curNode = (int) curr[1];

//             if (curDist > dist[curNode])
//                 continue;

//             for (int neighbor : graph.get(curNode)) {
//                 long newDist = dist[curNode] + weights[neighbor];

//                 if (newDist < dist[neighbor]) {
//                     dist[neighbor] = newDist;
//                     pq.add(new long[] { newDist, neighbor });
//                 }
//             }
//         }

//         if (dist[D] == Long.MAX_VALUE) {
//             System.out.println(-1);
//         } else {
//             System.out.println(dist[D]);
//         }
//     }
// }

//EEQ

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// public class E {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());

//         int[] u = new int[M];
//         int[] v = new int[M];
//         int[] w = new int[M];

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < M; i++) {
//             u[i] = Integer.parseInt(st.nextToken());
//         }

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < M; i++) {
//             v[i] = Integer.parseInt(st.nextToken());
//         }

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < M; i++) {
//             w[i] = Integer.parseInt(st.nextToken());
//         }

//         ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
//         for (int i = 0; i <= N; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int i = 0; i < M; i++) {
//             graph.get(u[i]).add(new int[] { v[i], w[i] });
//         }

//         long[][] dist = new long[N + 1][2];
//         for (int i = 0; i <= N; i++) {
//             Arrays.fill(dist[i], Long.MAX_VALUE);
//         }

//         PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

//         dist[1][0] = 0;
//         dist[1][1] = 0;
//         pq.add(new long[] { 0, 1, 0 });
//         pq.add(new long[] { 0, 1, 1 });

//         while (!pq.isEmpty()) {
//             long[] curr = pq.poll();
//             long curDist = curr[0];
//             int curNode = (int) curr[1];
//             int lastParity = (int) curr[2];

//             if (curDist > dist[curNode][lastParity])
//                 continue;

//             for (int[] edge : graph.get(curNode)) {
//                 int neighbor = edge[0];
//                 int weight = edge[1];
//                 int edgeParity = weight % 2;

//                 // Can only take this edge if it has different parity than last edge
//                 if (edgeParity != lastParity) {
//                     long newDist = dist[curNode][lastParity] + weight;

//                     if (newDist < dist[neighbor][edgeParity]) {
//                         dist[neighbor][edgeParity] = newDist;
//                         pq.add(new long[] { newDist, neighbor, edgeParity });
//                     }
//                 }
//             }
//         }

//         long result = Math.min(dist[N][0], dist[N][1]);
//         if (result == Long.MAX_VALUE) {
//             System.out.println(-1);
//         } else {
//             System.out.println(result);
//         }
//     }
// }

//FFQ

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// public class F {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int S = Integer.parseInt(st.nextToken());
//         int D = Integer.parseInt(st.nextToken());

//         ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
//         for (int i = 0; i <= N; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int i = 0; i < M; i++) {
//             st = new StringTokenizer(br.readLine());
//             int u = Integer.parseInt(st.nextToken());
//             int v = Integer.parseInt(st.nextToken());
//             int w = Integer.parseInt(st.nextToken());

//             graph.get(u).add(new int[] { v, w });
//             graph.get(v).add(new int[] { u, w });
//         }

//         long[][] dist = new long[N + 1][2];
//         for (int i = 0; i <= N; i++) {
//             dist[i][0] = Long.MAX_VALUE;
//             dist[i][1] = Long.MAX_VALUE;
//         }

//         PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

//         dist[S][0] = 0;
//         pq.add(new long[] { 0, S });

//         while (!pq.isEmpty()) {
//             long[] curr = pq.poll();
//             long curDist = curr[0];
//             int curNode = (int) curr[1];

//             if (curDist > dist[curNode][1])
//                 continue;

//             for (int[] edge : graph.get(curNode)) {
//                 int neighbor = edge[0];
//                 int weight = edge[1];
//                 long newDist = curDist + weight;

//                 if (newDist < dist[neighbor][0]) {

//                     dist[neighbor][1] = dist[neighbor][0];
//                     dist[neighbor][0] = newDist;
//                     pq.add(new long[] { newDist, neighbor });
//                 } else if (newDist < dist[neighbor][1] && newDist > dist[neighbor][0]) {

//                     dist[neighbor][1] = newDist;
//                     pq.add(new long[] { newDist, neighbor });
//                 }
//             }
//         }

//         if (dist[D][1] == Long.MAX_VALUE) {
//             System.out.println(-1);
//         } else {
//             System.out.println(dist[D][1]);
//         }
//     }
// }

}
