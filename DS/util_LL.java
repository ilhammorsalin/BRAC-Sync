
import java.util.LinkedList;

public class util_LL {
    public static void main(String[] args) {
        LinkedList<Integer> nums1 = new LinkedList<>();

        System.out.println(nums1.poll()); // poll better
        nums1.add(1);
        System.out.println(nums1.pop()); // pop shows error when empty list where poll shows null
        nums1.add(2);
        nums1.add(3); // index 1, 3 is removed
        nums1.add(4); // index 2, here 5 is added
        nums1.add(5);

        nums1.remove(1);
        nums1.add(2, 10000);

        System.out.println(nums1);

        nums1.push(10); // add first
        nums1.addFirst(20);

        nums1.offer(50); // add last
        nums1.addLast(60);

        System.out.println(nums1);

        LinkedList<Integer> nums2 = new LinkedList<>();

        nums2.add(1);
        nums2.add(2);
        nums2.add(3);
        nums2.add(4);
        nums2.add(5);

        nums1.addAll(nums2); // adds nums2 at the end of nums1
        System.out.println(nums1);

    }
}
