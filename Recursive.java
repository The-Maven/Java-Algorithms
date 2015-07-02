public class Recursive{
  
  
  public  static  int multiply(int a , int b){
    int product = 0 ;
    
    if(a == 0 || b == 0)
      return product ;
    else if(a<0  || b< 0)
      return product;
    else{
      product+= a ;
      b--;
      
      return product + multiply(a,b) ;
    }}
  
  public static boolean palindrome(String input){
    
    String words = input.toLowerCase();
    
    if(input.length() < 2)
      return true;
    else{
      
      if(words.charAt(0) == words.charAt(words.length()-1)){
        return palindrome(words.substring(1,words.length()-1));
      }
      else       
        return false;}
  }
  
  
  
  public static void main(String[] args){
    
    
    System.out.println(Recursive.multiply(8,8));
    System.out.println(Recursive.palindrome("ana"));
    System.out.println(Recursive.palindrome("illuminati"));    
    System.out.println(Recursive.palindrome("program"));
    System.out.println(Recursive.palindrome("Straw Noon warts"));
  }
}

