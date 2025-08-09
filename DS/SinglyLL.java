public class SinglyLL {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};

        Node h1 = arrToLLRec(arr1);
        display(h1);
    }

    public static class Node {
        int elem;
        Node next;

        Node(int elem) {
            this.elem = elem;
            next = null;
        }

    }

    public static void insert(Node head, int elem) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(elem);
    }

    static void display(Node head) {
        if (head == null) {
            System.out.print("LL is empty");
        } else {
            helper(head);
        }

    }

    static void helper(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.print(head.elem + " -> ");
        helper(head.next);
    }

    static Node arrToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    static Node arrToLLRec(int[] arr) {
        Node head = new Node(arr[0]);
        helper(arr, head, 1);
        return head;
    }

    static void helper(int[] arr, Node head, int index) {
        if (index == arr.length) {
            return;
        }

        head.next = new Node(arr[index]);
        helper(arr, head.next, index + 1);

    }
}
