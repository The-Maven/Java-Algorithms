import java.util.Arrays;


public class Product implements  Comparable<Product> {
  
  private String name;
  private double price;
  
  public Product(String n, double p){
    name = n;
    price = p;
  }
  
  public String getName(){
    return name;
  }
  
  public double getPrice(){
    return price;
  }
  
  public void setName(String newName){
    name = newName;
  }
  
  public void setPrice(double newPrice){
    price = newPrice;
  }
  
  public String toString(){
    return (name + " @ " + price);
  }
  
  public boolean equals(Object other){
    if (other instanceof Product){
      Product otherProduct = (Product) other;
      return (name.equalsIgnoreCase(otherProduct.name) &&
              (price-otherProduct.price)<0.000000001 &&
              (price-otherProduct.price)>-0.000000001);
    }
    else
      return false;
  }
  
  
  public int compareTo(Product otherProduct){
    if(this.name.equalsIgnoreCase(otherProduct.name)){
      if((this.price)< otherProduct.price)
        return -1;
      else if((this.price)==otherProduct.price)
        return 0;
      else
        return 1;
    }
    else {
      int val ;
      
      if((this.name.compareTo(otherProduct.name)) > 0)
        val = 1 ;
      else if((this.name.compareTo(otherProduct.name)) ==0)
        val = 0 ;
      
      else
        val = -1;
      
      return val;
    }
  }
  private static void swap(Product[] array,int a , int b){
    Product temp = new Product(null,0) ;
    temp.setName(array[b].getName());
    temp.setPrice(array[b].getPrice());
    
    array[b].setName(array[a].getName());
    array[b].setPrice(array[a].getPrice());
    
    array[a].setName(temp.getName());
    array[a].setPrice(temp.getPrice());
    
    
    
    
  }
  
  
  
  public static void selectionSort(Product[] stuff){
    int i, r  , min;
    
    for( i= 0 ; i< stuff.length-1; i++)
    {
      min = i;
      for(r = i+1 ; r <stuff.length ; r++)
        if(stuff[r].compareTo(stuff[min]) == -1)
        min = r;
      swap(stuff,i, min); 
    }}
  
  public static void main(String[] args){
    
    Product mine = new Product("Gucci", 600.00);
    Product yours =  new Product("Leather",450.00);
    System.out.println(mine.compareTo(yours));   
    
    Product[] anArray = new Product[11];
    
    //Add some products to the list
    anArray[0]= new Product("ice", 1.00);
    anArray[1]= new Product("gun", 300.50);
    anArray[2]=new Product("water", 2.30);
    anArray[3]=new Product("novel", 16.99);
    anArray[4]= new Product("brush", 6.70);
    anArray[5]=new Product("cologne", 8.60);
    anArray[6]= new Product("razor", 5.10);
    anArray[7]=new Product("lays", 3.05);
    anArray[8] =new Product("pencil",0.40);
    anArray[9]=new Product("sushi",22.50);
    anArray[10]=new Product("gun", 400.50);
    
    
    System.out.println(Arrays.toString(anArray));
    Arrays.sort(anArray);
    System.out.println();
    System.out.println(Arrays.toString(anArray));
    Product.selectionSort(anArray);
    System.out.println();
    System.out.println(Arrays.toString(anArray));
    
  }}
