package com.interview.prep.Tries;

/**
 * Created by Nikitash Pawar on 4/12/2017.
 */
public class Trie {
    public static void main(String[] args) {

        TrieNode root=new TrieNode();
        root.insert("cat");
        root.insert("camel");
        System.out.println("hi");
        boolean cat = root.search("cad",root);
        System.out.println("hi");
        root.delete("cat");
        cat = root.search("cat",root);
        root.insert("cat");
        cat = root.search("cat",root);
        System.out.println("hi");

    }

}
