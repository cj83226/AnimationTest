package com.hisense.MyLayoutAnimation;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

public class MyLayoutAnimation extends Activity 
{
	LayoutAnimationController controller = null;
	Bundle extras;

	public void onCreate(Bundle saveInstanceState) 
	{
		super.onCreate(saveInstanceState);
		// setContentView(R.layout.sales_memo_list);
  
		LayoutInflater factory = LayoutInflater.from(this);
		final LinearLayout dialogEntryView = (LinearLayout) factory.inflate(R.layout.main, null);
		
		controller = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_left_in);
			
		dialogEntryView.setLayoutAnimation(controller);
	  
		setContentView(dialogEntryView);
	}

}
