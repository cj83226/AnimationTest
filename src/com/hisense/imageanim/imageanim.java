package com.hisense.imageanim;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

   


public class imageanim extends Activity
{
	ImageView mimage1,mimage2,mimage3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.imageanim);
		
        mimage1 = (ImageView)findViewById(R.id.image1);
       
       // StartAnim1(imageanim.this, R.anim.fade_in);     
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        findViewById(R.id.image1).startAnimation(shake);
		
             
        
		  
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