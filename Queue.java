import java.util.NoSuchElementException;
import java. util. Random;
import java.util.Scanner;

// Define a generic stack
public class Queue <T>{
  private T[] queueArray;
  private int front;
  private int back;
  private int nItems;
  int sum1, sum2;
  
  public static int INIT_CAPACITY = 5;
  
  // Constructor - creates a stack with an inital capacity of INIT_CAPACITY
  @SuppressWarnings("unchecked")
  public Queue() {
    queueArray = (T[]) new Object[INIT_CAPACITY];
    front = 0;
    back = -1;
    nItems = 0;
  }
  
  // Insert an item at the back of the queue
  public void enqueue(T item){
    if (isFull())
      expandArray();
    
    back = (back+1) % queueArray.length;
    queueArray[back] = item;
    nItems++;
    
    //System.out.println("n items is now " + nItems);
  }
  
  // Examines the item at the top of the stack
  public T peek() throws NoSuchElementException {
    if (isEmpty())
      throw new NoSuchElementException("Cannot examine front of an empty queue.");
    
    return queueArray[front];
  }
  
  // Removes the item at the front of the queue
  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Cannot remove from an empty queue.");
    
    T item = queueArray[front];
    //queueArray[front] = null;
    front = (front+1) % queueArray.length;
    nItems--;
    return item;
    
  }  
  
  public boolean isEmpty() {
    return (nItems==0);
  }
  
  private boolean isFull() {
    return (nItems == queueArray.length);
  }
  
  @SuppressWarnings("unchecked")
  private void expandArray(){
    System.out.println("Expanding array");
    int newCapacity = queueArray.length*2;
    
    T[] newQueueArray = (T[]) new Object[newCapacity];
    int i = front; // index into old array
    int j = 0; // index into new array
    while (j<nItems){
      newQueueArray[j++] = queueArray[i++];
      i = i % queueArray.length; // wrap i around if necessary, since items may continue at the beginning of the array
    }
    front = 0;
    back = nItems-1;
    
    queueArray = newQueueArray;
  }
  
  /*public void add(){
   int x =0;
   Integer sum = 0;
   for(int k = front; x < nItems; k = (k+1) % queueArray.length){
   sum += (Integer)queueArray[k];
   }
   }*/
  
  
  public void display(){
    int x = 0;
    if (isEmpty())
      System.out.println("Sorry, list is empty");
    else
      for(int k = front; x < nItems; k = (k+1) % queueArray.length){
      System.out.println(queueArray[k]);
      x++;
    }
  }
  
  public boolean isFrontFinished (){
    return ((Integer)queueArray[front] == 0);
  }
  
  public void enqueueDecision(Queue <Integer> a, Queue <Integer> b, int x){
    if(a.isEmpty())
      a.enqueue(x);
    else if(b.isEmpty())
      b.enqueue(x);
    else if(sum1 < sum2)
      a.enqueue(x);
    else
      b.enqueue(x);
  }
  
  public void dequeueDecision(Queue <Integer> a, Queue <Integer> b){
    if(a.isFrontFinished())
      a.dequeue();
    else if (b.isFrontFinished())
      b.dequeue();
  }
  
  
  // Test the queue
  public static void main(String[] args) {                            //modelling two(2) queues assuming each queue which are initially, 10 people long  and the maximum amount of groceries
    Queue<Integer> q = new Queue<Integer>();               //each person can get to the checkpoint is 35.Customers with more goods exit the queue to the vip lounge. The customer decides to join the queue based on the total number of groceries in each
    Queue<Integer> r = new Queue<Integer>();                // queue because deciding to join the queue based on number of people can be misleading.
    
    Random rand = new Random();
    int[] firstStand = new int[10];
    
    firstStand[0]  = rand.nextInt(35)+1;
    firstStand[1]  = rand.nextInt(35)+1;
    firstStand[2]  = rand.nextInt(35)+1;
    firstStand[3]  = rand.nextInt(35)+1;
    firstStand[4]  = rand.nextInt(35)+1;
    firstStand[5]  = rand.nextInt(35)+1;
    firstStand[6]  = rand.nextInt(35)+1;
    firstStand[7]  = rand.nextInt(35)+1;
    firstStand[8]  = rand.nextInt(35)+1;
    firstStand[9]  = rand.nextInt(35)+1;
    
    int sum1 = 0;
    for (int i=0; i<firstStand.length; i++){
      System.out.println("Enqueueing " + firstStand[i]);
      q.enqueue(firstStand[i]);
      sum1 += firstStand[i];
    }
    System.out.println("sum of items in first queue " + sum1);
    q.display();
    
    if (q.isEmpty())
      System.out.println("Queue is empty.");
    
    
    int[] secondStand = new int[10];
    
    secondStand[0]  = rand.nextInt(35)+1;
    secondStand[1]  = rand.nextInt(35)+1;
    secondStand[2]  = rand.nextInt(35)+1;
    secondStand[3]  = rand.nextInt(35)+1;
    secondStand[4]  = rand.nextInt(35)+1;
    secondStand[5]  = rand.nextInt(35)+1;
    secondStand[6]  = rand.nextInt(35)+1;
    secondStand[7]  = rand.nextInt(35)+1;
    secondStand[8]  = rand.nextInt(35)+1;
    secondStand[9]  = rand.nextInt(35)+1;
    
    int sum2 = 0;
    for (int i=0; i<secondStand.length; i++){
      System.out.println("Enqueueing " + secondStand[i]);
      r.enqueue(secondStand[i]);
      sum2 += secondStand[i];
    }
    System.out.println("sum of items in second queue " + sum2);
    r.display();
    
    if (r.isEmpty())
      System.out.println("Queue is empty.");
    
    System.out.println("We'll direct you to the best queue please enter your number of items");  //join queue if you have not more than 35 items else exit and go to V.I.P. lounge.
    Scanner kb = new Scanner(System.in);
    int newItem = kb.nextInt();
    if(newItem > 35)
      System.out.println("Too many items Sir/Madam, please proceed to V.I.P. lounge or try again");
    else
      q.enqueueDecision(q, r, newItem);
    
    System.out.println("First queue after customer has decided");
    q.display();
    
    System.out.println("Second queue after customer has decided");
    r.display();
    
    
    //q.add();
    /* while (!q.isEmpty()) {
     System.out.println("Dequeueing " + q.dequeue());
     }*/
  }
}