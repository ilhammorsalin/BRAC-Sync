import java.util.*;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class StackPractise {
    public static void print_total_task(int[][] tasks) {
        Stack<int[]> stack = new Stack<>();

        // Iterate through the given tasks
        for (int[] task : tasks) {
            if (!stack.isEmpty() && stack.peek()[1] >= task[0]) {
                // Merge overlapping tasks
                stack.peek()[1] = Math.max(stack.peek()[1], task[1]);
            } else {
                // Push a new non-overlapping task
                stack.push(task);
            }
        }

        // Print tasks in descending order of start time

        while (!stack.isEmpty()) {
            System.out.println(Arrays.toString(stack.peek()));
            stack.pop();
        }

    }

    public static void adjacentSwap(Stack<Integer> st) {
        Stack<Integer> st2 = new Stack<>();

        while (!st.isEmpty()) {
            int t1 = st.pop();
            int t2 = st.pop();

            st2.push(t2);
            st2.push(t1);
        }

        while (!st2.isEmpty()) {
            st.push(st2.pop());
        }
    }

    public static void displayRevRec(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        System.out.print(top + " ");
        displayRevRec(s);
        s.push(top);
    }

    public static void reverseRec(Stack<Integer> s) {
        if (s.isEmpty())
            return;

        int top = s.pop();
        reverseRec(s);

        // Insert at bottom without using helper function
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            int val = s.pop();
            temp.push(val); // Empty original stack into temp stack
        }
        s.push(top); // Push the original top element at bottom since stack is empty
        while (!temp.isEmpty()) {
            int val = temp.pop();
            s.push(val); // Push back all other elements on top of it
        }
    }

    public static void pushAtBottom(Stack<Integer> s, int num) {
        if (s.size() == 0) {
            // when stack empty push the desired num and then run the unended calls from the
            // back
            System.out.print(num + " ");
            s.push(num); // pushed the num - to refill
            return; // as function broken, run the lines from 28
        }
        int top = s.pop(); // stored 1st element in top and popped the 1st element
        pushAtBottom(s, num);// r e c u r s i o n
        // refill
        System.out.print(top + " ");
        s.push(top);
    }

    public static void pop_n_from_bottom(Stack<Integer> st, int n) {
        // temp stack
        Stack<Integer> temp = new Stack<>();
        int count = 1;
        int size = st.size();

        // st to temp except n
        while (st.size() > 0) {
            if (count == size - n + 1) {
                st.pop();
                count++;
                continue;
            }
            int top = st.pop();
            temp.push(top);
            count++;
        }

        // refill temp to st and print st
        while (temp.size() > 0) {
            int top = temp.pop();
            System.out.print(top + " ");
            st.push(top);
        }
    }

    public static void MF(Stack<String> st) {

        Queue<String> qt = new LinkedList<String>();

        while (!st.isEmpty()) {
            String top = st.pop();

            String peek = "";
            if (!st.isEmpty()) {
                peek = st.peek();
            }

            if (peek.charAt(0) != top.charAt(0)) {
                // can pair
                System.out.println(top + " and " + peek + " are paried");
                st.pop();
            }

            else {
                if (peek.charAt(0) == 'F') {
                    qt.add(peek);
                } else {
                    if (!qt.isEmpty()) {
                        System.out.println(qt.peek() + " and " + peek + " are paired (odd)");
                        qt.remove();
                        st.pop();
                    }
                }
            }
        }

    }
}
