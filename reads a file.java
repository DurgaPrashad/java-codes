//  Write a Java program that reads a file and displays the file on the screen, with a line 
// number before each line.
// Program:
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
public class Line {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
System.out.println("Enter a file name ");
File f = new File(sc.nextLine());
if(f.exists()){
BufferedReader br = new BufferedReader(new FileReader(f));
int lineno = 0;
String line = br.readLine();
while(line!=null){
lineno++;
System.out.println(lineno+" . "+line);
line = br.readLine();
}
}
}
}
// Output:
// Enter a file name 
// E:\charan\sample.txt
// 1 . Hello
// 2 . Java
// 3 . Programmers
