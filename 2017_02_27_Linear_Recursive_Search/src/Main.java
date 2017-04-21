/*
 * Implementing Linear Search with Recursion
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */


import java.util.*;

public class Main {
    
    
static final int[] INT_ARRAY = {3452, 8742, 5678, 7097, 8888, 9999, 1111, 8287, 1098, 3847};



    public static void main(String[] args) {
        
        System.out.println("For this exercise, we will check through the following array:\n");
        System.out.println("{3452, 8742, 5678, 7097, 8888, 9999, 1111, 8287, 1098, 3847}\n");
        System.out.println("Please enter a number to search in the array.");
        System.out.println("If it is present, the binary will be returned.  Otherwise, the number will be reversed.\n");
        System.out.println("Enter a number: ");
        Scanner input = new Scanner(System.in);

        int test = input.nextInt();
        if (search(test,0)){     
            System.out.println("Number found!");
            System.out.println("Printing the binary form...\n");
            printBinary(test);
            System.out.println();
        }
        else{
            System.out.println("Number not found!");
            System.out.println("Printing the reverse digits in reverse...\n");
            System.out.println(reverse(test));
            System.out.println();
        }

        
    }
        
    static boolean search (int num, int index){
        boolean result = false;
        int newindex;
        
        
        if(num == INT_ARRAY[index]){
            System.out.printf("Found in index %d! Value is %d\n\n", index, num);
            result = true;
        }
        else if(index < INT_ARRAY.length-1){
            System.out.printf("Checking index %d: Searching for %d. Value found is %d\n", index, num, INT_ARRAY[index]);
            newindex = index + 1;
            result = search(num, newindex);
        }
        return result;
    }
    
    static void printBinary(int num){
        int remainder;
        
        remainder = num % 2;
        if(num == 0 || num == 1)
            System.out.print(num);
        else{
            num = num / 2;
            printBinary(num);
            System.out.print(remainder);
        }
        
    }
    
    static String reverse(int num){
        String buffer;
        int remainder;
        
        if(num < 10 && num >= 0)
            return Integer.toString(num);
        else{
        remainder = num % 10;
        num = num / 10;
        buffer = reverse(num);
        }
        
        buffer = String.format("%d%s", remainder, buffer);
        return buffer;
    }
    
}
