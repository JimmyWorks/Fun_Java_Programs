/*
 * Project: 
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */
package Stack;

/**
 *
 * @author Jimmy
 */
public class CustomStack {
    Node top;
    
    public CustomStack(){
        top = null;
    }
    
    public void push(Node newNode){
        if(top == null){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
    }
    
    public void pop(){
        if(top != null){
            char x = getTop();
            top = top.next;
        }
        
    }
    
    public char getTop(){
        if(top != null){
            return top.operator;
        }
        else
            return '\u0000';
    }
    
}
