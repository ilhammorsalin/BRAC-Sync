import java.util.Arrays;

public class Array2D {

    public static void shiftNegative(int a1[]) {

        int count = 0;
        for (int i = a1.length - 1; i >= 0; i--) {
            if (a1[i] < 0) {
                for (int j = i; j < a1.length - count - 1; j++) {
                    int temp = a1[j];
                    a1[j] = a1[j + 1];
                    a1[j + 1] = temp;
                }
                count++;
            }
        }

        System.out.println(Arrays.toString(a1));
    }

    public static void union(int a1[], int b1[]) {
        int b1Clone[] = b1.clone();
        

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < b1Clone.length; j++) {
                if (a1[i] == b1Clone[j]) {
                    b1Clone[j] = 0;
                }
            }
        }

        int count = a1.length;

        for (int x : b1Clone) {
            if (x != 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void Zig(String[][] s) {

        for (int i = 0; i < s.length; i++) {
            int x = i, y = 0;

            while (y <= i) {
                System.out.print(s[x][y] + " ");
                x--;
                y++;
            }
        }

        System.out.println();

        for (int i = 0; i < s.length - 1; i++) { // 0 -> 2 (3times)
            int x = s.length - 1, y = i + 1;

            while (x >= i + 1) {
                System.out.print(s[x][y] + " ");
                x--;
                y++;
            }
        }
    }

    public static int[][] rotate(int[][] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {

            int temp = arr[i][0];
            arr[i][0] = arr[0][len - i - 1];
            arr[0][len - i - 1] = arr[len - i - 1][len - i - 1];
            arr[len - i - 1][len - i - 1] = arr[len - i - 1][0];
            arr[len - i - 1][0] = temp;
        }
        return arr;
    }

    public static int[][] compress_matrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // The new compressed matrix will have half the number of rows and columns
        int[][] compressed = new int[rows / 2][cols / 2];

        // Iterate over the original matrix in 2x2 blocks
        for (int i = 0; i < rows; i += 2) {
            for (int j = 0; j < cols; j += 2) {
                // Sum the 2x2 block
                    compressed[i / 2][j / 2] = mat[i][j] + mat[i][j + 1] + mat[i + 1][j] + mat[i + 1][j + 1];
            }
        }

        return compressed;
        

    }
}


