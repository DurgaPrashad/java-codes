// Write a Java program for sorting a given list of names in ascending order.
// Program :
import java.util.*;
class Sortst
{
public static void main(String a[])
{
System.out.println("How many string u want to enter");
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
String st[]=new String[n+1];
for(int i=0;i<n;i++)
{
System.out.println("Enter string "+(i+1));
st[i]=sc.next();
}
for(int i=0;i<n-1;i++)
{
for(int j=i+1;j<n;j++)
{
if(st[i].compareTo(st[j])>0)
{
String t=st[i];
st[i]=st[j];
st[j]=t;
}
}
}
System.out.println("Strings in order are :\n\n");
for(int i=0;i<n;i++)
System.out.println(st[i]);
}
}
// Output:
// How many string u want to enter
// 5
// Enter string 1
// madras
// Enter string 2
// delhi
// Enter string 3
// ahmedabad
// Enter string 4
// calcutta
// Enter string 5
// Bombay
// Strings in order are :
// ahmedabad
// bombay
// calcutta
// delhi
// madras
