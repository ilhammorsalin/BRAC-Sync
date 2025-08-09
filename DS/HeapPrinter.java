import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class HeapNode {
    int elem;
    HeapNode left, right;

    public HeapNode(int elem) {
        this.elem = elem;
        left = right = null;
    }
}

public class HeapPrinter {    public static void printHeap(int[] heap, int size) {
        if (size == 0) {
            System.out.println("Empty heap");
            return;
        }

        HeapNode root = buildHeapTree(heap, 0, size);
        printHeapNode(root);
    }

    private static HeapNode buildHeapTree(int[] heap, int index, int size) {
        if (index >= size) {
            return null;
        }

        HeapNode node = new HeapNode(heap[index]);
        
        int leftIndex = 2 * index + 1;
        if (leftIndex < size) {
            node.left = buildHeapTree(heap, leftIndex, size);
        }
        
        int rightIndex = 2 * index + 2;
        if (rightIndex < size) {
            node.right = buildHeapTree(heap, rightIndex, size);
        }
        
        return node;
    }

    private static void printHeapNode(HeapNode root) {
        int maxLevel = maxLevel(root);

        printHeapNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printHeapNodeInternal(List<HeapNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<HeapNode> newNodes = new ArrayList<>();
        for (HeapNode node : nodes) {
            if (node != null) {
                System.out.print(node.elem);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println("");
        }

        printHeapNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(HeapNode node) {
        if (node == null)
            return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<?> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
