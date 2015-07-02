
import java.util.*;
import java.io.*;

public class MeasureRuntimes {
  
  public static void main(String[] args){
    int numRuns = 10;

    // Linear search experiment
    int[] nsForLinear = {2000000, 4000000, 6000000, 8000000, 10000000};
    timeRandLinearSearches(nsForLinear, numRuns, "linear.txt", true, true);

    // Binary search experiment
    int[] nsForBinary = {100000, 1000000, 2000000, 4000000, 6000000, 8000000,
                         10000000, 20000000, 30000000, 40000000, 50000000};
    timeRandBinarySearches(nsForBinary, numRuns, "binary.txt", true, true);
  }
  
  // Runs experiments with linear searches -- measures the time to 
  // conduct a linear search for various values of N
  public static void timeRandLinearSearches(int[] ns, int numRuns,
                                            String fileName,
                                            boolean worstCase,
                                            boolean display){
    Random rGenerator = new Random();
    int n, numToFind;
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

    // For each n, run multiple runs of the experiment
    for (int i=0; i<ns.length; i++){
      n = ns[i];
      System.out.println("n = " + n);
     
      avgTimes[i] = 0;    // initialize the average time
      // do the various runs
      for (int r=0; r<numRuns; r++){
        int ind = i*numRuns+r;
        
        // Create an array with n random items
        System.out.print("Creating random array ... ");
        int[] randomArray = new int[n];
        for (int j=0; j<n; j++){
          randomArray[j] = rGenerator.nextInt(n);
        }
        
        // If we want to measure the worst-case runtime, make sure
        // that the last item is unique, and search for that item.
        // Otherwise, just search for a random item.
        if (worstCase){
          randomArray[n-1]=n+1; // n+1 isn't found anywhere in the array.
          numToFind = randomArray[n-1];
        }        
        else
          numToFind = rGenerator.nextInt(n);
      
        // measure the amount of time required for linear search
        // of the unsorted array
        System.out.print("Doing linear search ... ");
        startTime = System.nanoTime();
        linearSearch(randomArray, numToFind);
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

  // Runs experiments with binary searches -- measures the time to 
  // conduct a binary search for various values of N
  public static void timeRandBinarySearches(int[] ns, int numRuns,
                                            String fileName, boolean worstCase,
                                            boolean display){
    Random rGenerator = new Random();
    int n, numToFind;
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
        
        // Create an array with n random items
        System.out.print("Creating random array ... ");
        int[] randomArray = new int[n];
        for (int j=0; j<n; j++){
          randomArray[j] = rGenerator.nextInt(n);
        }
        
        // Sort the array
        Arrays.sort(randomArray);
        
        // If we want to measure the worst-case runtime, make sure
        // that the last item is unique, and search for that item.
        // Otherwise, just search for a random item.
        if (worstCase){
          randomArray[n-1]=n+1; // n+1 isn't found anywhere in the array.
          numToFind = randomArray[n-1];
        }        
        else
          numToFind = rGenerator.nextInt(n);
      
        // measure the amount of time required for binary search
        // of the unsorted array
        System.out.print("Doing binary search ... ");
        startTime = System.nanoTime();
        binarySearch(randomArray, numToFind);
        endTime = System.nanoTime();
        
        // record the runtime
        times[ind] = (endTime - startTime);
        avgTimes[i] += times[ind];
        System.out.println("Done!");
      }
      
      // compute the average time for this value of n
      avgTimes[i] /= numRuns;
    }
        
    // write the inidivual and average results to files
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
  
  public static boolean linearSearch(int[] array, int numToFind) {
    for (int i=0; i<array.length; i++){
      if (array[i] == numToFind)
        return true;
    }
    
    return false;
  }
  
  public static boolean binarySearch(int[] array, int numToFind){
    int startIndex = 0, endIndex = array.length-1;
    int midIndex;
    
    while (endIndex >= startIndex) {
      midIndex = (startIndex + endIndex)/2;
      if (array[midIndex] == numToFind)
        return true;
      else if (array[midIndex] < numToFind)
        startIndex = midIndex + 1;
      else 
        endIndex = midIndex - 1;
    }
    
    return false;
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