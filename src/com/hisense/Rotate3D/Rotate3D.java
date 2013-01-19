package com.hisense.Rotate3D;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3D extends Animation 
{
	private float fromDegree;	// 旋转起始角度
	private float toDegree;		// 旋转终止角度
	private float mCenterX;		// 旋转中心x
	private float mCenterY;		// 旋转中心y
	private Camera mCamera;
	private String strname;

	public Rotate3D(float fromDegree, float toDegree, float depthZ, float centerX, float centerY,String strname) 
	{
		this.fromDegree = fromDegree;
		this.toDegree = toDegree;
		this.mCenterX = centerX;
		this.mCenterY = centerY;
		this.strname = strname;
	}

	@Override
	public void initialize(int width, int height, int parentWidth, int parentHeight) 
	{
		super.initialize(width, height, parentWidth, parentHeight);
		mCamera = new Camera();
	}


	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) 
	{
		Log.d("wwwwwwwwww777777777","applyTransformation....................."+strname);
		final float FromDegree = fromDegree;
		float degrees = FromDegree + (toDegree - fromDegree) * interpolatedTime;	// 旋转角度（angle）
		final float centerX = mCenterX;
		final float centerY = mCenterY;
		final Matrix matrix = t.getMatrix();
		

		if (degrees <= -76.0f) {
			degrees = -90.0f;
			mCamera.save();
			mCamera.rotateY(degrees);		// 旋转
			mCamera.getMatrix(matrix);
			mCamera.restore();
		} else if (degrees >= 76.0f) {
			degrees = 90.0f;
			mCamera.save();
			mCamera.rotateY(degrees);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		} else {
			mCamera.save();
			mCamera.translate(0, 0, centerX);		// 位移x
			mCamera.rotateY(degrees);
			mCamera.translate(0, 0, -centerX);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		}

		matrix.preTranslate(-centerX, -centerY);
		matrix.postTranslate(centerX, centerY);
	}

	@Override
	public void cancel() 
	{
		// TODO Auto-generated method stub
		super.cancel();
		
		Log.d("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu","cancel....................."+strname);
	}
	
	
	
	
}



