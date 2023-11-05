// Write a Java program that displays the number of characters,. lines and words in a text
// file.
// Program:
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class Counting {
public static void main(String[] args) throws Exception {
int linecount=0,wordcount=0,charcount=0;
Scanner sc = new Scanner(System.in);
System.out.println("Enter a file name ");
File f = new File(sc.nextLine());
BufferedReader br = new BufferedReader( new FileReader(f));
String curline = br.readLine();
while(curline != null){
String words[] = curline.split(" ");
wordcount+=words.length;
for(String word : words){
charcount+=word.length();
}
curline= br.readLine();
}
System.out.println("Number of characters in a file is : "+charcount);
System.out.println("Number of words in a file is : "+wordcount);
System.out.println("Number of lines in a file is : "+linecount);
}
}
// Output:
// Enter a file name 
// E:\charan\sample.txt
// Number of characters in a file is : 20
// Number of words in a file is : 3
// Number of lines in a file is : 3
