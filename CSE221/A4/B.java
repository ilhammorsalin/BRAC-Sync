import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int Vertices = Integer.parseInt(line[0]);
        int Edges = Integer.parseInt(line[1]);

        String[] uStr = br.readLine().split(" ");
        String[] vStr = br.readLine().split(" ");
        String[] wStr = br.readLine().split(" ");

        int[] u = new int[Edges];
        int[] v = new int[Edges];
        int[] w = new int[Edges];

        for (int i = 0; i < Edges; i++) {
            u[i] = Integer.parseInt(uStr[i]);
            v[i] = Integer.parseInt(vStr[i]);
            w[i] = Integer.parseInt(wStr[i]);
        }

        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i <= Vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < Edges; i++) {
            adjList.get(u[i]).add(new int[] { v[i], w[i] });
        }

        for (int i = 1; i <= Vertices; i++) {
            System.out.print(i + ":");
            ArrayList<int[]> edges = adjList.get(i);
            
            for (int j = 0; j < edges.size(); j++) {
                int[] edge = edges.get(j);
                System.out.print(" (" + edge[0] + "," + edge[1] + ")");
            }
            System.out.println();
        }
    }
}