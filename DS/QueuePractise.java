import java.util.*;;

public class QueuePractise {
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) { // queue to stack
            stack.push(q.remove());
        }

        while (!stack.isEmpty()) { // stack to queue
            q.add(stack.pop());
        }

        System.out.print(q);
    }

    public static void reverse_first_k_elements(Queue<Integer> q, int k) {
        if (k <= 0 || k > q.size())
            return;
            
        Stack<Integer> st = new Stack<>();
        
        // Push first k elements into stack
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }
        
        // Pop from stack and enqueue to get reversed first k elements
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        
        // Move the remaining elements to the end
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }
    }
}
