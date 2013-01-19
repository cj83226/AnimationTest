package com.hisense.layout3d;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Layout3D extends Activity {

	private int mCenterX = 160;
	private int mCenterY = 0;
	private ViewGroup layout1;
	private ViewGroup layout2;

	private Rotate3d leftAnimation;
	private Rotate3d rightAnimation;
	
	//private Rotate3dAnimation leftAnimation;
	//private Rotate3dAnimation rightAnimation;
	
	private GestureDetector gestureDetector;
	private FlingGuest flingGuest;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		     
		initFirst();

		flingGuest = new FlingGuest(Layout3D.this);
		gestureDetector = new GestureDetector(Layout3D.this, flingGuest);
		
		layout1 = (ViewGroup) findViewById(R.id.layout1);
		//layout2 = (ViewGroup) findViewById(R.id.layout1);
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setEnabled(true);
		b1.requestFocus();
		b1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				leftMoveHandle();
				//v.setEnabled(false);
			}
		});
	}   
	
	public void initFirst()
	{
		leftAnimation = new Rotate3d(0, -90, 0.0f, 0.0f, mCenterX, mCenterY);
		rightAnimation = new Rotate3d(90, 0, 0.0f, 0.0f, mCenterX, mCenterY);
		//leftAnimation = new Rotate3dAnimation(0, -90, mCenterX, mCenterY,0,true);  
		//rightAnimation = new Rotate3dAnimation(90, 0, mCenterX, mCenterY,0,true);
		  
		leftAnimation.setFillAfter(true);   
		leftAnimation.setDuration(1000);  
		rightAnimation.setFillAfter(true);  
		rightAnimation.setDuration(1000);
	}
	
	public void initSecond()
	{
		leftAnimation = new Rotate3d(-90, 0, 0.0f, 0.0f, mCenterX, mCenterY);
		rightAnimation = new Rotate3d(0, 90, 0.0f, 0.0f, mCenterX, mCenterY);
		//leftAnimation = new Rotate3dAnimation(-90, 0,mCenterX, mCenterY,0,true);
		//rightAnimation = new Rotate3dAnimation(0, 90,mCenterX, mCenterY,0,true);
		leftAnimation.setFillAfter(true);
		leftAnimation.setDuration(1000);
		rightAnimation.setFillAfter(true);
		rightAnimation.setDuration(1000);
	}

	public void jumpToLayout1(Rotate3d leftAnimation) 
	{
		setContentView(R.layout.main1);  

		//layout2 = (ViewGroup) findViewById(R.id.layout1);
		layout1 = (ViewGroup) findViewById(R.id.layout1);
		layout1.startAnimation(leftAnimation);

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setEnabled(true);
		b1.requestFocus();
		b1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				leftMoveHandle();
			}
		});
	}

	public void jumpToLayout2(Rotate3d rightAnimation) 
	{
		setContentView(R.layout.mylayout);
		
		//layout1 = (ViewGroup) findViewById(R.id.layout2);
		layout2 = (ViewGroup) findViewById(R.id.layout2);
		layout2.startAnimation(rightAnimation);

		Button b2 = (Button) findViewById(R.id.button2);
		b2.setEnabled(true);
		b2.requestFocus();
		b2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				rightMoveHandle();
			}
		});
	}  

	public void leftMoveHandle() 
	{
		initFirst();
		layout1.startAnimation(leftAnimation);
		jumpToLayout2(rightAnimation);
	}

	public void rightMoveHandle() 
	{
		initSecond();
		layout2.startAnimation(rightAnimation);
		jumpToLayout1(leftAnimation);
	}
	
	@Override   
	public boolean dispatchTouchEvent(MotionEvent ev) 
	{
		super.dispatchTouchEvent(ev);
		return gestureDetector.onTouchEvent(ev);
	}
	
}