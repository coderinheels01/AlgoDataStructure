package algorithm;

public class TrieMain {

    public static void main(String ...args) {

        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        String word  ="apple";
        System.out.println("is the word " + word +" exist? " + trie.search(word));
        word  ="apps";
        System.out.println("is the word " + word +" exist? " + trie.search(word));
        word  ="app";
        System.out.println("is the word " + word +" exist? " + trie.search(word));
        word  ="ad";
        System.out.println("is the word " + word +" exist? " + trie.search(word));
        word  ="applepie";
        System.out.println("is the word " + word +" exist? " + trie.search(word));
        word  ="rest";
        System.out.println("is the word " + word +" exist? " + trie.search(word));

        word  ="jan";
        System.out.println("is the word " + word +" exist? " + trie.search(word));

        word  ="rent";
        System.out.println("is the word " + word +" exist? " + trie.search(word));

        word  ="beer";
        System.out.println("is the word " + word +" exist? " + trie.search(word));

        word  ="jam";
        System.out.println("is the word " + word +" exist? " + trie.search(word));

        String prefix = "apps";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "app";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "ad";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "applepie";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "rest";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "jan";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "rent";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "beer";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
        prefix = "jam";
        System.out.println("is the prefix " + prefix +" exist? " + trie.startsWith(prefix));
    }
}
