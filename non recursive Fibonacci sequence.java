// c) Write a Java program that uses non recursive function to print the nth value in the 
// Fibonacci sequence
// Program:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class fib
{
public static void main(String[] args) throws Exception
{
System.out.println("Enter the nth number ");
BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(b.readLine());
System.out.println("nth fibonacci number is "+ fibonacci(n));
}
public static int fibonacci(int n)
{
int a=0,b=1,c=0;
for(int i=2;i<=n;i++){
c=a+b; a=b; b=c; }
return a;
}
}
// Output:
// Enter the nth number 
// 5
// nth fibonacci number is 3
