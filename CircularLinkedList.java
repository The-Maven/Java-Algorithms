
public class CircularLinkedList<T> {
  private ListNode<T> current;
  private int death;
  private int numItems;
  private int survivors = 1;
  private int count;
  
  
  private static class ListNode<T> {
    public T data;
    public ListNode<T> next;
    
    public ListNode(T data, ListNode<T> next){
      this.data = data;
      this.next = next;
    }
    
    public ListNode(T data){
      this(data, null); // make a call to the other constructor
    }
  }
  
  // A constructor for the LinkedList class, to create an initially
  // empty list.
  public CircularLinkedList(){
    current = null;
  }
  
  // add an item to circular list
  public void add(T item){
    ListNode<T> newNode = new ListNode<T>(item);
    if (current != null){
      newNode.next = current.next;
      current.next = newNode;
    }
    else{
      current = newNode;
      newNode.next = current;
    }
  }
  
  public  void doCount(int x){
    count = x;}
  public int getCount(){
    return count;
  }
  public void set(){
    death = 0;
  }
  public int kill(){
    return death;
  }
  public void increase(){
    death++;
  }
  
  public int getNumItems(){
    return numItems;
  }
  
  
  public void josephus(int x){
    doCount(x);
    do{
      set();
      while(kill() < getCount()){
        current = current.next;
        increase();
      }
      remove(current.next.data);
      System.out.println("Count" + getNumItems());
    }while(getNumItems() > survivors);
    System.out.println(current.data + " survivors");
  }
  // remove item from the list
  public void remove(T item){
    if (current == null)
      return;
    
    if (current.data.equals(item))
      current = current.next;
    
    else {
      ListNode<T> prev = current;
      while (prev.next != null && !prev.next.data.equals(item)){
        prev = prev.next;
      }
      if (prev.next != null)
        prev.next = (prev.next.next);
    }
  }
  
  // display all the items in the list
  public void printList(){
    ListNode go = current;
    
    if (current != null)
      do{
      System.out.print(go.data);
      System.out.println(go.data);
      go = go.next;
    }
    
    while (go != current);
    
  }
  
  
  // return the first item in the list
  public T getFirst(){
    return current.data;
  }
  
  // A test program
  public static void main(String[] args){
    
    // Create a list of Products
    
    Product a = new Product("Orange",0.20);
    Product b = new Product("Pineapple",1.50);
    Product c = new Product("Mango",1.00);
    Product d = new Product("Banana",2.00);
                  
    // add items
    CircularLinkedList<Product> myList2 = new CircularLinkedList<Product>();
    myList2.add(a);
    myList2.add(b);
    myList2.add(c);
    myList2.add(d);
    System.out.println("Here is a list of items sold at my fruit stand: ");
    myList2.printList();
    myList2.remove(a);
    System.out.println("The first item in the list is: " + myList2.getFirst());
     
    // Products, myList2.getFirst() returns a Product, and so we can 
    // directly call the getPrice() method on it.
    System.out.println("The price of the first item in the list is: " +
                       myList2.getFirst().getPrice());
    
    
    // we cannot add any objects of another type (e.g. String) to the list.
    //myList2.add("ham"); 
    
    CircularLinkedList<Integer> myList3 = new CircularLinkedList<Integer>();
    myList3.add(new Integer(5));
    myList3.add(66);
    Integer first = myList3.getFirst();
    int first2 = myList3.getFirst();
    
    System.out.println("The list is : ");
    myList3.printList();
    System.out.println("The first item is: " + first);
    System.out.println(" first item is: " + first2);
    myList3.josephus(7);
    
    
  }
}