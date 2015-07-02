import java.util.TreeMap;

public class MapTree
{
  public static void main(String[] args)
  {
    
    System.out.println("A Tree Map OF Products\n");
    
    //creating treemap object
    TreeMap<Integer, Product> tree = new TreeMap<Integer, Product>();
    
    //creating products
    Product water = new Product("water", 1);
    Product sugar = new Product("sugar", 2);
    Product milk = new Product("milk", 3);
    Product toffee = new Product("toffee", 4);
    Product soup = new Product("soup", 5);
    Product tofu = new Product("tofu", 8);
    
    //adding stuff
    tree.put(0, water);
    tree.put(1, sugar);
    tree.put(2, milk);
    tree.put(3, toffee);
    tree.put(4, soup);
    
    //checking if item exists
    System.out.println(tree.containsKey(1));
    System.out.println(tree.containsKey(7));
    
    //get items
    System.out.println(tree.get(1));
    System.out.println(tree.get(7));
    
    //does item exist?
    System.out.println(tree.containsValue(water));
    System.out.println(tree.containsValue(sugar));
    
    //get keys
    System.out.println(tree.keySet());
    
    //retrieving values
    System.out.println(tree.values());
    
    //changing values by 10%
    for(int i = 0; i < tree.size(); i++){
      tree.get(i).setPrice(1.1 * tree.get(i).getPrice());
      System.out.println(tree.get(i));
    }
    
    //removing item
    tree.remove(1);
    
    //print items
    for(int i = 0; i < tree.size(); i++){
      System.out.println(tree.get(i));
    }
  }
}

