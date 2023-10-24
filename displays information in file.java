// Write a Java program that reads a file name from the user, then displays information 
// about whether the file exists, whether the file is readable, whether the file is writable, the 
// type of file and the length of the file in bytes.
// Program:
import java.io.*;
import java.util.*;
class Fileattr
{
public static void main(String args[])
{
Scanner sc= new Scanner(System.in);
System.out.println("Enter the file name ");
File f1=new File(sc.nextLine());
System.out.println(f1.exists()?"file exists":"does not exist");
System.out.println("Filename:"+f1.getName());
System.out.println("path "+f1.getPath());
System.out.println("Filepath "+f1.getAbsolutePath());
System.out.println(f1.isDirectory()?"is a directory":"is a simple file");
System.out.println(f1.canRead()?"can be read":"can not be read");
System.out.println(f1.canWrite()?"can be write":"can not be write");
System.out.println("length of file in bytes:"+f1.length());
System.out.println("file last modified "+f1.lastModified());
}
}
// Output:
// Enter the file name 
// E:\durga\sample.txt
// file exists
// Filename:sample.txt
// Path E:durga\sample.txt
// Filepath E:\durga\sample.txt
// is a simple file
// can be read
// can be write
// length of file in bytes:24
// file last modified 1490457071399
