package com.hisense.image3D;

import android.util.Log;


public class CopyThread extends Thread
{ 
    	String src;
    	String des;
    	boolean flag =true;
    	
    	CopyThread(String src,String des)
    	{
    		this.src = src;
    		this.des = des;
    	}
    	 
        public void run() 
        { 
        	while(flag)
        	{
        		
        	}
        	//HLog.d("88888",""+Thread.currentThread().getName()); 
        	//DataServerManager.copyFile(src, des);
        	   
        }  
        
        public void setflag(boolean flag)
        {
        	
        }
} 