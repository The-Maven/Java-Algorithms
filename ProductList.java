import java.io.*;
import java.util.*;

public class ProductList{
  private Product essentials[];
  private int numProducts;
  public static final int MAX_PRODUCTS = 100;
  Product aProduct;
  public int indexArray[];
  public int indexArray2[];
  public Product theArray[];
  public int noArray[] = new int[0];
  public int count = 0;
  public ProductList(){
    essentials = new Product[MAX_PRODUCTS];
  }
  
  public  void addProduct(String name, double price){               //method to add Product
    if (numProducts <= MAX_PRODUCTS)
      aProduct = new Product(name, price);
    essentials[numProducts] = aProduct;
    numProducts++;
  }
  
  /**public String toString(){
    return("Name: "  + p.getName() + "\nPrice: " + p.getPrice());
    }*/
  
  public int getNumProducts(){                                       //get number of Products
    return numProducts;
  }
  
  public String getProductAt(int index){                             // get product at a partcular index
    return essentials[index].getName();
  }
  
  public void removeProductAt(int index){                             //remove product at particular index      
    if(essentials[index] == null){
      essentials[index] = essentials[numProducts-1];
      essentials[numProducts-1] = null;
    }
    else if (essentials[index] != null){
      essentials[index] = null;
      essentials[index] = essentials[numProducts-1];
      essentials[numProducts-1] = null;
      numProducts--;
    }
  }
  
  public Product findProduct(String productName){                     //return reference to product with a given name
    for(int i = 0; i < numProducts; i++){
      if(essentials[i].getName().equals(productName))
        break;
      return essentials[i];
    }return null;
  }
  
  public int findProductIndex(String productName){                     //return index of a given product name
    for(int i = 0; i < numProducts; i++){
      if((essentials[i] != null) && (essentials[i].getName().equals(productName)))
        return i;
    }
    return -1;
  }
     public int[] findProductIndicies(String theName){                  //return the location of an array that holds occurences of an item
    indexArray = new int[4];
    for(int i = 0; i < numProducts; i++){
      if(essentials[i].getName().equals(theName)){
      indexArray[i] = i;
      count++;
      }
    }
    //indexArray2 = new int[count - 1];
    return indexArray;
  }
      public Product[] findProducts(String theName){                  //return the location of an array that holds occurences of an item
    theArray = new Product[4];
    for(int i = 0; i < numProducts; i++){
      if(essentials[i].getName().equals(theName)){
      theArray[i] = essentials[i];
      count++;
      }
    }
    //indexArray2 = new int[count - 1];
    return theArray;
  }
  
  public void anArray(){                                                 //attempt to restrict size of array to number of occurrences
    indexArray2 = new int[count];
    for(int i = 0; i < count; i++){
      indexArray2[i] = indexArray[i];
    }
  }
      
  public void arrayTest(){                                                //displaying the contents of indexArray
    for(int i = 1; i < indexArray.length; i++){
      System.out.println(indexArray[i]);
    }
  }
  
  public void findProductIndicies(){                                       //displaying contents of final array
    for(int i = 0; i < indexArray2.length; i++){
      System.out.println(indexArray2[i]);
    }
  }
  
  public int getCount(){                                                   // getting count of occurrences of a particular product
    return count;
  }
  
  
  public void read() throws IOException{           //alternative read file method
    List<String> lines = new ArrayList<String>();
    BufferedReader reader = null;
    try
    {
      reader = new BufferedReader(new FileReader("file.txt"));
      String line = null;
      while((line = reader.readLine()) != null){
        lines.add(line);
      }
    }finally{
      reader.close();
    }
  }
  
  public void readProductsFromFile(){      //read from file
    try
    {
    Scanner input = new Scanner(new File("file.txt"));
    String[] items = new String[3];
    int i = 0;
    while((input.hasNextLine() && i < items.length)){
      items[i] = input.nextLine();
      i++;
    }
    }catch(Exception e){
      System.out.println("file not found");
  }
}
}
