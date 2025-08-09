public class DoublyLL {
    public static class DNode {
        int val;
        DNode next, prev;

        DNode(int val) {
            this.val = val;
        }
    }

    public static void display(DNode head) {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
            if (temp == null) {
                System.out.print(temp);
            }
        }

    }

    public static void displayRev(DNode tail) {
        DNode temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.prev;

        }
    }

    public static void displayRevRandom(DNode random) {
        DNode temp = random;
        while (temp.next != null) { // goes to last node
            temp = temp.next;
        }

        while (temp != null) { // orints Reverse
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
    }

    public static void insertAtHead(DNode head, int value) {
        DNode temp = new DNode(value);
        temp.prev = null;
        temp.next = head;
        head.prev = temp;

        head = temp;

    }

    public static void insertAtTail(DNode head, int value) {
        DNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        DNode n = new DNode(value);
        tail.next = n;
        n.prev = tail;
    }

    public static DNode remDup(DNode head) {

        DNode h1 = head;

        while (h1 != null) {
            DNode h2 = h1;

            while (h2.next != null) {
                if (h1.val == h2.next.val) {
                    h2.next = h2.next.next;
                }

                if (h2.next == null) {
                    break;
                }
                h2 = h2.next; // traversal
            }

            if (h1.next.next == null) {
                break;
            }

            h1 = h1.next; // traversal


        }

        return head;
    }
}
