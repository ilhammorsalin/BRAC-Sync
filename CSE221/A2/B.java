import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int K = Integer.parseInt(firstLine[2]);

        String[] secondLine = br.readLine().split(" ");
        String[] thirdLine = br.readLine().split(" ");
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(secondLine[i]);
        }
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(thirdLine[i]);
        }

        boolean found = false;
        int left = 0;
        int right = M - 1;
        int max = Integer.MAX_VALUE;
        int idxL = 0;
        int idxR = 0;

        while (left < N && right >= 0) {
            int sum = arr1[left] + arr2[right];

            if (Math.abs(K - sum) < max) {
                max = Math.abs(K - sum);
                idxL = left;
                idxR = right;
            }

            if (sum == K) {
                found = true;
                break;
            }

            else if (sum < K) {
                left++;

            }

            else if (sum > K) {
                right--;
            }

        }

        if (found) {
            System.out.println(++left + " " + ++right);

        } else {
            System.out.println(++idxL + " " + ++idxR);

        }
    }
}