public class Heap {

    int capacity = 0;
    static int lastEmptyIdx;
    static int[] heap;


    public void heapify(int parentIdx) { // top to bottom AKA SINK
        int greater = parentIdx; // will perform
        int l = 2 * parentIdx + 1;
        int r = 2 * parentIdx + 2;

        if (l < lastEmptyIdx && heap[greater] < heap[l]) {
            greater = l;
        }
        if (r < lastEmptyIdx && heap[greater] < heap[r]) {
            greater = r;
        }
        if (greater != parentIdx) {
            swap(heap, greater, parentIdx);
            heapify(greater);
        }
    }

    public void swim(int childIdx) {
        int parentIdx = parent(childIdx);

        while (childIdx > 0 && heap[parentIdx] < heap[childIdx]) {
            swap(heap, parentIdx, childIdx);
            childIdx = parentIdx;
            parentIdx = parent(childIdx);
        }
    }

    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        lastEmptyIdx = 0;
    }

    public void insert(int num) {
        if (lastEmptyIdx == capacity) {
            System.out.println("Heap full");
            return;
        }

        heap[lastEmptyIdx] = num;
        swim(lastEmptyIdx);
        lastEmptyIdx++;
    }

    public int delete() {
        if (lastEmptyIdx == 0) {
            System.out.println("Heap is empty");
        }
        int max = heap[0];
        swap(heap, 0, lastEmptyIdx - 1);
        lastEmptyIdx--;
        heapify(0);
        return max;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapSort() {
        int originalSize = lastEmptyIdx;
        for (int i = lastEmptyIdx - 1; i > 0; i--) {
            delete();
        }
        lastEmptyIdx = originalSize;
    }

    public void buildMaxHeap() { // re arramges the heap as max heao
        int n = heap.length;

        // Start from last non-leaf node and move upwards
        for (int lastNLNode = (n / 2) - 1; lastNLNode >= 0; lastNLNode--) { // last non leaf node to
                                                                            // root
            heapify(lastNLNode);
        }
    }

    public void printHeap() {
        for (int i = 0; i < lastEmptyIdx - 1; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.print(heap[lastEmptyIdx - 1]);
        System.out.println();
    }

    public void visualizeHeap() {
        HeapPrinter.printHeap(heap, lastEmptyIdx);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 6, 5};
        Heap heap = new Heap(arr.length);

        System.out.println("Inserting elements into heap:");
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
            // System.out.println("\nAfter inserting " + arr[i] + ":");
            heap.visualizeHeap();
        }

        System.out.println("\nFinal Max Heap:");
        heap.visualizeHeap();

        System.out.println("Heap sort");
        heap.heapSort();
        heap.visualizeHeap();

    }

}


class HNode {
    int elem;
    HNode left, right;

    HNode(int elem) {
        this.elem = elem;
        left = right = null;
    }
}
