
/*
 * Exercise: File Data Import and Formatted Report Print for Employee Payment Schedule
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */


import java.util.*;
public class Main {


    public static void main(String[] args) throws Exception{
        java.io.File myFile = new java.io.File("payroll.txt");
        
        Scanner input = new Scanner(myFile);
        
        while(input.hasNext()){
            String employee = input.next();
            int weeklyHours = input.nextInt();
            double payrate = input.nextDouble();
            double federalTaxWithholding = input.nextDouble();
            double stateTaxWithholding = input.nextDouble();
            
            System.out.println("Statement of Earnings, Taxes and Deductions");
            System.out.println("============================================");
            System.out.println("Employee: " + employee);
            System.out.println("============================================");
            System.out.printf("%-20s %-10s %-10s %-10s\n", "Description", "Hours", "Rate", "Earnings");
            System.out.printf("%-20s %-10d $%-10.2f $%-10.2f\n\n", "Base Salary", weeklyHours, payrate, weeklyHours*payrate);
            System.out.printf("Taxes\n\n");
            System.out.printf("%-20s $%-10.2f\n", "Fed Withholding" , weeklyHours*payrate*federalTaxWithholding); 
            System.out.printf("%-20s $%-10.2f\n\n\n", "State Withholding", weeklyHours*payrate*stateTaxWithholding);

        }
    }
    
}
