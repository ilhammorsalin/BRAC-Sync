import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int preIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inOrder = new int[n];
        int[] preOrder = new int[n];

        String[] inStr = br.readLine().split(" ");
        String[] preStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(inStr[i]);
            preOrder[i] = Integer.parseInt(preStr[i]);
        }

        
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inOrder[i], i);
        }

        Node root = buildTree(preOrder, inOrder, 0, n - 1, inMap);
        StringBuilder str = new StringBuilder();
        postOrder(root, str);
        System.out.println(str.toString().trim());
    }

    static Node buildTree(int[] pre, int[] in, int inStart, int inEnd, Map<Integer, Integer> hashMap) {
        if (inStart > inEnd)
            return null;
        int rootVal = pre[preIndex];
        preIndex++;
        Node root = new Node(rootVal);
        int inIndex = hashMap.get(rootVal);
        root.left = buildTree(pre, in, inStart, inIndex - 1, hashMap);
        root.right = buildTree(pre, in, inIndex + 1, inEnd, hashMap);
        return root;
    }

    static void postOrder(Node root, StringBuilder sb) {
        if (root == null)
            return;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val).append(" ");
    }
}