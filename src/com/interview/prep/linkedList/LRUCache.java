package com.interview.prep.linkedList;

import java.util.HashMap;

/**
 * Created by Nikitash Pawar on 4/24/2017.
 */

/**
 * The LRU cache is a hash table of keys and double linked nodes.
 * The hash table makes the time of get() to be O(1).
 * The list of double linked nodes make the nodes adding/removal operations O(1).
 *
 * two main operations
 * -get
 * -set
 *
 * both are combination of setHead- adding the node and remove- removing the node
 *
 */
public class LRUCache {
    int capacity;
    HashMap<Integer, DNode> map = new HashMap<Integer, DNode>();
    DNode head=null;
    DNode end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * If page present
     *  -remove the page from its current location
     *  -move it to the top of the list or head as this is most recently accessed
     *
     * If page not present return -1. Indicating page not present in cache
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if(map.containsKey(key)){
            DNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }


    /**
     * If key already present then do a get operation
     * If key not present
     *  - if cache is at max capacity
     *      .remove the tail node
     *      .add newly created node to the head
     *      .move the tail back by one node
     *  - if cache not at max capacity
     *      .add the newly created node at the head
     *      .increment current cache size
     *
     * @param key
     * @param value
     */
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DNode old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            DNode created = new DNode(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);

            }else{
                setHead(created);
            }

            map.put(key, created);
        }
    }

    /**
     * remove curr and link prev and next
     * handle prev is null
     * handle next is null
     * @param n
     */
    public void remove(DNode n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }

    /**
     * adding to top
     * @param n
     */
    public void setHead(DNode n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;

        head = n;

        if(end ==null)
            end = head;
    }


}
