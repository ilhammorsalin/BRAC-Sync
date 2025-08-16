import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int Vertices = Integer.parseInt(line[0]);
        int Edges = Integer.parseInt(line[1]);

        int[] indegree = new int[Vertices + 1];
        int[] outdegree = new int[Vertices + 1];

        String[] uStr = br.readLine().split(" ");
        String[] vStr = br.readLine().split(" ");

        
        for (int i = 0; i < Edges; i++) {
            int u = Integer.parseInt(uStr[i]);
            int v = Integer.parseInt(vStr[i]);
            outdegree[u]++; 
            indegree[v]++;
        }

        for (int i = 1; i <= Vertices; i++) {
            int difference = indegree[i] - outdegree[i];
            System.out.print(difference);
            if (i < Vertices)
                System.out.print(" ");
        }
        System.out.println();
    }
}
