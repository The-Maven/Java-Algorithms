import java.util.ArrayList;
public class List{
  public static void main(String args[]){
    ArrayList<Product> list = new ArrayList<Product>();
    
    Product water = new Product("water", 1);
    Product sugar = new Product("sugar", 2);
    Product milk = new Product("milk", 3);
    Product toffee = new Product("toffee", 4);
    Product soup = new Product("soup", 5);
    
    Product nothing = new Product("nothing", 0);
    
    list.add(water);
    list.add(sugar);
    list.add(milk);
    list.add(toffee);
    list.add(soup);
    
    //arraylist method to add products into the list
    list.add(water);  
    list.add(sugar);  
    list.add(milk);
    list.add(toffee);
    list.add(soup);
    
    //arraylist method to find the index of a product
    list.indexOf(water); 
    
    //method to check if a given item is in the array
    list.contains(milk);
    list.contains(nothing);
    
    
    //getting a particular index of a product
    Product getProduct = list.get(0);
    Product anothrProduct =list.get(1);
    
    //for loop to store all items in a variable
    for(int i=0;i<list.size();i++){
      String pItems = list.get(i).toString();
      System.out.println(pItems);
    }
    
    
    System.out.println();
    
    
    //displays the index of a particular product
    System.out.println("the index of water is " + list.indexOf(water)); 
    
    //displays  present in the list 
    System.out.println(list.contains(water));
    
    //displays at a given index
    System.out.println(list.get(1)); 
    
    //returns false if not in the list 
    System.out.println(list.contains(nothing)); 
    
    // remove a particular item  
    list.remove(water);
    
    //for loop to display after a particular item has been removed
    for(int i=0;i<list.size();i++){
      String j = list.get(i).toString();
      System.out.println(j);
    }
    
    
    
  }
}