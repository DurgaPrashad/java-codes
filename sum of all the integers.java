// Write a Java Program that reads a line of integers, and then displays each integer, 
// and the sum of all the integers (Use String Tokenizer class of java.util) 
// Program:
import java.util.Scanner;
import java.util.StringTokenizer;
public class StSum 
{
public static void main(String[] args)
{
int n ,sum=0;
Scanner sc = new Scanner(System.in);
System.out.println("Enter the integer separated by a space: ");
String s = sc.nextLine();
StringTokenizer st = new StringTokenizer(s, " ");
while(st.hasMoreTokens())
{
String temp = st.nextToken(); 
n=Integer.parseInt(temp);
System.out.println(n);
sum+=n;
}
System.out.println("sum is " + sum);
}
}
// Output:
// Enter the integer separated by a space: 
// 1 2 3 
// 1
// 2
// 3
// sum is 6
