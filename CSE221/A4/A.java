package CSE221.A4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int vertices = Integer.parseInt(firstLine[0]);
        int edges = Integer.parseInt(firstLine[1]);

        int[][] graph = new int[vertices][vertices];

        for (int i = 0; i < edges; i++) {
            String[] line = br.readLine().split(" ");
            int e1 = Integer.parseInt(line[0]);
            int e2 = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);

            graph[e1 - 1][e2 - 1] = weight;
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j]);
                if (j < vertices - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}