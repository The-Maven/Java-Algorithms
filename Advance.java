
public class NonNaiveMultiplication {
        public static void main (String[] args){
            System.out.println(karatsubaMultiplication(23, 4560));

        }

        public static int karatsubaMultiplication(int x, int y){
            String i = "" + x;
            int iLength = i.length();
            String j = "" + y;
            int jLength = j.length();

            if(x % 2 != 0)
                x *= 10;

            if(y % 2 != 0)
                y *= 10;

            int a, b, c, d;
            String s = "" + Math.max(x, y);
            int n = s.length();

            if(n==1){
                return x * y;
            }else{
                a =(x/((int)Math.pow(10, n/2)));
                b =(x%((int)Math.pow(10, n/2)));
                c = (y/((int)Math.pow(10, n/2)));
                d = (y%((int)Math.pow(10, n/2)));

                karatsubaMultiplication(a, b);
                karatsubaMultiplication(c, d);
                karatsubaMultiplication((a+b), (c+d));
            }

            int karatsubaMagic =  ((int)Math.pow(10, n/2)) * (((a+b) * (c+d)) - a*c - b*d);
            System.out.println(karatsubaMagic);
            if (iLength > n || jLength > n){
                return ((((a*c) * (int)Math.pow(10, n)) + (b*d)) + karatsubaMagic) / 10;
            }else {
                return (((a * c) * (int) Math.pow(10, n)) + (b * d)) + karatsubaMagic;
            }
            }

        }



