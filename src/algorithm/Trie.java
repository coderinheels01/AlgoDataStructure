package algorithm;

class TrieNode{
    public char value;
    public TrieNode[] children = new TrieNode[26];
    public  boolean isEnd;
    public TrieNode(){

    }
    public TrieNode(char value){
        this.value = value;
    }

}

/*
 * 1. need array of 26 char TriesNode array as children
 * 2. Root will be empty value.
 */
public class Trie {
    TrieNode root;
    public Trie() {
        root= new TrieNode();
        root.value = ' ';
    }

    // traverse each char and check if it's already in the children array,
    // if no then insert a new node. otherwise keep moving to the nexe level.
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0; i< word.length(); i++){
            char c = word.charAt(i);
            if( current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode(c);

            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }

    // find each children by walking through char array. if current is null or it is not the
    // end of the word then we don't have a full word.
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0; i< word.length(); i++){
            if(current == null)
                break;
            current = current.children[word.charAt(i) - 'a'];
        }
        return current != null && current.isEnd;
    };

    // find each children by walking through char array. if current is null then we have a prefix with value
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0; i< prefix.length(); i++){
            if(current == null)
                break;
            current = current.children[prefix.charAt(i) - 'a'];
        }
        return current != null;
    }
}

