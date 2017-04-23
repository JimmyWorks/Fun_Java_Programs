/*
 * Exploring Execution Time Complexity
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

// Using some algorithms from Daniel Liang's Introduction to Java Programming for
// the comparisons in this program, we explore how routine's that perform the same
// task can have different time complexities and execution growth rates.  The code
// below will run three different routines that searches for all of the prime numbers
// with six different upper bounds.  The execution time for each of these sub-routines
// are then compared in a graph.

import java.util.*;

public class Main {
    
    static final int NUMBER_PER_LINE = 10; // Display 10 per line
    static final int[] TEST_VALUES = {  800, 1000, 1200, 
                                       1400, 1600, 1800};
    static final String[] TEST_NAME = { "Listing 22.5 ",
                                        "Listing 22.6 ",
                                        "Listing 22.7 "};
        
    public static void main(String[] args) {
        int[][] results = new int[3][6];
        Boolean printON = true;
        Scanner input = new Scanner(System.in);
        System.out.println("==========================================\n");
        System.out.println("  Welcome to Jimmy's Algorithm Analysis!  ");
        System.out.println("\n==========================================\n");
        System.out.println("This program will run three separate routines that all");
        System.out.println("find each prime number up to an upper bound.");
        System.out.println("The resulting execution times will be displayed at the end.\n");
        System.out.println("Please select if you would like to see the values printed to the screen.");
        System.out.println("Warning: The default upper bounds can take up to 5-minutes to complete.");        
        //Let User Decide if Print to Console is Required
        System.out.println("Do you want to print prime numbers to the console? Y/N");
        String userInput = input.next();
        
        if("Y".equals(userInput) || "y".equals(userInput))
            printON = true;
        else
            printON = false; 
      
        Math.sqrt(2);
        System.out.println("Processing...\n");
        
        //Testing Routine 1: Listing 22.5
        for(int i = 0; i < TEST_VALUES.length; i++){
            long start_time = System.currentTimeMillis();  // Constant time complexity
            listing22_5(TEST_VALUES[i], printON);    //execute sub-routine
            long end_time = System.currentTimeMillis();  // Constant time complexity
            results[0][i] = (int)(end_time-start_time);
            if(printON)
                System.out.println();
        }
        //Testing Routine 2: Listing 22.6
        for(int i = 0; i < TEST_VALUES.length; i++){
            long start_time = System.currentTimeMillis();  // Constant time complexity
            listing22_6(TEST_VALUES[i], printON);    //execute sub-routine
            long end_time = System.currentTimeMillis();  // Constant time complexity
            results[1][i] = (int)(end_time-start_time);
            if(printON)
                System.out.println();
        }
        //Testing Routine 3: Listing 22.7
        for(int i = 0; i < TEST_VALUES.length; i++){
            long start_time = System.currentTimeMillis();  // Constant time complexity
            listing22_7(TEST_VALUES[i], printON);    //execute sub-routine
            long end_time = System.currentTimeMillis();  // Constant time complexity
            results[2][i] = (int)(end_time-start_time);
            if(printON)
                System.out.println();
        }
        //Print the Table of Results
        System.out.println("\n\n");
        System.out.println("             Max Prime Numbers and Respective Execution Time in Milliseconds:");
        System.out.print("Algorithms   ");
        for(int i: TEST_VALUES)    
            System.out.printf("%10d ", i);
        System.out.println();
        for(int i = 0; i < 3; i++){
            System.out.print(TEST_NAME[i]);
            for(int j = 0; j < 6; j++){
                System.out.printf("%10d ", results[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void listing22_5(int n, Boolean printStatus){
        int count = 0;  
        int number = 2; 

        if(printStatus)
            System.out.println("The prime numbers are");  

        while (number <= n) {   // Time complexity: n
            boolean isPrime = true; 

            // Test if number is prime
            for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++){ // Time complexity: sqrt(n) (NESTED)
                if (number % divisor == 0) { 
                    isPrime = false; 
                    break; 
                }
            }
            
            // Print the prime number and increase the count
            if (isPrime){ 
                count++; 
                // Print the number and advance to the new line
                if (count % NUMBER_PER_LINE == 0){
                    if(printStatus)
                        System.out.printf("%10d\n", number);
                }
                else{
                    if(printStatus)
                        System.out.printf("%10d", number);
                }
            }
            number++;
        }
        if(printStatus)
            System.out.println("\n" + count + " prime(s) less than or equal to " + n);
    } // Time complexity is O(n*sqrt(n))
    
    static void listing22_6(int n, Boolean printStatus){
        java.util.List<Integer> list = new java.util.ArrayList<>();

        int count = 0; 
        int number = 2; 
        int squareRoot = 1; 

        if(printStatus)
            System.out.println("The prime numbers are");

        // Repeatedly find prime numbers
        while (number <= n) { // Time complexity: n
            // Assume the number is prime
            boolean isPrime = true; 

            if (squareRoot * squareRoot < number) squareRoot++;

            // Test whether number is prime
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) { // Time complexity: sqrt(n)
                if (number % list.get(k) == 0) { // If true, not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                count++; 
                list.add(number);
                if (count % NUMBER_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    if(printStatus)
                        System.out.println(number);
                }
                else{
                    if(printStatus)
                        System.out.print(number + " ");
                }
            }
            number++;
        }

        if(printStatus)
            System.out.println("\n" + count + " prime(s) less than or equal to " + n);
    }// Time complexity is O(n)
  
    static void listing22_7(int n, Boolean printStatus){
        boolean[] primes = new boolean[n + 1]; 

        // Initialize primes[i] to true
        for (int i = 0; i < primes.length; i++) // Time complexity: n 
            primes[i] = true;
        
        for (int k = 2; k <= n / k; k++) {// Time complexity: n 
            if (primes[k]) {
                for (int i = k; i <= n / k; i++)
                    primes[k * i] = false; 
            }
        }
        
        if(printStatus)
            System.out.println("The prime numbers are");
        
        int count = 0; 
        // Print prime numbers
        for (int i = 2; i < primes.length; i++) {// Time complexity: n
            if (primes[i]) {
                count++;
                if (count % 10 == 0){
                    if(printStatus)
                        System.out.printf("%10d\n", i);
                }
                else{
                    if(printStatus)
                        System.out.printf("%10d", i);
                }
            }
        }

        if(printStatus)
            System.out.println("\n" + count + " prime(s) less than or equal to " + n);
    }// Time complexity is O(3n) = O(n)


}
