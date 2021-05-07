class ClassA extends Thread
{
    
    public void  run()
    {   
        int counter=0;
        for(int i =1;i<=5;i++)
        {
            try
        {
            Thread.sleep(10);
            counter++;
            }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(Thread.currentThread().getName()+"::"+counter);
        
        }
    }
    public static void main(String argsp[])
    {
        ClassA obj1 = new ClassA();
        ClassA obj2 = new ClassA();
        ClassA obj3 = new ClassA();
        ClassA obj4 = new ClassA();
        obj1.setPriority(1);
        obj2.setPriority(3);
        obj3.setPriority(5);
        obj4.setPriority(7);
        
        System.out.println("obj1 thread priority:: "+obj1.getPriority());
        System.out.println("obj2 thread priority:: "+obj2.getPriority());
        System.out.println("obj3 thread priority:: "+obj3.getPriority());
        System.out.println("obj4 thread priority:: "+obj4.getPriority());

        obj1.start();
        obj2.start();
        obj3.start();
        obj4.start();
        
    }
}