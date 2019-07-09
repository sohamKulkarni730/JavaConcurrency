package com.soham.multiThreading.priliminary;


import java.util.HashMap;
import java.util.Map;

public class ThreadRipper2 extends Thread
{
    int FirstInteger =0 ;
    int SecondInteger = 0;
    Map <Long, String> activityTracker = new HashMap<Long, String>();
	   
    public void run()
    {   
    	for (int i = 0 ; i< 10 ; i++)
    		activityTracker.put(System.nanoTime(),"\t In Thread-2 "+i);
    }
    
    void printAllTheThread ()
    {
    	ThreadGroup threads = System.getSecurityManager().getThreadGroup();
    	System.out.println(threads);
    	
    }
}
