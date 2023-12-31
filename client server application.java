// Write a Java program that implements a simple client/server application. The client sends 
// data to a server. The server receives the data, uses it to produce a result, and then sends 
// the result back to the client. The client displays the result on the console. For ex: The data 
// sent from the client is the radius of a circle, and the result produced by the server is the 
// area of the circle. (Use java.net) 
// Program:
//Server.java
import java.io.*; 
import java.net.*; 
import java.util.*; 
public class Server 
{ 
public static void main (String args [ ] ) throws NullPointerException
{ 
try
{ 
// create a server socket 
ServerSocket s = new ServerSocket(8080); 
// start listening for connections on server socket 
Socket connectToClient = s.accept(); 
// create a buffered reader stream to get data from client 
BufferedReader isFromClient = new BufferedReader(new InputStreamReader 
(connectToClient.getInputStream())); 
// create a buffer reader to send result to client 
PrintWriter osToClient = new PrintWriter(connectToClient.getOutputStream(), true); 
// continuously read from client, process, send back 
while (true) 
{ 
// read a line and create string tokenizer 
StringTokenizer st = new StringTokenizer(isFromClient.readLine()); 
//convert string to double 
double radius = new 
Double(st.nextToken()).doubleValue(); 
// display radius on console 
System.out.println("Radius received from client: " + radius); 
// comput area 
double area = radius * radius *Math.PI; 
// send result to client 
osToClient.println(area); 
// print result on console 
System.out.println("Area found: " +area); 
} 
} 
catch (IOException e) 
{ 
System.err.println(e); 
} 
} 
}
//Client.java
import java.net.*;
import java.io.*;
public class Client
{
public static void main(String args[]) throws Exception
{
Socket s=new Socket("localhost",8080);
BufferedReader br=new 
BufferedReader(new InputStreamReader(System.in));
String rad;
System.out.println("Enter radius of the circle ");
rad=br.readLine();
PrintStream ps=new PrintStream(s.getOutputStream());
ps.println(rad);
BufferedReader fs=new 
BufferedReader(new InputStreamReader(s.getInputStream()));
String result=fs.readLine();
System.out.println("From Server : "+result);
br.close();
fs.close(); 
ps.close();
s.close();
}
}
