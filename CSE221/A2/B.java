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
        int[] bigArray = new int[N+M];

        for (int i = 0; i < N+M; i++) {
            bigArray[i] = Integer.parseInt(secondLine[i]);
            bigArray[i+N] = Integer.parseInt(thirdLine[i]);
        }

        Arrays.sort(bigArray);

        System.out.println(Arrays.toString(bigArray));
        


    }
}