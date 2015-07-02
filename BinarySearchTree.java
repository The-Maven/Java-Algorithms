// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import java.util.Formatter;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<T extends Comparable<? super T>, F extends Comparable<? super F>>
{
  /** The tree root. */
  private BinaryNode<T, F> root;
  
  
  // Basic node stored in unbalanced binary search trees
  private static class BinaryNode<T, F>
  {
    T search;            // The data in the node
    BinaryNode<T, F> left;   // Left child
    BinaryNode<T, F> right;  // Right child
    F item;
    
    // Constructors
    BinaryNode( T theSearch, F newItem)
    {
      this( theSearch, newItem, null, null );
    }
    
    BinaryNode( T theSearch, F newItem, BinaryNode<T, F> lt, BinaryNode<T, F> rt )
    {
      search  = theSearch;
      left     = lt;
      right    = rt;
      item =newItem;
    }
  }
  
  
  /**
   * Construct the tree.
   */
  public BinarySearchTree( )
  {
    root = null;
  }
  
//method to insert item based on keys
  public void put( T theSearch, F newItem)
  {
    root = put( theSearch, newItem, root );
  }
  
//helper method to "put"t item in tree
  private BinaryNode<T, F> put( T theSearch, F newItem, BinaryNode<T, F> t )
  {
    if( t == null )
      return new BinaryNode<T, F>( theSearch, newItem, null, null );
    
    int compareResult = theSearch.compareTo( t.search );
    
    if( compareResult < 0 )
      t.left = put( theSearch, newItem, t.left );
    else if( compareResult > 0 )
      t.right = put( theSearch, newItem, t.right );
    else
      ;  // Duplicate; do nothing
    
    return t;
  }
  
  /**
   * Find the smallest item in the tree.
   * @return smallest item or null if empty.
   */
  public F findMin( )
  {
    if( isEmpty( ) )
      throw new RuntimeException("Cannot find min element in an empty tree.");
    
    return findMin( root ).item;
  }
  
  /**
   * Internal method to find the smallest item in a subtree.
   * @param t the node that roots the subtree.
   * @return node containing the smallest item.
   */
  private BinaryNode<T, F> findMin( BinaryNode<T, F> t )
  {
    if( t == null )
      return null;
    
    else if( t.left == null )
      return t;
    
    else
      return findMin( t.left );
  }
  
  /**
   * Find the largest item in the tree.
   * @return the largest item of null if empty.
   */
  public F findMax( )
  {
    if( isEmpty( ) )
      throw new RuntimeException("Cannot find max element in an empty tree.");
    
    return findMax( root ).item;
  }
  
  /**
   * Internal method to find the largest item in a subtree.
   * @param t the node that roots the subtree.
   * @return node containing the largest item.
   */
  private BinaryNode<T, F> findMax( BinaryNode<T, F> t )
  {
    
    if( t != null ) {
      
      while( t.right != null )
        t = t.right;
      
    }
    
    return t;
  }
  
//method to find if tree has item
  public boolean contains( T search )
  {
    return contains(search, root );
  }
  
//helper method to check if item is in tree
  private boolean contains( T theSearch, BinaryNode<T, F> t )
  {
    if( t == null )
      return false;
    
    int compareResult = theSearch.compareTo( t.search );
    
    if( compareResult < 0 )
      return contains( theSearch, t.left );
    
    else if( compareResult > 0 )
      return contains( theSearch, t.right );
    
    else // compareResult == 0 i.e. they are equal
      return true;    // Match
  }
  
  //instantiating set
  Set<T> newSet = new TreeSet<T>();
  
  //method to return set of keys
  public Set<T> keySet(){
    return (keySet(root));
  }
  
  //helper keyset method
  private Set<T> keySet(BinaryNode<T, F> t){
    if( t != null )
    {
      keySet( t.left );
      
      newSet.add(t.search);
      
      keySet( t.right );
    }
    return newSet;
  }
  
  
  //method checks if product is in tree based on product values
  public boolean containsValue( F item )
  {
    return containsValue(item, root );
  }
  
  private boolean containsValue( F newItem, BinaryNode<T, F> t )
  {
    
    if( t != null )
    {
      int compareResult = newItem.compareTo( t.item );
      
      containsValue(newItem, t.left );
      if(compareResult == 0)
        return true;
      else
        return(containsValue(newItem, t.right ));
    }else return false;
  }
  
 // public boolen anotheContainsValueMethod(F newItem){

  
  
  /**
   * Make the tree logically empty.
   */
  public void makeEmpty( )
  {
    root = null;
  }
  
  /**
   * Test if the tree is logically empty.
   * @return true if empty, false otherwise.
   */
  public boolean isEmpty( )
  {
    return root == null;
  }
  
  /**
   * Print the tree contents in sorted order.
   */
  public void printTree( )
  {
    if( isEmpty( ) )
      System.out.println( "Empty tree" );
    else {
      printTree( root );
      System.out.println();
    }
  }
  
//remove item in tree
  public void remove( T theSearch )
  {
    root = remove( theSearch, root );
  }
  
  
  //internal helper method to remove item
  private BinaryNode<T, F> remove( T theSearch, BinaryNode<T, F> t )
  {
    if( t == null )
      return t;   // Item not found; do nothing
    
    int compareResult = theSearch.compareTo( t.search );
    
    if( compareResult < 0 )
      t.left = remove( theSearch, t.left );
    
    else if( compareResult > 0 )
      t.right = remove( theSearch, t.right );
    
    else if( t.left != null && t.right != null ) // Two children
    {
      BinaryNode<T, F> nodeOnRightWithMinElt = findMin( t.right );
      t.search = nodeOnRightWithMinElt.search;
      t.right = remove( nodeOnRightWithMinElt.search, t.right );
    }
    
    else { // either one child or no children
      // replace t with its child, if any
      t = ( t.left != null ) ? t.left : t.right;
      
      /*
       // one left child - replace t with its left child
       if (t.left != null)
       t = t.left;
       
       // one right child - replace t with its right child
       else
       t = t.right;
       */
    }
    
    return t;
  }
  
  
  //in-order traversal to print items in tree
  private void printTree( BinaryNode<T, F> t )
  {
    if( t != null )
    {
      printTree( t.left );
      
      System.out.print( t.search + " " );
      
      printTree( t.right );
    }
  }
  
  //method to get item based on key
  public F get(T key){
    return get(key, root).item;
  }
  private BinaryNode<T, F> get(T theSearch, BinaryNode<T, F> t){
    if(t ==null)
      return null;
    int compareResult = theSearch.compareTo(t.search);
    
    
    if( compareResult < 0 )
      return get( theSearch, t.left );
    
    else if( compareResult > 0 )
      return get( theSearch, t.right );
    else
      return t;
  }
  
  
  /**
   * Internal method to compute height of a subtree.
   * @param t the node that roots the subtree.
   */
  private int height( BinaryNode<T, F> t )
  {
    if( t == null )
      return -1;
    
    else
      return 1 + Math.max( height( t.left ), height( t.right ) );    
  }
  
  
  
  public void drawTree(){
    final int SMALLEST_SPACE = 4;
    int height = height(root);
    int maxNodes = (int) Math.pow(2, height);
    int maxLeaves = maxNodes/2;
    int baseWidth = SMALLEST_SPACE*(maxLeaves);
    int center = baseWidth/2;
    Formatter formatter = new Formatter(System.out);
    
    Queue<BinaryNode<T, F>> tempQ1 = new Queue<BinaryNode<T, F>>();
    tempQ1.enqueue(root);
    
    int lastSpace = (int) (2*Math.pow(2, (height)));
    
    for (int i=0; i<height; i++){
      int nodes = (int) Math.pow(2,i);
      int spaces =  (int) Math.pow(2, (height-i-1)) * SMALLEST_SPACE;
      int start = center - (nodes/2*spaces) + (i == 0 ? 0 : spaces/2); 
      
      Queue<BinaryNode<T, F>> tempQ2 = new Queue<BinaryNode<T, F>>();
      
      for (int j=0;j<start; j++){
        System.out.print(" ");
      }
      
      int node = 0;
      while (!tempQ1.isEmpty()){        
        BinaryNode<T, F> tempNode = tempQ1.dequeue();
        if (tempNode != null){
          tempQ2.enqueue(tempNode.left);
          tempQ2.enqueue(tempNode.right);
        } else {
          tempQ2.enqueue(null);
          tempQ2.enqueue(null);
        }
        
        if (tempNode != null)
          formatter.format(("%"+(node==0 ? spaces-start : spaces) + "d"),tempNode.search);
        else
          formatter.format(("%"+ (node==0 ? spaces-start : spaces) + "s"),"");
        
        for (int j=0; j<spaces; j++)
          System.out.print(" ");
        
        node++;
      }
      System.out.println();
      
      tempQ1 = tempQ2;
    }
  }
}
