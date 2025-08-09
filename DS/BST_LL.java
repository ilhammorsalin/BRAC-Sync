class BSTNode {
    int elem;
    BSTNode left, right;

    public BSTNode(int elem) {
        this.elem = elem;
        left = right = null;
    }
}


public class BST_LL {

    public static BSTNode build(BSTNode root, int[] arr) {
        for (int i : arr) {
            root = insert(root, i);
        }
        return root;
    }

    public static BSTNode insert(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }


        if (key < root.elem) {
            root.left = insert(root.left, key);
        } else if (key > root.elem) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.elem + " ");
            inorder(root.right);
        }
    }

    public static void descOrder(BSTNode root) {
        if (root != null) {
            descOrder(root.right);
            System.out.print(root.elem + " ");
            descOrder(root.left);
        }
    }

    public static boolean Search(BSTNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.elem < key) {
            return Search(root.right, key);
        }

        else if (root.elem > key) {
            return Search(root.left, key);
        }

        else {
            return true;
        }
    }

    public static BSTNode delete(BSTNode root, int key) {
        if (root == null)
            return null;

        if (key > root.elem) {
            root.right = delete(root.right, key);
        } else if (key < root.elem) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }

            else if (root.right == null) {
                return root.left;
            }

            BSTNode succ = successor(root.right);
            root.elem = succ.elem;
            root.right = delete(root.right, succ.elem);
        }

        return root;
    }

    public static BSTNode successor(BSTNode root) {
        if (root.left == null)
            return root;
        return successor(root.left);
    }

    private static int countNodes(BSTNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static BSTNode buildBalancedBST(int[] array, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        BSTNode node = new BSTNode(array[mid]);

        node.left = buildBalancedBST(array, start, mid - 1);
        node.right = buildBalancedBST(array, mid + 1, end);

        return node;
    }

    public static BSTNode balance(BSTNode root) {
        if (root == null)
            return null;

        int size = countNodes(root);
        int[] array = new int[size];
        storeInorder(root, array, 0);

        return buildBalancedBST(array, 0, size - 1);
    }

    private static int storeInorder(BSTNode node, int[] array, int index) {
        if (node == null)
            return index;

        index = storeInorder(node.left, array, index);
        array[index] = node.elem;
        index = index + 1;
        index = storeInorder(node.right, array, index);

        return index;
    }

    public static int levelSum(BSTNode root, int level) {
        if (root == null)
            return 0;
        if (level == 0)
            return root.elem;

        else {
            return levelSum(root.left, level - 1) + levelSum(root.right, level - 1);
        }

    }

    public static int targetSum(BSTNode root, int target) {
        // First check if target exists in the tree
        if (!Search(root, target)) {
            return 0;
        }

        if (root == null)
            return 0;

        if (target > root.elem) {
            return root.elem + targetSum(root.right, target);
        } else if (target < root.elem) {
            return root.elem + targetSum(root.left, target);
        } else { // target == root.elem
            return root.elem;
        }
    }

    public static boolean isIdentical(BSTNode root1, BSTNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        else if (root1 == null || root2 == null) {
            return false;
        }

        else {
            return root1.elem == root2.elem && isIdentical(root1.left, root2.left)
                    && isIdentical(root1.right, root2.right);
        }
    }

    public static void mirror(BSTNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        BSTNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    public static void mirrorLevel(BSTNode root, int level) {
        if (root == null)
            return;

        if (level == 1) {
            BSTNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            return;
        }

        mirrorLevel(root.left, level - 1);
        mirrorLevel(root.right, level - 1);

    }

    public static void swap(BSTNode a, BSTNode b) {
        BSTNode temp = b;
        b = a;
        a = temp;
    }

    public static int nodeDepth(BSTNode root, int target) {
        if (root == null) {
            return -1; // Return -1 for non-existent paths
        }

        if (root.elem == target) {
            return 0; // Found the node, depth is 0 at this level
        }

        // Use BST property to search in correct subtree
        if (target < root.elem) {
            int leftDepth = nodeDepth(root.left, target);

            if (leftDepth == -1) {
                return -1;
            }
            return leftDepth + 1;

        } else {
            int rightDepth = nodeDepth(root.right, target);

            if (rightDepth == -1) {
                return -1;
            }
            return rightDepth + 1;
        }
    }

    public static void main(String[] args) {
        BSTNode root = null;

        int[] arr = {1, 2, 2, 2, 2, 2, 3 , 4 , 5 , 6};
        
        root = buildBalancedBST(arr, 0, arr.length - 1);

        BSTPrinter.printNode(root);

        BSTNode root2;

        int[] arr2 = {1,2,3,4,5,6,7,8};

        

    }
}
