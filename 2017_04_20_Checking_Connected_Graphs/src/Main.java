/*
 * Exploring Graphs and Connectivity
 * Author: Jimmy Nguyen
 * Contact me: Jimmy@JimmyWorks.net
 */

import java.io.*;
import java.util.*;

public class Main {
    static final String CONNECTED = "connected.txt";
    static final String NOT_CONNECTED = "notconnected.txt";
    
    public static void main(String[] args) throws FileNotFoundException {
        File connectedFile = new File(CONNECTED);
        File unconnectedFile = new File(NOT_CONNECTED);
        
        System.out.println("Welcome to Jimmy's Program for Checking Undirected Graphs for Connectivity!\n");
        System.out.println("===========================================================================");
        
        Scanner userInput = new Scanner(System.in);
        
        while(!connectedFile.exists() || connectedFile.isDirectory()){
            System.out.printf("Your file name for the connected graph \"%s\" was not found.", connectedFile.getName());
            System.out.println("Please specify the correct file name for the connected graph:");
            String filename = userInput.nextLine();
            connectedFile = new File(filename);
        }
        while(!unconnectedFile.exists() || unconnectedFile.isDirectory()){
            System.out.printf("Your file name for the connected graph \"%s\" was not found.", unconnectedFile.getName());
            System.out.println("Please specify the correct file name for the connected graph:");
            String filename = userInput.nextLine();
            unconnectedFile = new File(filename);
        }
        
        
        Scanner connectedScan = new Scanner(connectedFile);
        Scanner unconnectedScan = new Scanner(unconnectedFile);
        
        // First Testing the Connected Graph for Connectivity
        System.out.print("\n\n=============================================\n\n");        
        System.out.print("First let's check a Graph that is Connected.");
        System.out.print("\n\n=============================================\n\n"); 
        int size = 0;
        try{
        size = Integer.parseInt(connectedScan.nextLine());
        }catch(Exception error){
            badFile();
        }
        int[][] adjacencyMatrix = new int[size][size];
        //System.out.println("New adjacency matrix created...");
        //printArray(adjacencyMatrix, size, size);
        while(connectedScan.hasNext()){
            String[] buffer = connectedScan.nextLine().split(" ");
            int[] bufferInt = new int[buffer.length];
            for(int i = 0; i < buffer.length; i++){
                bufferInt[i] = Integer.parseInt(buffer[i]); 
            }
            for(int i = 1; i < bufferInt.length; i++){
                adjacencyMatrix[bufferInt[0]][bufferInt[i]] = 1;
            }
        }
        System.out.println("Adjacency matrix loaded....");
        printArray(adjacencyMatrix, size, size);
        
        Boolean connected = false;
        
        for(int i = 0; i < adjacencyMatrix.length; i++){
            System.out.printf("\n\nChecking vertex %d for connectivity...\n", i);
            if(!isConnected(adjacencyMatrix, i, adjacencyMatrix.length))
                break;
            if(i == adjacencyMatrix.length-1)
                connected = true;  
        }
        
        if(connected)
            System.out.println("\n\nRESULT: The graph IS connected.");
        else
            System.out.println("\n\nRESULT: The graph is NOT connected.");
        
        // Then, Testing the Unconnected Graph for Connectivity
        System.out.print("\n\n=============================================\n\n");        
        System.out.print("Now, let's check a Graph that is NOT Connected.");
        System.out.print("\n\n=============================================\n\n"); 
        
        try{
        size = Integer.parseInt(unconnectedScan.nextLine());
        }catch(Exception error){
            badFile();
        }
        adjacencyMatrix = new int[size][size];
        //System.out.println("New adjacency matrix created...");
        //printArray(adjacencyMatrix, size, size);
        while(unconnectedScan.hasNext()){
            String[] buffer = unconnectedScan.nextLine().split(" ");
            int[] bufferInt = new int[buffer.length];
            for(int i = 0; i < buffer.length; i++){
                bufferInt[i] = Integer.parseInt(buffer[i]); 
            }
            for(int i = 1; i < bufferInt.length; i++){
                adjacencyMatrix[bufferInt[0]][bufferInt[i]] = 1;
            }
        }
        System.out.println("Adjacency matrix loaded....");
        printArray(adjacencyMatrix, size, size);
        
        connected = false;
        
        for(int i = 0; i < adjacencyMatrix.length; i++){
            System.out.printf("\n\nChecking vertex %d for connectivity...\n", i);
            if(!isConnected(adjacencyMatrix, i, adjacencyMatrix.length))
                break;
            if(i == adjacencyMatrix.length-1)
                connected = true;  
        }
        
        if(connected)
            System.out.println("\n\nRESULT: The graph IS connected.");
        else
            System.out.println("\n\nRESULT: The graph is NOT connected.");
        
    }
    //For handling bad file names
    static void badFile(){
        System.out.println("File has errors.");
        System.exit(1);
    }
    //For printing the 2-D array
    static void printArray(int[][] array, int rows, int cols){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }
    //Sets up the connectivity array which will determine if this vertex is connected to everything else
    static Boolean isConnected(int[][] matrix, int vertex, int arrayLength){
        int[] checkedVertices = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            checkedVertices[i] = matrix[vertex][i];
        }
        System.out.printf("Vertices adjacent to the checked vertex, %d, represented below:\n", vertex);
        System.out.println(Arrays.toString(checkedVertices));
        
        for(int i = 0; i < checkedVertices.length; i++){
            if(checkedVertices[i] == 1)
                checkedVertices = isConnectedHelper(matrix, i, arrayLength, checkedVertices);
        }
        System.out.println("After a depth-first search,");
        System.out.printf("Vertices connected to the checked vertex, %d, represented below:\n", vertex);
        System.out.println(Arrays.toString(checkedVertices));
        int connections = 0;
        for(int i = 0; i < arrayLength; i++){
            if(checkedVertices[i] == 1)
                connections++;
        }
        
        if(connections == arrayLength)
            return true;
        else
            return false;
        
        
    }
    //Recursively updates the connectivity array, depth-first, until hitting a leaf or cycle
    static int[] isConnectedHelper(int[][] matrix, int vertex, int arrayLength, int[] checkedVertices){
        for(int i = 0; i < arrayLength; i++){
            if(matrix[vertex][i] == 1){
                if(checkedVertices[i]==0){
                    checkedVertices[i] = 1;
                    checkedVertices = isConnectedHelper(matrix, i, arrayLength, checkedVertices);
                }
            }
        }
        return checkedVertices;
    }
    
    
}
