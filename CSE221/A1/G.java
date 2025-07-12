import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(br.readLine());

            String strID[] = br.readLine().split(" ");
            String strMarks[] = br.readLine().split(" ");

            int ID[] = new int[strID.length];
            int marks[] = new int[strMarks.length];

            for (int i = 0; i < n; i++) {
                ID[i] = Integer.parseInt(strID[i]);
                marks[i] = Integer.parseInt(strMarks[i]);
            }

            int swapCount = 0;
            for (int i = 0; i < n - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (marks[j] > marks[maxIndex]) {
                        maxIndex = j;
                    } else if (marks[j] == marks[maxIndex] && ID[j] < ID[maxIndex]) {
                        maxIndex = j;
                    }
                }

                if (maxIndex != i) {

                    int tempMark = marks[i];
                    marks[i] = marks[maxIndex];
                    marks[maxIndex] = tempMark;

                    int tempID = ID[i];
                    ID[i] = ID[maxIndex];
                    ID[maxIndex] = tempID;

                    swapCount++;
                }
            }

            System.out.println("Minimum swaps: " + swapCount);
            for (int i = 0; i < n; i++) {
                System.out.println("ID: " + ID[i] + " Mark: " + marks[i]);
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid integer.");
        } finally {
            br.close();
        }
    }
}
