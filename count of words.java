// Write a Java program to make frequency count of words in a given text. 
// Program:
import java.util.*;
class Freqcont
{
public static void main(String a[])
{
int i=0;
System.out.println("Enter any sentence");
String s=new Scanner(System.in).nextLine();
StringTokenizer st=new StringTokenizer(s," ");
while(st.hasMoreTokens())
{
st.nextToken();
i++;
}
System.out.println("The words frequency is : "+i);
}
}
// Output:
// Enter any sentence
// My name is charan
// The words frequency is : 4
