public class Hcf{
 public static int hcf(int a, int b){
if(b > a){
int temp = a;
 a = b;
b = temp;
}
if(a%b ==0)
 return b;
else
return hcf(a%b, b);
}

public static void main(String args[]){
int q = 30;
int t = 35;
System.out.println("HCF of "+q+" and "+t+" is "+hcf(q,t));
}
}