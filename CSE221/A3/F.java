import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        StringBuilder sb = new StringBuilder();
        printMid(arr, 0, n - 1, sb);
        System.out.println(sb.toString().trim());
    }

    public static void printMid(int[] arr, int l, int r, StringBuilder sb) {
        if (l > r)
            return;
        int mid = (l + r) / 2;
        sb.append(arr[mid]).append(" ");
        printMid(arr, l, mid - 1, sb);
        printMid(arr, mid + 1, r, sb);
    }
}