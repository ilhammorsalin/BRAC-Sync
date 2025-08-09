import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);

        int[] validX = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] validY = { -1, 0, 1, -1, 1, -1, 0, 1 };

        ArrayList<int[]> validMoves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int newX = x + validX[i];
            int newY = y + validY[i];
            if (newX >= 1 && newX <= N && newY >= 1 && newY <= N) {
                int[] valid = new int[] { newX, newY };
                validMoves.add(valid);
            }
        }

        System.out.println(validMoves.size());
        for (int i = 0; i < validMoves.size(); i++) {
            System.out.println(validMoves.get(i)[0] + " " + validMoves.get(i)[1]);
        }
    }
}
