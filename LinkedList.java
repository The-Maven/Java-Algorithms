
/** 
 * This is a generic version of the Linked list class, that also provides
 * an iterator to iterate over all of the items in the list.
 **/
public class LinkedList<T> {
  private ListNode<T> head;
  private ListNode<T> tail;
  private ListNode<T> storeTail;
  private int numItems;
  
  /*
   * A nested ListNode class.  Note that this class is
   * also a generic class, parameterized by T
   */
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
  /** End of ListNode class **/
  
  /**
   * A nested ListIterator class.  Note that this class is
   * also a generic class, parameterized by T
   **/
  public static class ListIterator<T> {
    private ListNode<T> current;
    
    // because the class is a nested class (i.e. static), it
    // is independent of the LinkedList class, and so needs
    // to be a given a list that it is iterating over.
    // our next version will make a way for this to be unnecessary.
    public ListIterator(LinkedList<T> theList){
      current = theList.head;
    }
    
    // return the current item
    public T getCurrent(){
      if (current != null)
        return current.data;
      else
        return null;
    }
    
    // move to the next item
    public void next(){
      if (current != null)
        current = current.next;
    }
  }
  /** End of ListIterator class **/
  
  // A constructor for the LinkedList class, to create an initially
  // empty list.
  public LinkedList(){
    head = null;
    tail = null;
    numItems = 0;
  }
  
  /**
   * Return an iterator over this list
   **/
  public LinkedList.ListIterator<T> iterator(){
    return new LinkedList.ListIterator<T>(this);
  }
  
  /**
   * Adds an item to the front of the list
   **/
  public void add(T item){
    ListNode<T> newNode = new ListNode<T>(item);
    if (head != null)
      newNode.next = head;
    tail = newNode;
    
    head = newNode;
    numItems++;
  }
  
  public void addLast(T item){                        // add to the last position
    ListNode<T> a = new ListNode<T>(item);
    ListNode<T> b = new ListNode<T>(item);
    
    a = head;
    
    while(a.next != null){
      a = a.next;
    }
    
    a.next = b;
    tail = b;
    numItems++;
  }
  
  /**
   * removes an item from the list
   **/
  public void remove(T item){
    if (head == null)
      return;
    
    if (head.data.equals(item)){
      head = head.next;
      numItems--;
      tail = head;
    }
    
    else {
      ListNode<T> prev = head;
      while (prev.next != null && !prev.next.data.equals(item)){
        prev = prev.next;
      }
      if (prev.next != null) { // I've found the item.
        prev.next = (prev.next.next);
        numItems--;
        storeTail = prev;
      }
      
    }
    while (head.next != null){
      head = head.next;
  }
    if (head.equals(storeTail))
      tail = head;
  }
  
  public void displaySort(LinkedList<Integer> theList){
    LinkedList.ListIterator<Integer> i1 = theList.iterator();
    LinkedList.ListIterator<Integer> i2 = theList.iterator();
    while(i2.getCurrent()%2 ==1){
      i2.next();
    }
    
    while(i2.getCurrent() != null && i1.getCurrent()%2 == 1){
      if(i1.getCurrent() < i2.getCurrent()){
        System.out.println(i1.getCurrent());
        i1.next();
      }
      else{
        System.out.println(i2.getCurrent());
        
        i2.next();
      }
    }
    
    while(i1.getCurrent()%2 ==1){
      System.out.println(i1.getCurrent());
      i1.next();
    }
    
    while(i2.getCurrent()!= null){
      System.out.println(i2.getCurrent());
      i2.next();
    }
  }
  
  /**
   * Returns the number of items in the list.
   */
  public int getNumItems() {
    return numItems;
  }
  
  /** 
   * display all the items in the list
   **/
  public void printList(){
    ListNode current = head;
    
    while (current != null){
      System.out.print(current.data);
      if (current.next == null)
        System.out.println(".");
      else
        System.out.print(", ");
      
      current = current.next;
    }
  }
  
  /**
   * This method returns the first item in the list
   */
  public T getFirst(){
    return head.data;
  }
  
  public T getTail(){
    return tail.data;
  }
  
  public T getLast(){               //get last item
    return get(numItems - 1);
  }
  
  /**public T getTail(){
    return tail.data;
    }*/
  
  /**
   * This method returns the ith item in the list.
   * Because it needs to start at the beginning of the list in order
   * to count up to the ith item, its runtime is O(N)
   */
  public T get(int i){
    ListNode<T> current = head;
    int count = 0;
    
    while (count < i && current != null){
      current = current.next;
      count++;
    }
    if (current != null)
      return current.data;
    else
      return null;
  }
  
}