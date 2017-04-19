/*
 * Exercise: Converter for Infix Notation to Postfix Notation
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */


import Stack.*;
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        File infile = new File("text.txt");
        
        Scanner myScanner = new Scanner(infile);
        PrintWriter printer = new PrintWriter("output.txt");
        
        while(myScanner.hasNext()){
        String buffer = myScanner.nextLine();
        String postfix = new String();
        System.out.printf("Imported Infix Expression: %s\n", buffer);
        char x = 0;
        
        CustomStack myStack = new CustomStack();
        
        for(int i = 0; i < buffer.length(); i++){
            x = buffer.charAt(i);
            //System.out.printf("Processing index %d of string with char: %c\n", i, x);
            if(x != ' '){
                switch(x){
                    case '+':
                    case '-': // If adding or subtracting, pop and append everything in stack
                        while(  myStack.getTop() != '\u0000' &&(
                                myStack.getTop() == '+' ||
                                myStack.getTop() == '-' ||
                                myStack.getTop() == '*' ||
                                myStack.getTop() == '/' ||
                                myStack.getTop() == '^')){
                            postfix = postfix.concat(Character.toString(myStack.getTop()));
                            myStack.pop();
                            System.out.flush();
                        }
                        myStack.push(new Node(x));                        
                        //System.out.printf("Postfix is currently %s\n", postfix);
                        //System.out.flush();
                        break;
                    case '*':
                    case '/':   // If multiplying or dividing, pop and append everything except '+' and '-'
                        while(  myStack.getTop() != '\u0000' &&(
                                myStack.getTop() == '*' ||
                                myStack.getTop() == '/' ||
                                myStack.getTop() == '^')){
                            postfix = postfix.concat(Character.toString(myStack.getTop()));
                            myStack.pop();    
                        }
                        myStack.push(new Node(x));                        
                        //System.out.printf("Postfix is currently %s\n", postfix);
                        //System.out.flush();
                        break;
                    case '^':   // If power operator, only pop other power operators
                        while(  myStack.getTop() != '\u0000' &&
                                myStack.getTop() == '^'){
                            postfix = postfix.concat(Character.toString(myStack.getTop()));
                            myStack.pop();
                        }
                        myStack.push(new Node(x));                        
                        //System.out.printf("Postfix is currently %s\n", postfix);
                        //System.out.flush();
                        break;
                    case '(':   // If left parenthesis, push onto stack
                        myStack.push(new Node(x));                        
                        break;
                    case ')':   // If right parenthesis
                        while(  myStack.getTop() != '\u0000' &&
                                myStack.getTop() != '('){
                            // Pop everything till the left parenthesis.  Append everything except the left parenthesis
                            if(myStack.getTop() != '(')
                                postfix = postfix.concat(Character.toString(myStack.getTop()));
                            myStack.pop();   
                        }
                        if(myStack.getTop() == '\u0000')
                            System.out.println("Error: Could not find left parenthesis.");
                        //System.out.printf("Postfix is currently %s\n", postfix);
                        //System.out.flush();
                        break;
                    default: // Else, character is an operand and appended to postfix
                        postfix = postfix.concat(Character.toString(x));
                        //System.out.printf("Postfix is currently %s\n", postfix);
                        //System.out.flush();
                }
            }
        }
        //  Once done processing line, pop remaining operators in the stack
        while(myStack.getTop() != '\u0000'){
            if(myStack.getTop() != '(')
                postfix = postfix.concat(Character.toString(myStack.getTop()));
            myStack.pop();
            //System.out.printf("Postfix is currently %s\n", postfix);
            //System.out.flush();
        }
        //  Export the postfix expression to the specified file
        System.out.printf("Exported Postfix Expression: %s\n\n", postfix);       
        printer.print(postfix);
        printer.println();
        printer.flush();
        
        }
        
        // End program
        System.out.println("\n\n====================================================\n\n");
        System.out.println("Thank you for visiting!\n\n");
        System.out.println("For all questions, please contact me at:");
        System.out.println("Jimmy@JimmyWorks.net\n\n");
        System.out.println("====================================================");
        
        System.exit(0);
    }
    
}
