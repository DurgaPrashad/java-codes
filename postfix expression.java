// . Write a Java program that Evaluates the postfix expression
// Program:
package charan;
import java.io.*;
import java.util.Scanner;
class Stack
{
 private int[] a;
 private int top,m;
 public Stack(int max)
 {
 m=max;
 a=new int[m];
 top=-1;
 }
 public void push(int key)
 {
 a[++top]=key;
 }
 public int pop()
 {
 return(a[top--]);
 }
}
class Evaluation{
 public int calculate(String s)
 {
 int n,r=0;
 n=s.length();
 Stack a=new Stack(n);
 for(int i=0;i<n;i++)
 {
 char ch=s.charAt(i);
 if(ch>='0'&&ch<='9')
 a.push((int)(ch-'0'));
 else
 {
 int x=a.pop();
 int y=a.pop();
 switch(ch)
 {
 case '+':r=x+y;
 break;
 case '-':r=y-x;
 break;
 case '*':r=x*y;
 break;
 case '/':r=y/x;
 break;
 default:r=0;
 }
 a.push(r);
 }
 }
 r=a.pop();
 return(r);
 }
}
class PostfixEvaluation
{
 private static Scanner sc;
public static void main(String[] args)throws IOException
 {
 String input;
 while(true){
 System.out.println("Enter the postfix expresion");
 sc = new Scanner(System.in);
 input=sc.nextLine();
 if(input.equals("")) break;
 Evaluation e=new Evaluation();
 System.out.println("Result: "+e.calculate(input));
 }
 }
}
// Output:
// Enter the postfix expresion
// 123+*
// Result: 5
