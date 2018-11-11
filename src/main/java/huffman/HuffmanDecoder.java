package huffman;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by abhishek on 09/11/18.
 */
public class HuffmanDecoder {

    // input is an array of frequencies, indexed by character code

    public static Node buildTree(int[] charFreqs) {

        PriorityQueue<Node> trees = new PriorityQueue<Node>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Node a = trees.poll();
            Node b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static Map<Character, String> mapA = new HashMap<Character, String>();

    public static void printCodes(Node tree, StringBuffer prefix) {
        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data, prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {

        //Scanner input = new Scanner(System.in);

        String test = "howmuchwoodwouldawoodchuckchuckifawoodchuckcouldchuckwood?";

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        Node tree = buildTree(charFreqs);

        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();

        for (int i = 0; i < test.length(); i++) {

            char c = test.charAt(i);
            s.append(mapA.get(c));

        }

        //System.out.println(s);
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

    }
}

abstract class Node implements Comparable<Node> {

    public int frequency; // the frequency of this tree
    public char data;
    public Node left, right;

    public Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }

}

class HuffmanLeaf extends Node {

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }

}

class HuffmanNode extends Node {

    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {


    void decode(String s, Node root) {
        Node temp = root;
        int idx = 0;
        String decoded = "";
        while (idx < s.length()) {
            Object[] objs = huffmanDecode(temp, s, idx, decoded);
            idx = (int) objs[0];
            decoded = (String) objs[1];
            temp = root;
        }
        System.out.println(decoded);
    }

    Object[] huffmanDecode(Node root, String s, int idx, String decoded) {
        if (root == null) return new Object[]{idx, decoded};
        if (root.left == null && root.right == null) {
            decoded = decoded + root.data;
            return new Object[]{idx, decoded};
        }
        if (s.charAt(idx) == '0') return huffmanDecode(root.left, s, idx + 1, decoded);
        else return huffmanDecode(root.right, s, idx + 1, decoded);
    }
}