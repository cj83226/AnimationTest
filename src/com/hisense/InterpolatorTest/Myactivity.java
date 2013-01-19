package com.hisense.InterpolatorTest;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 任意曲线
 * @author cj83226
 *
 */
public class Myactivity extends Activity implements AnimationListener
{
	TranslateAnimation translateAnimationx;
	TranslateAnimation translateAnimationy;
	AnimationSet animationSet;
	
	private ImageView chicken;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.interpolatormain2);    
		animationSet=new AnimationSet(false);//此处必须设为false
		//true表示应用AnimationSet的Interpolator效果，false表示应用各个动画对象自己的Interpolator效果
		/*
		translateAnimationx=new TranslateAnimation(
				 Animation.RELATIVE_TO_PARENT, -0.2f,
				 Animation.RELATIVE_TO_PARENT, 1f,
				 Animation.RELATIVE_TO_PARENT, 0f,
				 Animation.RELATIVE_TO_PARENT, 0f );
				 */
		translateAnimationx=new TranslateAnimation(
				 Animation.RELATIVE_TO_PARENT, 0.0f,
				 Animation.RELATIVE_TO_PARENT, 0.1f,
				 Animation.RELATIVE_TO_PARENT, 0f,
				 Animation.RELATIVE_TO_PARENT, 0f );
		translateAnimationx.setDuration(2000);  
		
		translateAnimationx.setAnimationListener(this);
		
		translateAnimationy=new TranslateAnimation(
				 Animation.RELATIVE_TO_PARENT, 0f,
				 Animation.RELATIVE_TO_PARENT, 0f,
				 Animation.RELATIVE_TO_PARENT, 0f,
				 Animation.RELATIVE_TO_PARENT, 0.2f );
		
			 
		translateAnimationy.setDuration(2000);
		translateAnimationy.setInterpolator(new MyInterpolator());
		
		animationSet.addAnimation(translateAnimationx);
		animationSet.addAnimation(translateAnimationy);
		
		chicken=(ImageView)findViewById(R.id.image1);
		chicken.setAnimation(animationSet);	
		
		animationSet.start();
		
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	  

}
