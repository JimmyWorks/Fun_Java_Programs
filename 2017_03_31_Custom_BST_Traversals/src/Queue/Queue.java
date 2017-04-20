/*
 * Custom Binary-Search Tree and Queue Classes for Breadth-First and Depth-First Traversals
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */
package Queue;

import BSTree.*;
public class Queue {
    
    public QNode front;
    public QNode back;
    
    public Queue(){
        front = null;
        back = null;
    }
    
    public void push(Node newNode, int depth){
        if(newNode != null){
            QNode newQNode = new QNode(newNode, depth);

            newQNode.next = back;
            if(newQNode.next != null)
                newQNode.next.prev = newQNode;       
            back = newQNode;

            if(front == null)
                front = newQNode;
        }
    }
    
    public QNode pop(){
        if(front == null){
            return null;
        }
        else{
            QNode thisNode = front;
            
            front = front.prev;
            if(front == null){
                back = null;
            }
            else
                front.next = null;
            
            return thisNode;
        }
    }
    
    public Boolean isEmpty(){
        return front == null;
    }
    
}
