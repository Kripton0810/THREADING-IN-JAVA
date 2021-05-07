class Group extends Thread { 
    
    public synchronized void run()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println(i);
            if(i==6)
            {
                System.out.println("Current Thread state::->"+Thread.currentThread().getState());
            }
        }
    }
}  
public class MainGroup   
{  
    public static void main(String[] args)   
    {  
       Group g = new Group();
       Thread t1 = new Thread(g);
       System.out.println("Current Status:: "+t1.getState());
       t1.start();
       try
       {
           t1.join(100);
        }catch(Exception e)
        {}
       System.out.println("Current Status:: "+t1.getState());
       System.out.println("isAlive? Status:: "+t1.isAlive());
    }  
}  