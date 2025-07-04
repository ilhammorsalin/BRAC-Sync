import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class exp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");

            long s1 = System.currentTimeMillis();
            int x = Integer.parseInt(br.readLine());
            long e1 = System.currentTimeMillis();

            System.out.println("You entered: " + x);
            System.out.println("Time taken for input and parsing: " + (e1 - s1) + " milliseconds");

            System.out.print("Enter an integer: ");

            long s2 = System.currentTimeMillis();
            int y = Integer.parseInt(sc.nextLine());
            long e2 = System.currentTimeMillis();

            System.out.println("You entered: " + y);
            System.out.println("Time taken for input and parsing: " + (e2 - s2) + " milliseconds");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}