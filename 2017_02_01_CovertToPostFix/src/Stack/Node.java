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
public class Node {
    
    public char operator;
    Node next;
    
    public Node(char mychar){
        operator = mychar;
        next = null;
        //System.out.printf("New node created with operator: %c\n", operator);
    }
    
}
