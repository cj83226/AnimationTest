package com.hisense.anim1;

import com.hisense.AnimationTest.R;
import com.hisense.AnimationTest.R.anim;
import com.hisense.AnimationTest.R.id;
import com.hisense.AnimationTest.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;



/**
 * image加载动画
 * @author cj83226
 *
 */
public class Anim1 extends Activity
{
	ImageView mimage1,mimage2,mimage3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		
		
        mimage1 = (ImageView)findViewById(R.id.image1);
        Animation ani = AnimationUtils.loadAnimation(this, R.anim.trans_anim);
             
        mimage2 = (ImageView)findViewById(R.id.image2);
        Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.trans_anim2);
             
        mimage3 = (ImageView)findViewById(R.id.image3);
        Animation ani3 = AnimationUtils.loadAnimation(this, R.anim.trans_anim3);
        
        mimage1.startAnimation(ani);
        mimage2.startAnimation(ani2);  
        mimage3.startAnimation(ani3);  
        
		
	}
	
}