public class countSort {

    public static void countingSort(int[] arr) {
        if (arr.length == 0)
            return;

        // Find the maximum and minimum values in the array
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        // Create count array with range [min, max]
        int range = max - min + 1;
        int[] count = new int[range];

        // Count occurrences of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        // Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 8, 3, 3, 1 };

        System.out.println("Original array:");
        printArray(arr);

        countingSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
