/*
 * Custom Hash Table with Quadratic Probing
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

import HashMap.*;

public class Main {
    
    static final int[] TEST_NUMBERS = {101, 345, 603, 612, 621, 354, 900, 99, 197};
    static final String[] TEST_VALUES = {   "one hundred one",
                                            "three hundred five",
                                            "six hundred three",
                                            "six hundred twelve",
                                            "six hundred twenty-one",
                                            "three hundred fifty-four",
                                            "nine hundred",
                                            "ninety-nine",
                                            "one hundred ninety-seven"};
        
    public static void main(String[] args) {
        System.out.println("Let's make an array of items we can use test the custom HashMap!\n");
        System.out.println("Creating array of hash items...\n");
        HashItem[] testArray = new HashItem[TEST_NUMBERS.length];
        
        for(int i = 0; i < TEST_NUMBERS.length; i++){
            testArray[i] = new HashItem(TEST_NUMBERS[i], TEST_VALUES[i]);
        }
                
        System.out.println("Here are the items in our array");
        for(HashItem i: testArray){
            System.out.printf("Key: %d, String Member: %s\n", i.key, i.name);
        }
        System.out.println("\n\n==========================================================\n");
        System.out.println("Okay, now to create the HashMap.  The default size is 9 with a loading of 50%\n");
        System.out.println("Creating Hashmap...\n");
        
        HashMap myHashmap = new HashMap();
        
        System.out.printf("HashMap created.  Number of entries: %d\n\n", myHashmap.sizeOf());
        
        System.out.println("Let's add the following items from our array into the HashMap:");
        System.out.println("101, 345, 603, 612\n");
        
        myHashmap.insert(testArray[0]);
        myHashmap.insert(testArray[1]);
        myHashmap.insert(testArray[2]);
        myHashmap.insert(testArray[3]);
        
        System.out.println("Current HashMap...");
        myHashmap.print();
        
        System.out.println("\n\n==========================================================\n");
        System.out.println("The next entry should cause the loading to exceed the limit of 0.5!\nNow inserting 99\n");
        
        myHashmap.insert(testArray[7]);
        
        System.out.println("First rehash complete.  Current HashMap...");
        myHashmap.print();
        
        System.out.println("\n\n==========================================================\n");
        System.out.println("Finally, let's test wrap-around entries\nNow inserting entries: 197, 197\n");
        
        myHashmap.insert(testArray[8]);
        myHashmap.insert(testArray[8]);
        
        System.out.println("Current HashMap...");
        myHashmap.print();
        
        System.out.println("\n\n==========================================================\n");
        System.out.println("Let's insert a few more values to see a second rehash.\nNow inserting 354, 900\n");
    
        myHashmap.insert(testArray[5]);
        myHashmap.insert(testArray[6]);
        
        System.out.println("Second rehash complete.  Current HashMap...");
        myHashmap.print();
    }

        
}
