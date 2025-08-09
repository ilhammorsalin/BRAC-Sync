import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        HashSet<String> knightPositions = new HashSet<>();
        int[] knightX = new int[K];
        int[] knightY = new int[K];

        for (int i = 0; i < K; i++) {
            String[] position = br.readLine().split(" ");
            knightX[i] = Integer.parseInt(position[0]);
            knightY[i] = Integer.parseInt(position[1]);
            knightPositions.add(knightX[i] + "," + knightY[i]);
        }

        int[] validX = { -2, -2, -1, -1, 1, 1, 2, 2 };
        int[] validY = { -1, 1, -2, 2, -2, 2, -1, 1 };

        boolean attacking = false;

        for (int i = 0; i < K && !attacking; i++) {
            int x1 = knightX[i];
            int y1 = knightY[i];

            for (int k = 0; k < 8; k++) {
                int newX = x1 + validX[k];
                int newY = y1 + validY[k];
                if (newX >= 1 && newX <= N && newY >= 1 && newY <= M) {
                    String targetPosition = newX + "," + newY;
                    if (knightPositions.contains(targetPosition)) {
                        attacking = true;
                        break;
                    }
                }
            }
        }

        if (attacking) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
