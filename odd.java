public class odd{
  public static void main(String[] args){
    int[] array = new int[20];
    int count = 11;
    
    for(int i = 0; i<array.length; i++){
    array[i] = count;
    count+= 2;
    }
    
    for(int x = 0; x<array.length; x++){
      System.out.println(array[x]);
    }
  }
}
    