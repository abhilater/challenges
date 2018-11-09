package trees;

/**
 * Created by abhishek on 08/11/18.
 */
public class TreeEasy {

    /**
     * If single node tree's height is supposed to be 0 then pass -1
     * else pass 0
     *
     * @param root
     * @return
     */
    public static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * For being LCA a node should have 1 from left and 2 from right sub tree
     * i) If root is null then return null
     * ii) If root.data is either v1 or v2 the return root;
     * iii) Gather l & r
     * iv) Check if l & r are both not null, return root
     * v) else return l or r whichever is not null
     *
     * @param root
     * @param v1
     * @param v2
     * @return
     */
    public static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data == v1 || root.data == v2) return root;
        Node l = lca(root.left, v1, v2);
        Node r = lca(root.right, v1, v2);
        if (l != null && r != null) return root;
        return (l != null ? l : r);
    }

    /**
     * Root data should be > max of LST and < min of RST
     * i) If root is null return true
     * ii) Find max of LST and min of RST
     * iii) if condition holds and both LST and RST recursively are true return true else false;
     *
     * @param root
     * @return
     */
    boolean checkBST(Node root) {
        if (root == null) return true;
        int max = maxOfSubtree(root.left);
        int min = minOfSubtree(root.right);
        return (root.data > max && root.data < min && checkBST(root.left) && checkBST(root.right));
    }

    /**
     * i) If root is null return minimum value
     * ii) return Math.max(root data, max of lst, max of rst)
     *
     * @param root
     * @return
     */
    int maxOfSubtree(Node root) {
        if (root == null) return -1;
        return Math.max(root.data, Math.max(maxOfSubtree(root.left), maxOfSubtree(root.right)));
    }

    /**
     * i) If root is null return MAX value
     * ii) return Math.min(root data, min of lst, min of rst)
     *
     * @param root
     * @return
     */
    int minOfSubtree(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(minOfSubtree(root.left), minOfSubtree(root.right)));
    }

}


class Node {
    int data;
    Node left;
    Node right;
}