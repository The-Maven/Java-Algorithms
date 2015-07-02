import java.util.LinkedList;
public class LinkedProducts
{
  
  public static void main(String [] args){
    LinkedList<Product> ourList=new LinkedList<Product>();
    // creating the ourList
    Product product0 = new Product ("a", 1);
    Product product1 = new Product ("b", 2);
    Product product2 = new Product ("c" , 3);
    Product product3 = new Product ("d", 4);
    Product product4 = new Product("e",3.5);
    Product product5 = new Product("f", 6);
    Product product6 = new Product ("g", 4.99);
    Product product7 = new Product("h", 1.67);
    Product product8 = new Product ("i", 7.89);
    
    
    // putting things in the ourList
    ourList.addFirst(product0);
    ourList.addFirst(product1);
    ourList.addFirst(product2);
    ourList.addFirst(product3);
    ourList.addFirst(new Product ("x" , 8));
    ourList.addLast(product5);
    ourList.addLast(product6);
    ourList.addLast(product7);
    
    
    
    
    System.out.println("the number of items in the ourList is " + ourList.size());
    
    System.out.println("absolutely" + ourList.contains(product1) + " " + "that my ourList contains " + product1.getName());
    System.out.println(" " + ourList.contains(product0) + " that ourList contains " + product0.getName());
    System.out.println("I've got " + ourList.get(0).getName()+ ", " + ourList.get(0).getPrice() );
    System.out.println( " index of " + product2.getName()  + " is " + ourList.indexOf(product2));
    System.out.println("index of " + product1.getName() + " is  "  + ourList.indexOf(product1) + " "+ "which means that mango is not in the ourList");
    System.out.println("the first item is " + ourList.getFirst());
    System.out.println("the last item is " + ourList.getLast());
    
    ourList.remove(product4);  
    System.out.println(" it is " +  ourList.remove(product4)  + " "+ "that " + product4.getName() +" is removed");
    System.out.println("the number of items in our List is " + ourList.size());
    
    
  }
}
