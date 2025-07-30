package Sorting;

public class ternarySearch {
    /**
     * Performs a ternary search on a sorted array of long values.
     * This implementation is efficient for large datasets.
     *
     * Time Complexity: O(log3(n)), where n is the number of elements. It's efficient for a large count of items.
     * Space Complexity: O(1), as it uses an iterative approach which is highly memory-efficient.
     *
     * @param arr The sorted array of long integers. Using 'long' handles large values.
     * @param key The long value to search for.
     * @return The index of the element if found, otherwise -1.
     */
    static int search(long[] arr, long key) {
        int l = 0;
        int r = arr.length - 1;

        while (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;

            if (arr[mid1] == key) {
                return mid1;
            }
            if (arr[mid2] == key) {
                return mid2;
            }

            if (key < arr[mid1]) {
                // The key lies in the first third of the array.
                r = mid1 - 1;
            } else if (key > arr[mid2]) {
                // The key lies in the last third of the array.
                l = mid2 + 1;
            } else {
                // The key lies in the middle third of the array.
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        // Example with a large array and large values
        long[] largeArr = new long[1000000];
        for (int i = 0; i < largeArr.length; i++) {
            largeArr[i] = i * 1000L; // Populate with large, distinct values
        }
        long largeKey = 750000000L;
        
        System.out.println("Searching in a large dataset...");
        int resultLarge = search(largeArr, largeKey);
        if (resultLarge == -1) {
            System.out.println("Element " + largeKey + " not present in the large array.");
        } else {
            System.out.println("Element " + largeKey + " found at index " + resultLarge + " in the large array.");
        }

        // Original example for verification
        System.out.println("\nSearching in a small dataset...");
        long[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        long key = 5;
        int result = search(arr, key);
        if (result == -1) {
            System.out.println("Element " + key + " not present.");
        } else {
            System.out.println("Element " + key + " found at index " + result);
        }
    }
}
