import java.io.*;
import java.util.*;

public class AdjacencyLinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] firstline = new int[M];
        int[] secondline = new int[M];
        int[] thirdline = new int[M];

        String[] first = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            firstline[i] = Integer.parseInt(first[i]);
        }

        String[] second = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            secondline[i] = Integer.parseInt(second[i]);
        }

        String[] third = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            thirdline[i] = Integer.parseInt(third[i]);
        }
        LinkedList<int[]>[] adj = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            adj[firstline[i]].add(new int[]{firstline[i], secondline[i]});
        }

        for (int i = 1; i <= N; i++) {
            pw.print(i + ":");
            for (int[] edge : adj[i]) {
                pw.print(" (" + edge[0] + "," + edge[1] + ")");
            }
            pw.println();
        }

        pw.flush();
    }
}
