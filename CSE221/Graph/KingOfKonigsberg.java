import java.io.*;
public class KingOfKonigsberg {
    static int N, x, y, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        N = Integer.parseInt(br.readLine());
        String[] pos = br.readLine().split(" ");
        x = Integer.parseInt(pos[0]);
        y = Integer.parseInt(pos[1]);

        for (int row = x - 1; row <= x + 1; row++) {
            for (int col = y - 1; col <= y + 1; col++) {
                if (row == x && col == y) {

                    continue;
                }
                if (row >= 1 && row <= N && col >= 1 && col <= N) {
                    count++;
                }
            }
        }
        pw.println(count);
        for (int row = x - 1; row <= x + 1; row++) {
            for (int col = y - 1; col <= y + 1; col++) {
                if (row == x && col == y) {

                    continue;
                }
                if (row >= 1 && row <= N && col >= 1 && col <= N) {
                    pw.println(row + " " + col);
                }
            }

        }
        pw.flush();

    }
}

