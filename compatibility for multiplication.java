// Write a java program to check the compatibility for multiplication, if compatible 
// multiply two matrices and find its transpose.
// Program:
import java.util.*;
public class MatrixMultiplication {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Provide the size of the first matrix :");
int a = sc.nextInt();
int a1 = sc.nextInt();
System.out.println("Provide the size of the first matrix :");
int b = sc.nextInt();
int b1 = sc.nextInt();
if(a1 != b){
System.out.println("rows are not equal to columns multiplication not possible");
}
else{
new matrix(a,a1,b,b1);
} 
} 
}
class matrix{
int a[][];
int b[][];
int result[][];
int transpose[][];
public matrix(int a, int a1, int b,int b1){
this.a = new int[a][a1];
this.b = new int[b][b1];
this.result = new int[a][b1];
this.transpose= new int[b1][a];
System.out.println("the matrix has been created");
System.out.println("Initialization of the matrizes");
Scanner sc = new Scanner(System.in);
System.out.println("MAtrix A :");
for(int i = 0; i < a; i++){
for(int j = 0; j < a1; j++){
this.a[i][j] = sc.nextInt();
}
}
System.out.println("MAtrix B :");
for(int i = 0; i < b; i++){
for(int j = 0; j < b1; j++){
this.b[i][j] = sc.nextInt();
}
}
for(int i = 0; i < a; i++){
for(int j = 0; j < b1; j++){
result[i][j] = 0;
transpose[j][i]=0;
for(int k = 0; k < a1; k++){
result[i][j] += this.a[i][k]*this.b[k][j];
}
}
}
System.out.println("Multiplication is..");
for(int i = 0; i < a; i++){
for(int j = 0; j < b1; j++){
this.transpose[j][i]=this.result[i][j];
System.out.print(" "+this.result[i][j]);
}
System.out.println();
} 
System.out.println("\nTranspose is ..");
for(int j = 0; j < b1; j++){
for(int i = 0; i < a; i++){
System.out.print(" "+this.transpose[j][i]);
}
System.out.println();
} 
}
}
// Output:
// Provide the size of the first matrix :
// 2
// 2
// Provide the size of the first matrix :
// 2
// 2
// the matrix has been created
// Initialization of the matrizes
// MAtrix A :
// 1
// 2
// 3
// 4
// MAtrix B :
// 1
// 2
// 3
// 4
// Multipliccation is..
// 7 10
// 15 22
// Transpose is ..
// 7 15
// 10 2
