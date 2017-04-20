/*
 * Custom Binary-Search Tree and Queue Classes for Breadth-First and Depth-First Traversals
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

import BSTree.*;

public class Main {


    public static void main(String[] args) throws Exception{
        
        System.out.println("Creating Tree 1 and inserting the following nodes in the following order:");
        System.out.println("25, 30, 10, 15, 7, 45, 50, 27, 26, 21\n");
        BSTree Tree1 = new BSTree();

        Tree1.insert(25);
        Tree1.insert(30);
        Tree1.insert(10);
        Tree1.insert(15);
        Tree1.insert(7);
        Tree1.insert(45);
        Tree1.insert(50);
        Tree1.insert(27);
        Tree1.insert(26);
        Tree1.insert(21);


        
        System.out.println("Creating Tree 2.\nCreating clone of Tree 1 and setting it equal to Tree 2\n");
        BSTree Tree2 = new BSTree();
        Tree2 = Tree1.clone();
        
        System.out.println("Creating Tree 3 and inserting the same nodes as Tree 1 in the following order:");
        System.out.println("7, 30, 15, 45, 50, 25, 21, 27, 10, 26\n");
        BSTree Tree3 = new BSTree();
        
        Tree3.insert(7);        
        Tree3.insert(30);
        Tree3.insert(15);
        Tree3.insert(45);
        Tree3.insert(50);
        Tree3.insert(25);  
        Tree3.insert(21);
        Tree3.insert(27);
        Tree3.insert(10);
        Tree3.insert(26);          
        
        System.out.printf("The height of Tree 1 is %d\n", Tree1.getHeight());      
        System.out.printf("The height of Tree 2 is %d\n", Tree2.getHeight());
        System.out.printf("The height of Tree 3 is %d\n\n", Tree3.getHeight());
        
        System.out.println("Diagram Depiction of Tree 1 using a Depth-First, Pre-Order Traversal Print:\n===============\n");
        Tree1.preOrderPrint();        
        
        System.out.println();
        System.out.println("Diagram Depiction of Tree 2 using a Depth-First, Pre-Order Traversal Print:\n===============\n");
        Tree2.preOrderPrint();
        
        System.out.println();
        System.out.println("Diagram Depiction of Tree 3 using a Depth-First, Pre-Order Traversal Print:\n===============\n");
        Tree3.preOrderPrint();        
        System.out.println();
        
        System.out.println("True/False: Tree 1 and Tree 2 equal?  " + Tree1.equals(Tree2));
        System.out.println("True/False: Tree 1 and Tree 3 equal?  " + Tree1.equals(Tree3));
        
        System.out.println();
        System.out.println("Diagram Depiction of Tree 1 using a Breadth-First Traversal Print:\n===============\n");
        Tree1.breadthFirstPrint();
        
        
    }
}
