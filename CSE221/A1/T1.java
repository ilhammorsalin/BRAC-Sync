import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(br.readLine());
                arr[i] = x;
            }

            for (int i = 0; i < n; i++) {
                if(arr[i] % 2 == 0){
                    System.out.println(arr[i] + " is an Even number.");
                }
                else{
                    System.out.println(arr[i] + " is an Odd number.");

                }
            }

            

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}
