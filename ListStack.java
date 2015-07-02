public class ListStack                               //Linked List implementation of Stack with relevant methods
{
  private ListNode top;
  private int nElems;
  
  public ListStack(){
    top = null;
    nElems = 0;
  }
  
  public void push(Integer x){
    ListNode a = new ListNode(x);
    if (top == null)
      top = a;
    else
      a.setNext(top);
    top = a;
    nElems++;
  }
  
  public Integer pop(){
    ListNode temp = top;
    top  = top.getNext();
    return temp.getData();
  }
  
  public Integer peek(){
return top.getData();
}

  public static void main (String[] args){
    ListStack s = new ListStack();
    
    s.push(34);
    s.push(98);
    s.push(76);
    s.pop();
    s.pop();
   System.out.println( s.peek());
  }
}

