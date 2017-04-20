/*
 * Custom Binary-Search Tree and Queue Classes for Breadth-First and Depth-First Traversals
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */
package BSTree;

import Queue.*;

public class BSTree
{
    Node root;
    
    public BSTree(){
        root = null;
    }
    
    public BSTree(Node root){
        this.root = root;
    }
    
    public Node getRoot()
    {   return root;    }
    
    public void setRoot(Node n)
    {   root = n;   }
    
    public boolean search(int n){
        Node findNode = new Node(n);
        return search(findNode);
    }
    
    public boolean search(Node n)
    {
        Node cur = root;
        while (cur != null)
        {
            if(n.compareTo(cur) == 0)
                return true;
            else if(n.compareTo(cur) < 0)
		cur = cur.left;
            else
		cur = cur.right;
	}
	return false;	            
    }
    
    
    public void insert(int val){
        Node newNode = new Node(val);
        insert(newNode);
    }
    
    
    public void insert(Node n)
    {
        if (root == null)
        {
            root = n;
            return;
        }
        else
	{
        	Node cur = root;
               
       		while (true)
        	{
	            if(n.compareTo(cur) < 0)
		    {
			if (cur.left == null)
			{
				cur.left = n;
				return;
			}
        	        cur = cur.left;
		    }
	            else
		    {
	        	if (cur.right == null)
			{
				cur.right = n;
				return;
			}
        	        cur = cur.right;
		    }
		}
        }
   
    }
    
    public Node delete(Node n)
    {
        Node cur = root, parent = root;

        while (cur != null)
        {	
		//check if node is to the left
                if (n.compareTo(cur) < 0)
                {
                        parent = cur;
                        cur = cur.left;
                }
		//check if node is to the right
                else if (n.compareTo(cur) > 0)
                {
                        parent = cur;
                        cur = cur.right;
                }
		//break loop when node found
                else
                        break;
        }

	//check if node found - loop could end when cur == null
        if (cur != null)
        {
                //check if cur has 0 children
		if (cur.left == null && cur.right == null)
                    //make link from parent = null
		    if (parent.left == cur)
                            parent.left = null;
                    else
                            parent.right = null;
		//check if cur has 1 child on right
                else if(cur.left == null)
                {
		    //link proper parent link to child of cur
                    if (parent.left == cur)
                        parent.left = cur.right;
                    else
                        parent.right = cur.right;
		    //disconnect cur from tree
                    cur.right = null;
                }
		//check if cur has 1 child on left
                else if (cur.right == null)
                {
		    //link proper parent link to child of cur
                    if (parent.right == cur)
                        parent.right = cur.left;
                    else
                        parent.left = cur.left;
		    //disconnect cur from tree
                    cur.left = null;
                }
		//cur has 2 children
                else
                {
		    //parent will hold position where node will be copied
                    parent = cur;
		    //move cur to left child
                    cur = cur.left;
                    
		    //move cur down right branch of left subtree
                    while (cur.right != null)
                        cur = cur.right;
                    
		    //copy content from node to node
                    parent.num = cur.num;
		    //call delete again to delete the node that was copied
                    delete (cur);
                }
                        

        }
        return cur;
    }
    
@Override
    public BSTree clone() throws CloneNotSupportedException{
        BSTree myClone = new BSTree();
        
        if(root != null){
            myClone.insert(root.num);
            cloneHelper(myClone, root);
        }
        
        return myClone;    
        
    }
    
    public void cloneHelper(BSTree myClone, Node cur){
        
        if(cur.left != null && cur.right != null){
            myClone.insert(cur.left.num);
            myClone.insert(cur.right.num);
            cloneHelper(myClone, cur.left);
            cloneHelper(myClone, cur.right);
        }
        else if(cur.left != null){
            myClone.insert(cur.left.num);
            cloneHelper(myClone, cur.left);
            
        }
        else if(cur.right != null){
            myClone.insert(cur.right.num);
            cloneHelper(myClone, cur.right);
        }

    }
    
    public void preOrderPrint(){
        
        if(root != null){
            System.out.println("Printing tree...");
            printHelper(root, 0);
            System.out.println();
        }
        else
            System.out.println("This tree is an empty tree.");        
    }
    
