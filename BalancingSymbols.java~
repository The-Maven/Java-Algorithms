import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class checks that all symbols in the Java language are properly balanced.
 * This basic version assumes that relevant symbols are separated from other 
 * characters by a space.  E.g. "This is ( valid ) ", but "This is (not valid)"
 * 
 * Secondly, although it indicates when there is an error, it does not give an
 * estimate of the line number of the error.
 * 
 * Lastly, it does not ignore comment text, but makes sure that symbols are 
 * properly balanced within comments too, which may not necessarily be desired.
 **/

public class BalancingSymbols {
 
  // These are the symbols that we are going to balance
  public static final String[] OPENING_SYMBOLS = {"/*", "(", "[", "{", "<"};
  public static final String[] CLOSING_SYMBOLS = {"*/", ")", "]", "}", ">"};

  public static void main(String[] args) {
    // We are going to read and check for balanced symbols in the file
    // "MyTestFile.java"
    String fileName = "MyTestFile.java";
    Stack<String> symbolStack = new Stack<String>();
    
    File testFile = new File(fileName);
    Scanner fileInput = null;
    
    // open the file for reading
    try {
      fileInput = new Scanner(testFile);
    }
    catch(FileNotFoundException e){
      System.out.println("Could not open file: " + testFile);
      System.exit(0);
    }
    
    String symbol, matchingSymbol;
    int index;
    boolean foundError = false;
    
    // Read the file, putting opening symbols on the stack,
    // and popping them from the stack when the corresponding
    // closing symbol is found.
    while (fileInput.hasNext() && !foundError){
      symbol = fileInput.next();
      
      if (find(symbol, OPENING_SYMBOLS) != -1){
        // this is an opening symbol, push it onto the stack
        symbolStack.push(symbol);

        // print out the symbol, just so we have a visual indication
        // of what is going on
        System.out.print(symbol + " "); 
      }
      
      else {
        // it is not an opening symbol, so check if it is a 
        // closing symbol
        index = find(symbol, CLOSING_SYMBOLS);
        
        if (index != -1){
          // this is a closing symbol, so we will make sure that the 
          // corresponding opening symbol is at the top of the stack
          
          if (symbolStack.isEmpty()){
            // if the stack is empty, there's an error
            foundError = true;
            System.out.println("Syntax error: extra symbol: " + symbol);            
          }
          else {
            // get the symbol from the top of the stack, and make sure
            // it matches the closing symbol we have read
            matchingSymbol = symbolStack.pop();
            if (!matchingSymbol.equals(OPENING_SYMBOLS[index])){
              foundError = true;
              System.out.println("Syntax error: unmatched " + 
                                 matchingSymbol + ", found " +
                                 symbol);
            }
            else {
              // print out the symbol, just so we have a visual indication
              // of what is going on
              System.out.print(symbol + " ");          
            }
          }
        }
      }
    }
    System.out.println();

    // if the stack is not empty when we've finished reading, this is a problem
    if (!foundError && !symbolStack.isEmpty()){
      foundError = true;
      System.out.println("Syntax error: unmatched " +
                         symbolStack.top() + ". File ended.");
    }
    
    // if there hasn't been an error, we can report success.
    if (!foundError){
      System.out.println("All symbols balanced!");
    }

  }
  
  /**
   * This is a helper method, implementing sequential search to search
   * for a given string in an array.
   */
  private static int find(String value, String[] array){
    for (int i=0; i<array.length; i++){
      if (value.equals(array[i]))
        return i;
    }
    return -1;
  }
}