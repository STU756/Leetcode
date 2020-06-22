package com.jia.ds.tree;


public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    //search a prefix or whole key in trie and
    //returns the node where search ends
    //Time:O(m)  m is the length of the word
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)) {
                node.get(currentChar);
            }else {
                return null;
            }
        }
        return node;
    }
    //Returns if the word is in the trie
    //Time:O(m)  m is the length of the word
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    //Insert a work into the trie
    //Time:O(m) m is the length of the key.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
}
class TrieNode {

    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;;

    public TrieNode(){
        links = new TrieNode[R];
    }


    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return this.isEnd;
    }

}
