//package IntegerMultiplication;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Anthony Kafui Kwawu on 07/09/2014.
 */
public class NonNaiveMultiplication {
    public static void main (String[] args){
        //Test cases for different scenarios
        System.out.println("Both even");
        System.out.println(karatsubaMultiplication(1100, 1100));
        System.out.println("Both odd");
        System.out.println(karatsubaMultiplication(110, 110));
        System.out.println("One even and One odd");
        System.out.println(karatsubaMultiplication(12345, 1234));
        System.out.println();

        System.out.println("Normal recursive method");
        System.out.println("Both even");
        System.out.println(normalRecursive(1100, 1100));
        System.out.println("Both odd");
        System.out.println(normalRecursive(110, 110));
        System.out.println("One even and One odd");
        System.out.println(normalRecursive(12345, 1234));



    }
    //Method to return length of a number
    public static int returnSize(long number)
    {
        int count = 0;
        while (number != 0)
        {
            count++;
            number /= 10;
        }
        return count;
    }

    //Method to compute the product of 2 numbers in a Non-Naive implementation
    public static long normalRecursive(long x, long y){

        int n = Math.max(returnSize(x), returnSize(y));

        if(n<10)                   //if number is single digit do simple multiplication. [base case]
            return x*y;


        n = (n/2) + (n%2);          //getting exponent. Cater for odd numbers.

        long k = (long)Math.pow(10, n);


        long a= x / k;               //splitting numbers. Start with first number
        long b = x - (a * k);
        long c = y / k;
        long d = y - (c * n);


        long ac = karatsubaMultiplication(a, c);  //recursive calls
        long ad = karatsubaMultiplication(a, c);
        long ab = karatsubaMultiplication(a, b);
        long bd = karatsubaMultiplication(b, d);


        return bd + (ac * (long) (Math.pow(10, 2 * n))) + (ad *(long) (Math.pow(10, n))) + (ab *(long) (Math.pow(10, n))) ;

    }

    //Method to compute the product of 2 numbers in a karatsuba implementation
    public static long karatsubaMultiplication(long x, long y){

        int n = Math.max(returnSize(x), returnSize(y)); //return size

        if(n<10)  //if base case, do simple multiplication
            return x*y;


        n = (n/2) + (n%2); //getting the exponent of n, modulus operator caters for odd sizes

        long k = (long)Math.pow(10, n);


        long a= x / k;        //first part of first number
        long b = x - (a * k); //second part of first number
        long c = y / k;       //first part of second number
        long d = y - (c * n); //second part of second number


        long ac = karatsubaMultiplication(a, c);            //recursive calls
        long kMagic = karatsubaMultiplication(a + b, c + d);
        long bd = karatsubaMultiplication(b, d);


        return bd + ((kMagic - bd - ac) * k) + (ac * (long) (Math.pow(10, 2 * n)));
    }

    //int karatsubaMagic =  ((int)Math.pow(10, n/2)) * (((a+b) * (c+d)) - a*c - b*d);
    //  return (((a * c) * (int) Math.pow(10, n)) + (b * d)) + karatsubaMagic;
}

