package com.hisense.frameanim;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class frameanim extends Activity
{
	ImageView mimage1,mimage2,mimage3;
	AnimationDrawable draw;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.frameimage);
		
        mimage1 = (ImageView)findViewById(R.id.frame_image);
       
        //StartAnim1(frameanim.this, R.anim.frame);     
   
		
        //mimage1.setBackgroundResource(R.anim.frame); 
        mimage1.setBackgroundResource(R.anim.frame); 
        
        draw = (AnimationDrawable) mimage1.getBackground();    
		  
	}
	
	
	@Override
	protected void onStart() 
	{
		// TODO Auto-generated method stub
		draw.start(); 
		super.onStart();
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		draw.stop(); 
		super.onDestroy();
	}


	/**
	 * image渐进慢慢出现
	 * @param mcontext
	 * @param animid
	 */
	public void StartAnim1(Context mcontext,int animid)
	{
		Animation anim = AnimationUtils.loadAnimation(mcontext,animid);
		mimage1.setAnimation(anim);
		anim.start();
	}
	
}