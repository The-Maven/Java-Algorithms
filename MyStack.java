/** 
 * Simple implementation of a Stack ADT.
 **/
public class MyStack<AnyType> {
  private MyLinkedList<AnyType> internalList;
  
  // The contructor
  public MyStack(){
    internalList = new MyLinkedList<AnyType>();
  }
  
  // Pushes an item onto the stack
  public void push(AnyType newItem){
    internalList.add(0,newItem);
  }
  
  // Peeks at the item at the top of the stack
  public AnyType top() {
    if (internalList.isEmpty())
      throw new java.util.NoSuchElementException( ); 
    
    return internalList.get(0);
  }
  
  // Pops an item off the stack
  public AnyType pop() {
     if (internalList.isEmpty())
      throw new java.util.NoSuchElementException( ); 
     
     return internalList.remove(0);
  }
  
  // Checks if the stack is empty
  public boolean isEmpty(){
    return internalList.isEmpty();
  }
}