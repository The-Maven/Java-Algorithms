
/**
 * A class to represent a list node.
 */
public class ListNode {
  private Integer data;
  private ListNode next;
  private ListNode tail;
  public ListNode(Integer data, ListNode next){
    this.data = data;
    this.next = next;
  }
  
  public ListNode(Integer data){
    this(data, null); // make a call to the other constructor
  }
  
  
  public Integer getData(){
    return data;
  }
  
  public ListNode getNext(){
    return next;
  }
  
  public void setData(Integer newdata){
    data = newdata;
  }
  
  public void setNext(ListNode newNext){
    next = newNext;
  }
  
}