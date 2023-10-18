// a) Write a Java program that prints all real solutions to the quadratic equation ax2+ bx 
// + c = 0. Read in a, b, c and use the quadratic formula. If the discriminate b2-4ac is 
// negative, display a message stating that there are no real solutions.
// Program:
import java.util.Scanner;
public class Quadratic {
public static void main(String[] args) {
int a,b,c,d;
double r1,r2;
Scanner sc = new Scanner(System.in);
System.out.println("Enter a,b,c");
  a = sc.nextInt();
  b = sc.nextInt();
  c = sc.nextInt();
  d = (b*b)-(4*a*c);
  if(d>0) {
  System.out.println("Roots are real and unequal");
  r1 = (-b+Math.sqrt(d))/2*a;
  r2 = (-b-Math.sqrt(d))/2*a;
  System.out.println("Roots are "+r1+" ,"+r2);
  }
  if(d==0) {
  System.out.println("Roots are real and equal");
  r1 = r2=-b/2*a;
    System.out.println("Roots are "+r1+" ,"+r2);
  }
  if(d<0)
 System.out.println("Roots are imaginary ");
 }
}
// Output:
// Enter a,b,c
// 1
// 9
// 3
// Roots are real and unequal
// Roots are -0.34668806854096257 ,-8.653311931459037
