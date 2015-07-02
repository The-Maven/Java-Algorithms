import java.util.Scanner;

public class TestBST {
  
  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    
    Scanner keyboard = new Scanner(System.in);
    String input;
    boolean done = false;
    
    System.out.println("Please enter numbers to enter into the tree." +
                       "Type a non-numerical string when you're done.");
    
    do {
      input = keyboard.next();
      try {
        int n = Integer.parseInt(input);
        bst.insert(n);
      }
      catch (Exception e) {
        done = true;
      }
    } while (!done);
    
    System.out.println("Printing the tree using an in-order traversal:");
    bst.printTree();
    
    System.out.println("Drawing the tree:");
    bst.drawTree();
  }
}