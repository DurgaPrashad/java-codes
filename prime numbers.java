//  Write a Java program that prompts the user for an integer and then prints out all 
// prime numbers up to that integer
// Program:
import java.util.Scanner;
public class Prime {
public static void main(String[] args) {
int i,j;
Scanner sc = new Scanner(System.in);
System.out.println("Enter the value of n ");
int n = sc.nextInt();
for (i = 2; i < n; i++) {
for ( j = 2; j < n; j++) {
if(i%j==0) break;
}
if(i==j) 
System.out.print(" " + i);
}
}
}
// Output:
// Enter the value of n 
// 8
// 2 3 5 7
