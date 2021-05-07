public class question1 implements Runnable{
    char ch;
    question1(char ch)
    {
        this.ch = ch;
    }
    public synchronized void run()
    {
        System.out.println(Thread.currentThread().getName() + " is starting");
        for(int i =1;i<=5;i++)
        {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            try{
                Thread.sleep(100);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished");
    }
    public static void main(String[] args) {
        
        question1 a = new question1('A');
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        Thread t3 = new Thread(a);
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        System.out.println(t3.isAlive());
        t1.start();
        try{
                t2.join();
            }catch(Exception e)
            {
                System.out.println(e);
            }
        t2.start();
        try
        {
            t3.join();
        }
        catch (java.lang.InterruptedException ie)
        {
            ie.printStackTrace();
        }
        t3.start();
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        System.out.println(t3.isAlive());
        System.out.println(t3.isAlive());
    }
}
