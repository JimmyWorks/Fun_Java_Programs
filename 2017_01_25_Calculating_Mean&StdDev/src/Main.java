/*
 * Calculating the Mean and Standard Deviation of a Set of Numbers
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */



import java.util.*;

public class Main {

      public static void main(String[] args) {
      int num_of_values = 0;
      Scanner input = new Scanner(System.in);
      
      //Simple Welcome Screen
      System.out.println("=================================================================");
      System.out.println("Welcome to Jimmy's Quick Mean and Standard Deviation Calculator!");
      System.out.println("=================================================================\n\n");
      
      //Ask for number of values to calculate for the average and std dev
      System.out.println("How many numbers do you want to compute?");
      num_of_values = input.nextInt();
      
      //Create array of floating-point numbers of size specified by user to hold the numbers
      float []numbers = new float[num_of_values];    
      
      //Ask user to enter each number
      for(int i=0; i < num_of_values; i++){
          System.out.println("Enter the value for number " + (i+1) + ":");
          numbers[i] = input.nextFloat();
          //System.out.println("DEBUG: Stored " + numbers[i] + " in " + i + " element."); //Debug line for checks
      }
      //Call the mean function and standard deviation function while printing results to the console
      System.out.printf("\n\nThe mean for the %d numbers entered is: %.4f\n", num_of_values, average(numbers, num_of_values));
      System.out.printf("The standard deviation for the %d numbers entered is: %.4f\n", num_of_values, std_dev(numbers, num_of_values));
    }
    
      public static float average(float[] values, int arraySize){
          float answer = 0;
          
          for(int i = 0; i < arraySize; i++){
                answer = answer + values[i];
          }
         //System.out.println("DEBUG: Sum of all numbers is :" + answer);
          answer = answer/arraySize;
          
          return answer;
      }
      
      public static float std_dev(float[] values, int arraySize){
          float answer = 0;
          float squared_sum = 0;
          float sum_squared = 0;
          
          for(int i = 0; i < arraySize; i++){
                squared_sum = squared_sum + values[i]*values[i];
          }
          for(int i = 0; i < arraySize; i++){
                sum_squared = sum_squared + values[i];
          }
          sum_squared = sum_squared * sum_squared;
          
          //System.out.println("DEBUG: Value of sum of squared elements: " + sum_squared);
          //System.out.println("DEBUG: Value of summation, squared: " + squared_sum);
          answer = (float) Math.sqrt((squared_sum - (sum_squared/arraySize))/(arraySize-1));
          
          return answer;
      }
      
      
}
