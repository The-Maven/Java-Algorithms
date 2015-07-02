public class TestLinkedList {
  // A test program
  public static void main(String[] args){
    
    // Create a list of Products
    LinkedList<Product> myList2 = new LinkedList<Product>();
     // Create a list of Products
    Product a = new Product("Orange",0.20);
    Product b = new Product("Pineapple",1.50);
    Product c = new Product("Mango",1.00);
    Product d = new Product("Banana",2.00);
    Product e = new Product("kiwi", 8.00);
    Product f = new Product("pear", 89.00);
    
                  
    // add items
    myList2.add(a);
    myList2.add(b);
    myList2.add(c);
    myList2.add(d);
    myList2.addLast(e);
    
    System.out.println("Here is a list of items sold at my fruit stand: ");
    myList2.printList();
    System.out.println("The first item in the list is: " + myList2.getFirst());
    System.out.println("The last item in the list is: " + myList2.getLast());
    
    System.out.println();
    System.out.println(myList2.getTail());
    
    //remove last item
    myList2.remove(e);
    
    //tail after last item is removed
    System.out.println(myList2.getTail());
    
    System.out.println("The new list");
    myList2.printList();
    
    myList2.addLast(f);
    
    //new tail
    System.out.println(myList2.getTail());
    
    // Note that, because our list is constrained to specifically hold 
    // Products, myList2.getFirst() returns a Product, and so we can 
    // directly call the getPrice() method on it.
    System.out.println("The price of the first item in the list is: " +
                       myList2.getFirst().getPrice());
    
    System.out.println("The item at index 2 of the list is: " + myList2.get(2));
    
    increasePricesV2(myList2, 0.50);
    System.out.println("After increasing prices, the list is now: ");
    myList2.printList();

    
    LinkedList<Integer> aList = new LinkedList<Integer>();      // add integers
    aList.add(10);
    aList.add(8);
    aList.add(6);
    aList.add(7);
    aList.add(5);
    aList.add(3);
    
    aList.displaySort(aList);                                  // display sorted list
    
  }
  
  
  // An inefficient approach to increasing the price of all the products
  public static void increasePricesV1(LinkedList<Product> productList, 
                                      double amt) {
    for (int i=0; i<productList.getNumItems(); i++){
      Product prod = (Product) productList.get(i);
      prod.setPrice(prod.getPrice() + amt);
    }
  }
  
  // An efficient approach to increasing the price of all the products
  public static void increasePricesV2(LinkedList<Product> productList,
                                      double amt) {
    
    LinkedList.ListIterator<Product> myIter = productList.iterator();
    
    while (myIter.getCurrent() != null){
      Product prod = myIter.getCurrent();
      prod.setPrice(prod.getPrice() + amt);
      myIter.next();
    }
  }
  
  
}