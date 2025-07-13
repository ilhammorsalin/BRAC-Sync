import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            String[] train = new String[n];
            String[] time = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
                String[] parts = arr[i].split(" ");
                train[i] = parts[0];
                time[i] = parts[6];
            }

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    int cmp = train[j].compareTo(train[minIdx]);
                    if (cmp < 0) {
                        minIdx = j;
                    } else if (cmp == 0) {
                        if (compareTime(time[j], time[minIdx]) > 0) {
                            minIdx = j;
                        }

                    }
                }
                if (minIdx != i) {
                    String tmp = arr[i];
                    arr[i] = arr[minIdx];
                    arr[minIdx] = tmp;

                    tmp = train[i];
                    train[i] = train[minIdx];
                    train[minIdx] = tmp;

                    tmp = time[i];
                    time[i] = time[minIdx];
                    time[minIdx] = tmp;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer for N.");
        } finally {
            br.close();
        }
    }

    
    public static int compareTime(String t1, String t2) {
        String[] p1 = t1.split(":");
        String[] p2 = t2.split(":");

        int h1 = Integer.parseInt(p1[0]);
        int m1 = Integer.parseInt(p1[1]);
        int h2 = Integer.parseInt(p2[0]);
        int m2 = Integer.parseInt(p2[1]);

        if (h1 != h2)
            return h1 - h2;
        return m1 - m2; // if 03:00 - 02:00 > 0 so 03:00 is latest
    }
}