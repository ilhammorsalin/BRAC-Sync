import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int target = Integer.parseInt(str[1]);

        String line[] = br.readLine().split(" ");
        int num[] = new int[line.length];

        for (int j = 0; j < line.length; j++) {
            num[j] = Integer.parseInt(line[j]);
        }

        boolean found = false;

        int left = 0, right = line.length - 1;

        while (left < right) {
            int sum = num[left] + num[right];
            if (target == sum) {
                found = true;
                break;
            }

            else if (sum < target) {
                left++;
            }

            else if (sum > target) {
                right--;
            }
        }

        if (found) {
            System.out.println(++left + " " + ++right);
        } else {
            System.out.println("-1");
        }

    }
}