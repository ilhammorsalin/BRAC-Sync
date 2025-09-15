import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            color[i] = -1;
        }

        int maxGroup = 0;

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                int group0 = 0;
                int group1 = 0;

                Queue<Integer> q = new LinkedList<>();
                color[i] = 0;
                q.offer(i);
                group0++;

                while (!q.isEmpty()) {
                    int u = q.poll();

                    for (int v : adj.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];

                            q.offer(v);

                            if (color[v] == 0) {
                                group0++;
                            } else {
                                group1++;
                            }
                        }
                    }
                }

                maxGroup += Math.max(group0, group1);
            }
        }

        System.out.println(maxGroup);
    }
}
