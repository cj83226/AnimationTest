package com.hisense.InterpolatorTest;

import android.util.Log;
import android.view.animation.Interpolator;

public class MyInterpolator implements Interpolator
{

	@Override
	public float getInterpolation(float i) 
	{
		// TODO Auto-generated method stub
		//i的范围0-1
		Log.d("MyInterpolator","i="+i);
		//return 1-(i-1)*(i-1); 
		//return 2*i-2*i+1;
		return 2*i*i;
	}  

}