package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhishek on 11/11/18.
 */
public class AutoSuggestTrie {

    static TrieNode root = new TrieNode();

    static void insert(String s) {
        char[] chars = s.toCharArray();
        TrieNode traverser = root;
        TrieNode child = null;
        for (char c : chars) {
           child = traverser.m.get(c);
           if(null == child){
               child = new TrieNode();
               traverser.m.put(c, child);
           }
           traverser = child;
        }
        traverser.isEnd = true;
    }

    static void search(String s){
        char[] chars = s.toCharArray();
        TrieNode traverser = root;
        TrieNode child = null;
        for (char c : chars) {
            child = traverser.m.get(c);
            if(null == child) return;
            traverser = child;
        }
        if(null == traverser) return;
        searchHelper(traverser, s);
    }

    static void searchHelper(TrieNode traverser, String sb) {
        if (traverser == null) return;
        if (traverser.isEnd) System.out.println(sb);

        for (Map.Entry<Character, TrieNode> e : traverser.m.entrySet()) {
            searchHelper(e.getValue(),
                    sb + Character.toString(e.getKey()));
        }
    }

    public static void main(String[] args) {
        insert("pi");
        insert("pie");
        insert("pied");
        insert("pick");
        insert("hello");
        insert("hi");
        System.out.println("Searching pi ...");
        search("pi");
        System.out.println();
        System.out.println("Searching h ...");
        search("h");
        System.out.println();
        System.out.println("Searching pie ...");
        search("pie");
        System.out.println();
        System.out.println("Searching he ...");
        search("he");
        System.out.println();
        System.out.println("Searching hello ...");
        search("hello");
        System.out.println();
        System.out.println("Searching hellod ...");
        search("hellod");
        System.out.println();
    }
}

class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> m = new HashMap<>();

    public TrieNode() {
        this.isEnd = false;
        for (int c = (int) 'a'; c <= (int) 'z'; c++) {
            m.put((char) c, null);
        }
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "isEnd=" + isEnd +
                ", m=" + m +
                '}';
    }
}
