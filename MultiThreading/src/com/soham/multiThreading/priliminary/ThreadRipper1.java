package com.soham.multiThreading.priliminary;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


//PROJECT #1
//First project to learn about Multi-threading .
 /* 1. used run method and passed an object to starting a separate thread.
  * 2. Passing a specific object t new instance of thread is very important 
  *    if , we need to work on same variables in all of threads.
  * 3. If thread is started without passing same object as compared to other threads , 
  *    we cannot get required functionality
  * 4. threads other than main thread requires time to be equipped with resources and 
  *    thus their execution will be slow (next project will prove it.)
*/
//note that run method can't return anything . 
//When thread s

public class ThreadRipper1 extends Thread {
    
	
	int a = 1 ;
	volatile int b = 4 ;

	// To log every activity in this queue instead of system.out.println
	volatile Map <Long, String> activityTracker = new HashMap<Long, String>();
	
	public ThreadRipper1()
	{
		System.out.println("Object of \"StaringThread\" is being created .....  ");
	}
	
	
	public static void main(String[] args) {
	
		try {
	    // Creating 1 st thread and object to pass to
		ThreadRipper1 t1 = new ThreadRipper1();
		Thread thread1 = new Thread(t1);
		
		// Creating 2 st thread and object to pass to
		ThreadRipper2 t2 = new ThreadRipper2();
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		//long d=0;
		for(int i = 0 ; i<10 ; i++)
			{//d=System.nanoTime();
		     t1.activityTracker.put(System.nanoTime(),"\t In Main  " + i);
		     // System.out.println("At "+System.nanoTime()+"    "+(System.nanoTime()-d)+"   "+"main  "+ t1.b);
			
			}
		
		System.out.println("PikaPika");
		while(thread2.isAlive())
		{
			Thread.currentThread();
			Thread.sleep(1);
			
		}
		if(!thread2.isAlive())
		{  t1.activityTracker.putAll(t2.activityTracker);
			
		   Map<Long,String>  sorted = new TreeMap<>(t1.activityTracker);
		  
		   Object[] keySet = sorted.keySet().toArray();
		                     
		              
		     for (int i=0; i<keySet.length-1 ;i++) 
		    {   
			   System.out.println(String.format("%03d", i)+"  At " +  keySet[i]+ "   "+
		                         ((Long) keySet[i+1]-(long)keySet[i])
					    + "  " + sorted.get(keySet[i]));
			   
		    }
		   
		   /*int i= 1; 
		   for (Map.Entry<Long, String> entry : sorted.entrySet()) {
			   
	            System.out.println(String.format("%03d", i)+"  At " + entry.getKey() 
					+ "  " + entry.getValue());
	            i++;
		}*/
		}
		
		
		
				}
		catch(Exception e)
		{   
			e.printStackTrace();
		}

	}
    

	public void run()
	{    
	   try {
		for(int i = 0 ; i<10 ; i++)
	       {
			
			b++ ;
			activityTracker.put(System.nanoTime(),"\t In Thread-1 "+i);
	       //System.out.println("\t In Thread1"  +"at  "+System.nanoTime() + "\t"+b);
	       }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
		
	}
}
