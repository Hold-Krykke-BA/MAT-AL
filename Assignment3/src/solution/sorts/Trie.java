package solution.sorts;

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert new word into Trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            // if node doesn't contain char --> make new node
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    // search a prefix or word in trie
    // return the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

}

class TrieNode {

    // R amount of links to node children
    private TrieNode[] links;

    // Maximum of R links to its children, where each link
    // corresponds to one of R character values from the dataset alphabet.
    private final int R = 26;

    // Flag to indicate end of branch or just a prefix
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    // links[_char -'a'] --> https://stackoverflow.com/a/55332800
    // _char subtracted from a in ascii, i.e. ("b" - "a") == (98 - 97) == 1

    public boolean containsKey(char _char) {
        return links[_char -'a'] != null;
    }
    public TrieNode get(char _char) {
        return links[_char -'a'];
    }
    public void put(char _char, TrieNode node) {
        links[_char -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class tester {
    public static void main(String args[]) {
        Trie trie = new Trie();
        String words[] = {"elephant", "electric", "else", "end", "any", "and", "a", "by", "bye", "byte"};

        // Build trie
        int i;
        for (i = 0; i < words.length ; i++){
            trie.insert(words[i]);
        }


        System.out.println("any words starts with - el " + trie.startsWith("el"));
        System.out.println("any words starts with - th " + trie.startsWith("th"));

        System.out.println("bit - is in trie? " + trie.search("bit"));
        System.out.println("byte - is in trie? " + trie.search("byte"));
        System.out.println("elephant - is in trie? " + trie.search("elephant"));
        System.out.println("elector - is in trie? " + trie.search("elector"));


    }
}

