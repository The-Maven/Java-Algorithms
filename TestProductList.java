import java.io.*;
import java.util.*;

public class TestProductList
{
  
  public static void main (String []args) throws IOException {
    Product p1 = new Product("biscuit", 70);
    ProductList s1 = new ProductList();
    //System.out.println(p1.getPrice());
    s1.addProduct("blue", 23);
    s1.addProduct("happy", 12);
    s1.addProduct("blue", 50);
    s1.addProduct("blue", 78);
    
    System.out.println(s1.getNumProducts());
    //s1.removeProductAt(1);
    //System.out.println(s1.getNumProducts());
    System.out.println(s1.getProductAt(2));                //get product
    System.out.println(s1.findProductIndex("blue"));       //get index
    System.out.println(s1.findProduct("blue"));            //reference to product
    System.out.println(s1.findProductIndicies("blue"));  //find product indicies
    //s1.arrayTest();
    s1.anArray();
    s1.findProductIndicies();                     //find indicies of a given product name
    System.out.println(s1.getCount());           // get count of product occurrences determined above
    s1.removeProductAt(0);                      // remove product at index 0
    System.out.println(s1.getNumProducts());   //get new product count
    
    s1.readProductsFromFile();
  }
  
  
}