// . Write a Java program that correctly implements producer consumer problem using 
// the concept of inter thread communication.
// Program:
class Thread1
{
 int num;
 boolean vs=false;
 synchronized int get()
 {
 if (!vs)
 try
 {
 wait();
 }
 catch (Exception e)
 {
 System.out.println("Excepton occurs at : "+e);
 }
 System.out.println("get" +num);
 try
 {
 Thread.sleep(1000);
 }
 catch (Exception e)
 {
 System.out.println("Excepton occurs at : "+e);
 }
 vs=false;
 notify();
 return num;
 }
 synchronized int put(int num)
 {
 if (vs)
 try
 {
 wait();
 }
 catch (Exception e)
 {
 System.out.println("Excepton occur at : "+e);
 }
 this.num=num;
 vs=true;
 System.out.println("put"+num);
 try
 {
 Thread.sleep(1000);
 }
 catch (Exception e)
 {
 System.out.println("Excepton occur at : "+e);
 }
 notify();
 return num;
 }
}
class Producer implements Runnable
{
 Thread1 t;
 Producer(Thread1 t)
 {
 this.t=t;
 new Thread(this,"Producer").start();
 }
 public void run()
 {
 int x=0;
 int i = 0;
 while (x<10)
 {
 t.put(i++);
 x++;
 }
 }
}
class Consumer implements Runnable
{
 Thread1 t;
 Consumer(Thread1 t)
 {
 this.t=t;
 new Thread(this,"Consumer").start();
 }
 public void run()
 {
 int x=0;
 while (x<10)
 {
 t.get();
 x++;
 }
 }
}
class ProducerConsumer
{
 public static void main(String[] args)
 {
 Thread1 t=new Thread1();
 new Producer(t);
 new Consumer(t);
 }
}
// Output:
// put0
// get0
// put1
// get1
// put2
// get2
// put3
// get3
// put4
// get4
// put5
// get5
// put6
// get6
// put7
// get7
// put8
// get8
// put9
get9
