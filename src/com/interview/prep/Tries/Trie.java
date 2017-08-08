package com.interview.prep.Tries;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikitash Pawar on 4/12/2017.
 */
public class Trie {
    public static void main(String[] args) {

        TrieNode root=new TrieNode();
        root.insert("cat");
        root.insert("cattle");
        root.insert("camel");
        root.insert("care");
        root.insert("calm");

        List<String> matches=root.match("ca",root);

        System.out.println(Arrays.asList(matches));

    }

}
