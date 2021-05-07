class clasobj implements Runnable {
	public void run() { 
	    Lock(); 
	   }

	public void Lock()
	{
		System.out.println(Thread.currentThread().getName());
		synchronized (this)
		{
			System.out.println("in block "+ Thread.currentThread().getName());
			System.out.println("in block "+Thread.currentThread().getName()+ " end");
		}
	}

	public static void main(String[] args)
	{
		clasobj c1 = new clasobj();
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c1);
		clasobj g2 = new clasobj();
		Thread t3 = new Thread(g2);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
