import java.io.*;
public class AdjacencyMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] a = new int[N + 1][N + 1];
        for(int i=0;i<M;i++){
            String [] st=br.readLine().split(" ");
            int u=Integer.parseInt(st[0]);
            int v=Integer.parseInt(st[1]);
            int w=Integer.parseInt(st[2]);
            a[u][v]=w;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                pw.print(a[i][j] + " ");
            }
            pw.println();
        }

        pw.flush();
    }
}
