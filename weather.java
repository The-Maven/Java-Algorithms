import java.util.Scanner;

public class weather{
    public static void main(String[] args) {
  int month;
  Scanner keyboard = new Scanner(System.in);
  month = keyboard.nextInt();
  
  if ((month >= 3) && (month <= 7)|| (month >=9) && (month <=10));{
    System.out.println("Rain likely");
  }
      System.out.println("Rain unlikely");
  }
  
}
