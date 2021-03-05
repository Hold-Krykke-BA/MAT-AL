package solution.sorts;

import java.util.ArrayList;
import java.util.List;

public class Trie {
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
            if (!node.containsLink(currentChar)) {
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
            if (node.containsLink(currentChar)) {
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

    private void traverse(TrieNode node, String word, List<String> fullWords){
        if(node.isEnd()){
            fullWords.add(word);
        }

        for (int i = 0; i < 26; i++) {
            String temp = word + (char) (i + 'a');
            if (!node.containsLink((char) (i + 'a'))) continue;
            traverse(node.get((char) (i + 'a')), temp, fullWords);
        }
    }

    public void traverse(String word, List<String> fullWords){
        traverse(root, word, fullWords);
    }

    public void buildTrie(String[] stringArray){
        //int count = 0;
        for (int i = 0; i < stringArray.length ; i++){
            insert(stringArray[i]);
            //count++;
        }
        //System.out.println("\n\nCOUNT: " + count + "\n\n");
    }
}

class TrieNode {

    // R amount of links to node children
    private TrieNode[] links;

    // Maximum of ALPHABET links to its children, where each link
    // corresponds to one of ALPHABET character values from the dataset alphabet.
    // if more signs and letters are wanted, change R to 255 and don't subtract
    // 'a' from a new _char, but from the ascii index that will put 'a' first.
    private final int ALPHABET = 26;

    // Flag to indicate end of branch or just a prefix
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[ALPHABET];
    }

    // links[_char -'a'] --> https://stackoverflow.com/a/55332800
    // _char subtracted from a in ascii, i.e. ("b" - "a") == (98 - 97) == 1

    public boolean containsLink(char _char) {
        return links[_char - 'a'] != null;
    }
    public TrieNode get(char _char) {
        return links[_char - 'a'];
    }
    public void put(char _char, TrieNode node) {
        links[_char - 'a'] = node;
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
//        int i;
//        for (i = 0; i < words.length ; i++){
//            trie.insert(words[i]);
//        }
        trie.buildTrie(words);


        System.out.println("any words starts with - el " + trie.startsWith("el"));
        System.out.println("any words starts with - th " + trie.startsWith("th"));

        System.out.println("bit - is in trie? " + trie.search("bit"));
        System.out.println("byte - is in trie? " + trie.search("byte"));
        System.out.println("elephant - is in trie? " + trie.search("elephant"));
        System.out.println("elector - is in trie? " + trie.search("elector"));
        System.out.println("TEST (char) 0 + 'a': " + (char) 0 + 'a');
        System.out.println("TEST '0' + 'a': " + ('0' + 'a'));


        System.out.println("\n\n");
        System.out.println("***************************");
        List<String> listWords = new ArrayList<>();
        trie.traverse("", listWords);
        for (int j = 0; j < listWords.size(); j++) {
            System.out.println(listWords.get(j));
        }
    }
}

