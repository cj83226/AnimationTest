package com.hisense.image3D;

import com.hisense.AnimationTest.R;
import com.hisense.AnimationTest.R.drawable;
import com.hisense.AnimationTest.R.id;
import com.hisense.AnimationTest.R.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;




public class Amagetext extends Activity implements OnClickListener
{
	ImageView mimage1;
	Button mbutton1;
	Button mbutton2;
	LinearLayout mlayout;
	float i=0f;
	private int degrean = 0;
	boolean flag =true;
	float degress =0f;
	private Context context ;  
    private Bitmap showBmp ;  
    private Matrix matrix ; //作用矩阵  
    private Camera camera ;   
    private int deltaX , deltaY ; //翻转角度差值  
    private int centerX , centerY ; //图片中心点 
    CopyThread mthread;
	Handler myhandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.imagetext);
		
		mlayout = (LinearLayout)findViewById(R.id.layout1);
		mbutton1 = (Button)mlayout.findViewById(R.id.button1);
        mbutton2 = (Button)mlayout.findViewById(R.id.button2);
        mimage1 = (ImageView)findViewById(R.id.image1);
        if(mimage1==null)
        {
        	Log.i("chens", "null..............................");
        }
        mbutton1.setOnClickListener(this);  
        mbutton2.setOnClickListener(this);
        
        myhandler = new MyHandler();  
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
			case R.id.button1:
				//onclick1((i++)+50);
				if(flag)
				{
					mthread =new CopyThread();
					mthread.start();
					flag = false;
				}
				else
				{
					mthread.setflag(flag);
					flag = true;
				}
				//turnLeft();
				break;
			case R.id.button2:
				//onclick2(30f+i++*5);
				//image自动绕Y轴旋转
				if(flag)
				{
					mthread =new CopyThread();
					mthread.start();
					flag = false;
				}
				else
				{
					mthread.setflag(flag);
					flag = true;
				}
				break;  
		}
		
	}  
	
	
	private void onclick1(float i)  
	{
		// 1、首先加载要操作的图片
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b1);
		
		//2、得到以上加载图片的高度跟宽度
		int height = bitmap.getHeight(); 
		int width = bitmap.getWidth();
		
		//3、定义要缩放成最终的图片高度跟宽度  
		int nHeight = 150; 
		int nWidth = 180;
		//4、计算缩放比例
		float scaleWidth = ((float) nWidth)/width; 
		float scaleHeight = ((float) nHeight)/height;
		//5、创建Matrix对象 Matrix是在Android中用于操作图像的类
		Matrix matrix = new Matrix();
		//6、使用Matrix对象跟缩放比例实现缩放图片
		matrix.postScale(scaleWidth, scaleHeight);
		//同样的，图片旋转只需要通过Matrix改变图片角度即可，生成图片跟7相同。
		Log.i("chens", "======i======"+i);
        
		Camera camera=new Camera();
		camera.save();
		camera.rotateY(i);  
		//camera.rotateX(degress);
		camera.getMatrix(matrix);
		camera.restore();
		
		//7、生成缩放后的图片
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,width, height, matrix, true);
		
		Message message = new Message();   
		message.what = 1;   
		message.obj=resizedBitmap;  
           
		myhandler.sendMessage(message);
          
	}
	 
	 
	 public class CopyThread extends Thread
	 { 
	     	boolean flag =true;
	     	
	     	CopyThread()
	     	{
	     		  
	     	}
	     	 
	         public void run() 
	         { 
	         	while(flag)
	         	{
	         		try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	         		
	         		
		    		if(degress<180f)
		    		{
		    			degress+=10;
		    		}
		    		else
		    		{
		    			degress=0;
		    		}
		    		
		    		if(degress == 90f)
		    		{
		    			degress++;
		    		}
	         	
		    		//Yroate(degress);
		    		onclick1(degress);
	         	}
	         	
	         	   
	         }  
	         
	         public void setflag(boolean flag)
	         {
	         	this.flag = flag;
	         }
	 } 
	 
	 
	 private void Yroate(float degress)
	 {
		 Bitmap bmp=BitmapFactory.decodeResource(getResources(),R.drawable.b1);  

 		Matrix matrix=new Matrix();
 		System.out.println("martrix:"+degress);
 		Camera camera=new Camera();
 		camera.save();
 		camera.rotateY(degress);  
 		//camera.rotateX(degress);
 		camera.getMatrix(matrix);
 		camera.restore();
 		
 		System.out.println("martrix1:"+matrix.toString());

 		//int centerX=mimage1.getWidth()/2;
 		//int centerY=mimage1.getHeight()/2;
 		
 		//matrix.preTranslate(-this.centerX, -this.centerY);  
         //matrix.postTranslate(this.centerX, this.centerY);  
         
 		Bitmap bmp1=Bitmap.createBitmap(bmp,0,0,bmp.getWidth(),bmp.getHeight(),matrix,true);
 		System.out.println("martrix1:"+matrix.toString());

 		//mimage1.setImageBitmap(bmp1);
 		
 		Message message = new Message();   
         message.what = 1;   
         message.obj=bmp1;
         
         myhandler.sendMessage(message);
	 }
	 
	 public class MyHandler extends Handler
	 {

		@Override
		public void handleMessage(Message msg) 
		{
			// TODO Auto-generated method stub
			
			 switch (msg.what) 
			 {   
             	case 1:   
             		mimage1.setImageBitmap((Bitmap)msg.obj);  
                  break;     
			 }     
			 
			super.handleMessage(msg);
			
			
		}
		 
	 }

	@Override
	protected void onDestroy() 
	{
		// TODO Auto-generated method stub
		if(mthread!=null)
		{
			flag = false;
			mthread.setflag(flag);
		}
		
		super.onDestroy();
		
		
	}

	@Override
	protected void onStop() 
	{
		// TODO Auto-generated method stub
		if(mthread!=null)
		{
			flag = false;
			mthread.setflag(flag);
		}
		super.onStop();
	}
	 
	 
	
}