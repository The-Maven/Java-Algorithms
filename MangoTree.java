import java.util.Iterator;
import java.util.TreeSet;

public class MangoTree {
  
  public static void main(String[] args) {
    
    System.out.println("A Tree OF Products\n");
    
    //instantiate tree set
    TreeSet<Product> tree = new TreeSet<Product>();
    
   //creating products
    Product water = new Product("water", 1);
    Product sugar = new Product("sugar", 2);
    Product milk = new Product("milk", 3);
    Product toffee = new Product("toffee", 4);
    Product soup = new Product("soup", 5);
    Product tofu = new Product("tofu", 8);
    
    //adding products
    tree.add(water);
    tree.add(sugar);
    tree.add(milk);
    tree.add(toffee);
    tree.add(soup);
    
    //creating iterator
    Iterator<Product> iterator = tree.iterator();
    
    System.out.print("Products: ");
    
    // Displaying the in Tree
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
    
    
    // Emptiness check
    if (tree.isEmpty()) {
      System.out.print("Tree is empty.");
    } else {
      System.out.println("Tree size: " + tree.size());
    }
    
    // Get first Item
    System.out.println("First product: " + tree.first());
    
    // Get last Item
    System.out.println("Last product: " + tree.last());
    
    if (tree.remove(toffee)) { // remove item
      System.out.println("Item removed");
    } else {
      System.out.println("Item non-existent!");
    }
    System.out.print("Tree now contains: ");
    
    //iterator = tree.iterator();
    
    // Displaying the Tree set data
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
    
    
    System.out.println("Now the size of tree is: " + tree.size());
    
    System.out.println(tree.contains(sugar));
    
    System.out.println(tree.contains(tofu));
    
    
    //another iterator + increasing prices by 10%
    Iterator<Product> iterator2 = tree.iterator();
    while (iterator2.hasNext()) {
      Product pointer = iterator2.next();
      pointer.setPrice(1.1 * pointer.getPrice());
      System.out.println(pointer.getPrice() + " ");
    }
     System.out.println();
     
    // Remove all
    tree.clear();
    if (tree.isEmpty()) {
      System.out.print("Tree is now empty.");
    } else {
      System.out.println("Tree size: " + tree.size());
    }
  }
}