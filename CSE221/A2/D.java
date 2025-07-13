import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] aliceInput = br.readLine().split(" ");
        int[] aliceArr = new int[n];
        for (int i = 0; i < n; i++) {
            aliceArr[i] = Integer.parseInt(aliceInput[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] bobInput = br.readLine().split(" ");
        int[] bobArr = new int[m];
        for (int i = 0; i < m; i++) {
            bobArr[i] = Integer.parseInt(bobInput[i]);
        }

        int p1 = 0;
        int p2 = 0;

        StringBuilder mergedArr = new StringBuilder();

        while (p1 < n && p2 < m) {
            if (aliceArr[p1] <= bobArr[p2]) {
                mergedArr.append(aliceArr[p1]).append(" ");
                p1++;
            } else {
                mergedArr.append(bobArr[p2]).append(" ");
                p2++;
            }
        }

        while (p1 < n) {
            mergedArr.append(aliceArr[p1]).append(" ");
            p1++;
        }
        while (p2 < m) {
            mergedArr.append(bobArr[p2]).append(" ");
            p2++;
        }

        System.out.println(mergedArr.toString().trim());
    }
}