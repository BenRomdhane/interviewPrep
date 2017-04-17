package com.interview.prep.Tries;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikitash Pawar on 4/12/2017.
 */
public class TrieNode {

    private Map<Character,TrieNode> tracker=new HashMap<Character,TrieNode>();
    private boolean isAWord;
    public void insert(String value) {
        if(value.length()==0)
        {
            isAWord=true;
            return;
        }
        char[] charArray = value.toCharArray();
        char key = charArray[0];
        TrieNode trieNode = tracker.get(key);
        if(trieNode ==null){
            tracker.put(key,new TrieNode());
        }
            tracker.get(key).insert(value.substring(1,value.length()));

    }

    public boolean search(String searchString,TrieNode node) {

        if(searchString.length()==0 && node!=null){
            return node.isAWord;
        }else if(searchString.length()==0 && node==null){
            return false;
        }
        char[] charArray = searchString.toCharArray();

        return search(searchString.substring(1,searchString.length()),node.tracker.get(searchString.toCharArray()[0]));
    }

    public void delete(String values) {
    delete(values,this);
    }

    private void delete(String values, TrieNode node) {
        if(values.length()==0 && node!=null){
            node.isAWord=false;
            return ;
        }else if(values.length()==0 && node==null){
            return;
        }
        char[] charArray = values.toCharArray();

        delete(values.substring(1,values.length()),node.tracker.get(values.toCharArray()[0]));

    }

}
