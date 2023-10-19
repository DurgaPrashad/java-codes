// b) Write a Java program that uses recursive function to print the nth value in the 
// Fibonacci sequence. 
// Program:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class fib
{
    public static void main(String[] args ) throws Exception
  {
 System.out.println("Enter the nth number ");
  BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
 int n = Integer.parseInt(b.readLine());
 System.out.println("nth fibonacci number is "+ fib(n));
 }
 public static int fib(int n)
 {
 if(n==1) return 0;
 if(n==2) return 1;
 return fib(n-1)+fib(n-2);
 }
 }
// Output:
// Enter the nth number 
// 5
// nth fibonacci number is 3
