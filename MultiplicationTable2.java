
public class MultiplicationTable2 {
  
  private int[][] table;
  private int numRows;
  private int numColumns;
  
  public MultiplicationTable2(int nRows, int nColumns){
    numRows = nRows;
    numColumns = nColumns;
    
    // Create the multiplication table, one row at a time
    table = new int[numRows][];
    for (int i=0; i<numRows; i++)
      table[i] = new int[numColumns];
    
    // populate the multiplication table
    for (int i=0; i<numRows; i++){
      for (int j=0; j<numColumns; j++){
        table[i][j] = i*j;
      }
    }
  }
  
  public int lookUp(int x, int y) {
    if (x < numRows && y < numColumns)
      return table[x][y];
    else
      return -1;
  }
  
  public void print() {
    // print the header of the columns, starting with a blank space
    System.out.print(" " + "\t");
    for (int i=0; i<numColumns; i++)
      System.out.print(i + "\t");
    System.out.println();
    
    for (int i=0; i<numRows; i++){
      // print the row header
      System.out.print(i + "\t");
      
      // print the contents of the row
      for (int j=0; j<numColumns; j++)
        System.out.print(table[i][j] + "\t");
      System.out.println();
    }
  }
  
}