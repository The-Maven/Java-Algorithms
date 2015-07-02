import java.util.*;
import java.io.*;

// Much of this code belongs to Dr. Ayorkoh Korsah of Ashesi University


public class Runtimes{
  public static void main(String[] args){
    int numRuns = 10;
    
    // Loop runtime experiment
    int[] loopRun = {2000000, 4000000, 6000000, 8000000, 10000000, 12000000, 14000000, 16000000, 18000000, 20000000};
    timeRandLoop(loopRun, numRuns, "loop.txt", true);
    
  }
    
    
    public static void timeRandLoop(int[] ns, int numRuns,
                                    String fileName,
                                    boolean display){
      Random rGenerator = new Random();
      int n;
      long startTime, endTime;
      
      // array to hold the average time for each N
      long[] avgTimes = new long[ns.length];
      //array to repeat each N by the number of runs
      int[] repNs = new int[ns.length*numRuns];
      //array to hold the time for each run
      long[] times = new long[repNs.length];
      
      // Fill the repNs array
      for (int i=0; i<ns.length; i++){
        for (int r=0; r<numRuns; r++){
          int ind = i*numRuns+r;
          repNs[ind] = ns[i];
        }
      }
      
      // For each run, conduct the runs of the experiment
      for (int i=0; i<ns.length; i++){
        n = ns[i];
        System.out.println("n = " + n);
        
        avgTimes[i] = 0;  // initialize the average time
        // Do the various runs for this value of n
        for (int r=0; r<numRuns; r++){
          int ind = i*numRuns+r;
          
          // measure the amount of time required for linear search
          // of the unsorted array
          System.out.print("Running loops ... ");
          startTime = System.nanoTime();
          runTime1(n);
          endTime = System.nanoTime();
          
          // record the runtime
          times[ind] = (endTime - startTime);
          avgTimes[i] += times[ind];
          System.out.println("Done!");
        }
        
        // compute the average time for this value of n
        avgTimes[i] /= numRuns;
      }
      
      // write the individual and averages results to a file
      writeTimesToFile(fileName, repNs, times);
      writeTimesToFile("avg_"+fileName, ns, avgTimes);
      
      // Display the data on the screen
      if (display){
        System.out.println("Individual runtimes");
        printTimes(new PrintWriter(System.out, true), repNs, times);
        System.out.println("Averages");
        printTimes(new PrintWriter(System.out, true), ns, avgTimes);
      }
    }
    
    
    public static void runTime1(int n){
      int sum = 0;
      for(int i = 0; i < n; i++){
        sum++;
      }
    }
    public static void runTime2(int n){
      int sum = 0;
      for ( int i = 0; i  < n; i++){
        for ( int j = 0;  j < n; j++){
          sum++;
        }
      }
    }
    public static void runTime3(int n){
      int sum = 0;
      for ( int i = 0; i < n; i++){
        for ( int j = 0; j < n*n; j++){
          sum++;
        }
      }  
    }
    public static void runTime4(int n){
      int sum = 0;
      for ( int i = 0; i < n; i++){
        for ( int j = 0; j < i; j++){
          sum++;
        }
      }
    }
    
    public static void writeTimesToFile(String fileName, int[] ns, long[] times){
      // Write the data to a file.
      File file = new File(fileName);
      try {
        PrintWriter fileOutput = new PrintWriter(file);
        printTimes(fileOutput, ns, times);
        fileOutput.close();
      }
      catch (FileNotFoundException e){
        System.err.println("Could not write the runtimes to file: " + e.toString());
      }
    }
    
    
    
    public static void printTimes(PrintWriter output, int[] n, 
                                  long[] times)
    {
      // First, print headers for the data
      output.printf("%10s %10s \n", "n", "time");
      for (int i=0; i<n.length; i++){
        // print n
        output.printf("%10d ", n[i]);
        //Display the average times for linear and binary search respectively
        output.printf("%10d \n", times[i]);
      }
    }
  }
 





