public class TestTree{
    public static void main(String[] args) {
      
      //new Binarysearch tree object
      BinarySearchTree<Integer, Product> apple = new BinarySearchTree<Integer, Product>();
    
     //creating products
    Product water = new Product("water", 1);
    Product sugar = new Product("sugar", 2);
    Product milk = new Product("milk", 3);
    Product toffee = new Product("toffee", 4);
    Product soup = new Product("soup", 5);
    Product tofu = new Product("tofu", 8);
    
    //adding products
    apple.put(0, water);
    apple.put(1, milk);
    apple.put(2, toffee);
    apple.put(3, soup);
    apple.put(4, sugar);
    
    //printing stuff in tree
    apple.printTree();
    System.out.println();
    
    //does it contain item?
    System.out.println(apple.contains(4));
    System.out.println(apple.contains(3));
     System.out.println(apple.contains(2));
      System.out.println(apple.contains(1));
       System.out.println(apple.contains(0));
    System.out.println();
    
    //does it contain item? - based on actual item not key
    System.out.println(apple.containsValue(water));
    System.out.println(apple.containsValue(tofu));

    System.out.println(apple.containsValue(sugar));
    
    //remove item
    apple.remove(2);
    apple.remove(3);
    System.out.println();
   
    
    System.out.println(apple.get(1));
    System.out.println(apple.keySet());
    
    System.out.println();
    apple.printTree();
    
    }
}