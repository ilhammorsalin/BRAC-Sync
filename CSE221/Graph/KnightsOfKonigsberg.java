import java.io.*;
public class KnightsOfKonigsberg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        boolean[][] board = new boolean[N + 1][M + 1];

        int[] knightsX = new int[K];
        int[] knightsY = new int[K];

        for (int i = 0; i < K; i++) {
           String[] input=br.readLine().split(" ");
           knightsX[i]=Integer.parseInt(input[0]);
           knightsY[i]=Integer.parseInt(input[1]);
           board[knightsX[i]][knightsY[i]]=true;
        }
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean canAttack = false;

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < dx.length; j++) {
                int nx = knightsX[i] + dx[j];
                int ny = knightsY[i] + dy[j];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (board[nx][ny]) {
                        canAttack = true;
                        break;
                    }
                }
            }
            if (canAttack) {
                break;
            }
        }

        if (canAttack) {
            pw.println("YES");}
            else{
                pw.println("NO");
            }

            pw.flush();
        }
    }

