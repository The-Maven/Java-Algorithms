import java.util.Scanner;
public class newArray
{
  public static void main(String[] args)
  {
    String vowels[] = new String[10];
    Scanner input = new Scanner(System.in);
    System.out.println(" Please enter 10 names ");
    
    for(int k = 0; k < vowels.length; k++)
    {
      vowels[k] = input.nextLine();
    }
    
    
    char characters[] = new char[5];
    characters[0] = 'a';
    characters[1] = 'e';
    characters[2] = 'i';
    characters[3] = 'o';
    characters[4] = 'u';
    
    int count = 0;
    
    for (int k = 0; k < vowels.length; k++)
    {
      if (vowels[k].charAt(0) == characters[0])
        count++;
      else if (vowels[k].charAt(0) == characters[1])
        count++;
      else if (vowels[k].charAt(0) == characters[2])
        count++;
      else if (vowels[k].charAt(0) == characters[3])
        count++;
      else if (vowels[k].charAt(0) == characters[4])
        count++;
    }
    
    System.out.println("The number of vowels are " + count);
  }
}
