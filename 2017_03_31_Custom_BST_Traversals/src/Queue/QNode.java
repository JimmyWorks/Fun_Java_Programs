/*
 * Custom Binary-Search Tree and Queue Classes for Breadth-First and Depth-First Traversals
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */
package Queue;

import BSTree.*;

public class QNode {
    public QNode next;
    public QNode prev;
    public Node BSTNode;
    public int depth;
    
    public QNode(Node BSTNode, int depth){
        next = null;
        prev = null;
        this.BSTNode = BSTNode;
        this.depth = depth;
    }
    
    
}
