/*
 * Custom Binary-Search Tree and Queue Classes for Breadth-First and Depth-First Traversals
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */
package BSTree;

 
public class Node implements Comparable<Node>{
    int num;
    Node left = null, right = null;
    
    Node(int n)
    { num = n;      }
    
    Node(char c)
    { num = c;      }
    
    public int getNum()
    { return num;   }
    
    public void setNum(int n)
    {  num = n;  }

    public Node getLeft()
    { return left;  }
    
    public void setLeft(Node n)
    {  left = n;    }
    
    public Node getRight()
    { return right;  }
    
    public void setRight(Node n)
    {  right = n;    }
    
    @Override
    public int compareTo(Node n)
    {
        return this.num - n.num;
    }
    
    
    
}
