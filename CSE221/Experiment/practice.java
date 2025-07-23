public class practice {
    public static void main(String[] args) {
        int n = 4; // example value
        test(n);
    }

    public static void test(int n) {
        if (n < 0) return;
        
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        test(n / 2);
        test(n / 2);
    }
}