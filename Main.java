import java.util.*;
class maker extends Thread
{
    int c=3;
    LinkedList<Integer> link = new LinkedList<>();
    public void producer()
    {
        int val=0;
        while(true)
        {
        synchronized(this)
        {
            try
            {
                //System.out.println("=========== Starting Producing =================");
                    while(link.size()==c)
                    wait();
                    link.add(val);
                    System.out.println("Producer produce--->"+val);
                    val++;
                    notify();
                    Thread.sleep(500);
                  //  System.out.println("=========== Finishing Consuming =================");
                }catch(Exception e)
                {
                    System.out.println(e);
                }
        }
    }
    }
    public void consumer()
    {
        while(true)
        {
        synchronized(this)
        {
            try
            {
                //System.out.println("=========== Starting Consuming =================");
                    while(link.size()==0)
                    wait();
                    int val =link.removeLast();
                    System.out.println("Consumed--> "+val);
                    notify();
                    Thread.sleep(500);
                 //   System.out.println("=========== Finishing Consuming =================");
                }catch(Exception e)
                {
                    System.out.println(e);
                }
        }
    }
    }
}
public class Main
{
    public static void main(String args[])throws Exception
    {
        maker obj = new maker();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run()
            {
                obj.producer();
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run()
            {
                obj.consumer();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}