    public void printHelper(Node cur, int depth){
        //if(right){
            System.out.printf("->%4d ", cur.num);
            System.out.flush();
            depth++;
            
            
            if(cur.right != null){
                printHelper(cur.right, depth);
            }
//            else{
//                System.out.printf("->    ");
//                System.out.flush();
//            }
              
            if(cur.left != null){
                System.out.print("\n");
                for(int i = 0; i < depth; i++){
                    System.out.print("       ");
                }
                System.out.flush();
                printHelper(cur.left, depth);
            }
//            else{
//                System.out.print("\n");
//                for(int i = 0; i < depth; i++){
//                    System.out.print("       ");
//                }
//                System.out.printf("->    ");
//                System.out.flush();
//            }
    }
     public void breadthFirstPrint(){
        
        if(root != null){
            System.out.println("Printing tree...");
            Queue myQ = new Queue();
            
            QNode cur = null;
            int depth = 0;
            myQ.push(root, depth);
            
            while(!myQ.isEmpty() || cur != null){
                
                if(cur == null){
                    cur = myQ.pop();
                }
                else{
                    
                    if(depth != cur.depth){
                        depth = cur.depth;
                        System.out.printf("\nLevel %d: %d ", depth, cur.BSTNode.num);
                    }
                    else if(depth == 0){
                        System.out.printf("Root: %d", cur.BSTNode.num);
                        //System.out.printf("Cur Depth is %d", cur.depth);
                    }
                    else{
                        System.out.printf("%d ", cur.BSTNode.num);
                    }
                    myQ.push(cur.BSTNode.left, (depth+1));
                    myQ.push(cur.BSTNode.right, (depth+1));
                    cur = null;
                }
               // System.out.println("Current Depth: " + depth);
            }
            System.out.println();
            
            
            
        }
        else
            System.out.println("This tree is an empty tree.");        
    }
//      public void printHelper2(Node cur, int depth){
//        if(cur != null){
//            printHelper2(cur.right, depth+1);
//            
//            if(depth == 0){
//                System.out.printf("Root: %s\n", cur.num);
//            }
//            else{
//                System.out.printf()
//            }
//            System.out.printf()
//                    
//            printHelper2(cur.left, depth+1);
//            
//            System.out.printf("->%4d ", cur.num);
//            System.out.flush();
//            depth++;
//            
//            
//            if(cur.right != null){
//                printHelper(cur.right, depth);
//            }
//              
//            if(cur.left != null){
//                System.out.print("\n");
//                for(int i = 0; i < depth; i++){
//                    System.out.print("       ");
//                }
//                System.out.flush();
//                printHelper(cur.left, depth);
//            }
//        }
//    }
    
    public int getHeight (){
        if(root != null){
            if(root.left == null && root.right == null)
                return 0;
            else{
                BSTree leftTree = new BSTree(root.left);
                BSTree rightTree = new BSTree(root.right);
                int leftTreeHeight = leftTree.getHeight(); //recursive call
                int rightTreeHeight = rightTree.getHeight(); //recursive call
                if(leftTreeHeight > rightTreeHeight)
                    return 1 + leftTreeHeight;
                else
                    return 1 + rightTreeHeight;
                
            }
        }
        else
            return 0;
    }
    public Boolean equals(BSTree secondTree){

        if(root != null && secondTree.root != null)
            return equalsHelper(root, secondTree.root);  
        else if(root == null && secondTree.root == null)
            return true;
        else
            return false;
    }
    
    public Boolean equalsHelper(Node cur1, Node cur2){
        if(cur1.compareTo(cur2) == 0){
            Boolean leftTreeEqual = false;
            Boolean rightTreeEqual = false;
            
            if(cur1.left != null && cur2.left != null)
                leftTreeEqual = equalsHelper(cur1.left, cur2.left);
            else if(cur1.left == null && cur2.left == null)
                leftTreeEqual = true;
            else
                leftTreeEqual = false;
            
            if(cur1.right != null && cur2.right != null)
                rightTreeEqual = equalsHelper(cur1.right, cur2.right);
            else if(cur1.right == null && cur2.right == null)
                rightTreeEqual = true;
            else
                rightTreeEqual = false;

            return (leftTreeEqual && rightTreeEqual);    
        }
        else
            return false;
    }
    
}

