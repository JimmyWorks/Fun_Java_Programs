/*
 * 3x3 Matrix Multiplication
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */
package cs2336_hw3;

import java.util.InputMismatchException;
import java.util.*;

public class CS2336_HW3 {

    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("===== Jimmy's 3x3 Matrix Multiplier =====\n\n");
        
        System.out.println("Please enter 9 integers for the first matrix, A, in the following order: \n");
        System.out.printf(" [ %5s %10s %10s    ]\n", "a1", "a2", "a3");
        System.out.printf(" [ %5s %10s %10s    ]\n", "a4", "a5", "a6");
        System.out.printf(" [ %5s %10s %10s    ]\n\n", "a7", "a8", "a9");
        
        int [][] arrayA = new int[3][3];
        fetchArray(input, arrayA);
        
        System.out.println("Please enter 9 integers for the first matrix, B, in the following order: \n");
        System.out.printf(" [ %5s %10s %10s    ]\n", "b1", "b2", "b3");
        System.out.printf(" [ %5s %10s %10s    ]\n", "b4", "b5", "b6");
        System.out.printf(" [ %5s %10s %10s    ]\n\n", "b7", "b8", "b9");
        
        int [][] arrayB = new int[3][3];
        fetchArray(input, arrayB);
        
        System.out.printf(" [ %5d %10d %10d    ]       [ %5d %10d %10d    ] \n", arrayA[0][0], arrayA[0][1], arrayA[0][2], arrayB[0][0], arrayB[0][1], arrayB[0][2]);
        System.out.printf(" [ %5d %10d %10d    ]   x   [ %5d %10d %10d    ]   =\n", arrayA[1][0], arrayA[1][1], arrayA[1][2], arrayB[1][0], arrayB[1][1], arrayB[1][2]);
        System.out.printf(" [ %5d %10d %10d    ]       [ %5d %10d %10d    ] \n\n",  arrayA[2][0], arrayA[2][1], arrayA[2][2], arrayB[2][0], arrayB[2][1], arrayB[2][2]);
        
        int [][] arrayC = new int[3][3];
        int sum = 0;       
        for(int i = 0; i < arrayA.length; i++){ //row, i
            for(int j = 0; j < arrayB[0].length; j++){ //column

                for(int k = 0; k < arrayB.length; k++) //changing row in matrix B, k
                    sum += (arrayA[i][k] * arrayB[k][j]);
                
                arrayC[i][j] = sum;
                sum = 0;
            }
        }
        
        System.out.printf(" [ %5d %10d %10d    ]\n", arrayC[0][0], arrayC[0][1], arrayC[0][2]);
        System.out.printf(" [ %5d %10d %10d    ]\n", arrayC[1][0], arrayC[1][1], arrayC[1][2]);
        System.out.printf(" [ %5d %10d %10d    ]\n\n", arrayC[2][0], arrayC[2][1], arrayC[2][2]);
        
        }
    
    public static void fetchArray(Scanner input, int[][] array){
        
        boolean valid = false;
        while(!valid){
            try{
                
                //Collect user input into the array
                for(int i = 0; i < array.length; i++){
                    for(int j = 0; j < array[i].length; j++){
                        array[i][j] = input.nextInt();
                    }
                    input.nextLine();
                    if(i == array.length-1)
                        valid = true;
                }
                
                
                
            }catch(ClassCastException cce){
                    System.out.println("\nYour input is invalid, please try again\n\n");            
            }catch(InputMismatchException ime){
                    System.out.println("\nYour input is invalid, please try again\n\n");            
            }catch(ArrayIndexOutOfBoundsException aioobe){
                System.out.println("\nYour input is invalid, please try again (arrayindex)\n\n");
                
            input.nextLine();
            System.out.print("\n\n========================================================\n\n\n");
            }
        }
    }
}
