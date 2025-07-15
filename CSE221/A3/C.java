import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        long a = Long.parseLong(str[0]);
        long b = Long.parseLong(str[1]);

        double a_power_b = (double) Math.pow(a, b);

        double div = (double) (a_power_b / 107l);

        div = div - (long) div;

        div = div * 107;

        System.out.println((long) div);

    }

}