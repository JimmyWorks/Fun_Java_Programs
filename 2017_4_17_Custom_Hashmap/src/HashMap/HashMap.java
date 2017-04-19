/*
 * CS 2336 Computer Science II
 * Homework 7: Custom Quadratic Hash Table
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */
package HashMap;

public class HashMap {
    // Can change initial size of all new Hash Tables, if needed
    public static int INITIAL_SIZE = 9;
    
    private HashItem[] table;
    
    public HashMap(){
        table = new HashItem[INITIAL_SIZE];
        for(int i = 0; i < INITIAL_SIZE; i++){
            table[i] = null;
        }
    }
    
    public int sizeOf(){
        int numOfEntries = 0;
        
        for(HashItem i: table){
            if(i != null)
                numOfEntries++;
        }
        
        return numOfEntries;
    }
    
    public void insert(HashItem newEntry){
        System.out.printf("Inserting %d\n", newEntry.key);
        // position = key mod N = k + 0^2
        int position = newEntry.key%table.length;
        System.out.printf("Try insert at index: %d\n", position);
        // if k position is empty        
        if(table[position] == null){
            table[position] = newEntry;
        }
        else{
            // position is now k + 1^2
            position = (position + 1)%table.length;
                    System.out.printf("Try insert at index: %d\n", position);
            // if k + 1 position (base case in quadratic sequence), is empty
            if(table[position] == null)
                table[position] = newEntry;
            // else (k + 1) + 3 + 5 + 7 + 9 + ... till solution found
            else{
                int j = 1;
                while(table[position] != null && j != table.length){ //while an empty position is not found
                    // apply quadratic probing, w/ curr position + ith element in sequence {1, 3, 5, 7, 9, 11..., i}
                    // adding to successive checks, since 2^2 = 1+3, 3^2 = 1+3+5, 4^2 = 1+3+5+7, etc.
                    position = (int) (position + 1 + Math.pow(2, j));
                    position = position%table.length;
                    j++;
                    System.out.printf("Try insert at index: %d\n", position);
                }
                table[position] = newEntry;
            }
        }
        checkLoading();
        
    }
    
    private void checkLoading(){
        int entries = 0;
        for(HashItem i: table){
            if(i != null)
                entries++;
        }
        System.out.printf("Number of entries now: %d\n", entries);
        double loading = (entries+0.0)/table.length;
        System.out.printf("Current loading: %.2f\n\n\n", loading);
        if(loading >= 0.5)
            rehashTable();
    }
    
    private void rehashTable(){
        System.out.printf("Building new Hash Table...\n");
        HashItem[] newTable = new HashItem[table.length*2];
        HashItem[] oldTable = table;
        table = newTable;
        
        for (HashItem i : oldTable) {
            if (i != null) {
                insert(i);
            }
        }
        System.out.printf("New table completed.");
    }
    
    public void print(){
        for(int i = 0; i < table.length; i++){
            
            if(table[i] == null)
                System.out.printf("Index %d: null\n", i);
            else
                System.out.printf("Index %d: Key: %d, String: %s\n", i, table[i].key, table[i].name);
        }
    }
    
}
