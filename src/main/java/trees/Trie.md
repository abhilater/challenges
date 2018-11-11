# Trie

![](https://cdn-images-1.medium.com/max/600/1*rkanFIU4G_tmuC939_txhA.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*kxvAPQ3xtvRV5mnLE2_9Hw.jpeg)

![](https://cdn-images-1.medium.com/max/600/1*sZOrNXzlQICVv5ePpav1-g.jpeg)

# Usage
![](https://cdn-images-1.medium.com/max/1600/1*ySlJYfWNF2Tm1lKF77jJhg.gif)

```java
/*class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> m = new HashMap<>();

    public TrieNode() {
        this.isEnd = false;
        for (int c = (int) 'a'; c <= (int) 'z'; c++) {
            m.put((char) c, null);
        }
    }*/
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
```