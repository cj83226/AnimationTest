package com.hisense.Rotate3d;


import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class Rotate3dActivity extends Activity implements View.OnClickListener{
	private ViewGroup mContainer;
	private ImageView imageView1;
	private ImageView imageView2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotate3d);
        mContainer = (ViewGroup)findViewById(R.id.container);
        imageView1 = (ImageView)findViewById(R.id.imageview1);
        imageView2 = (ImageView)findViewById(R.id.imageview2);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        
        mContainer.setPersistentDrawingCache(ViewGroup.PERSISTENT_ANIMATION_CACHE);
    }

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.imageview1:  
			applyRotation(0,90,R.id.imageview1);
			break;
		case R.id.imageview2:
			applyRotation(0,90,R.id.imageview2);
			break;
		default:
			break;
		}
	}
	private void applyRotation(float start, float end, final int viewId){
		final float centerX = mContainer.getWidth() / 2.0f;
        final float centerY = mContainer.getHeight() / 2.0f;
        Rotate3dAnimation rotation =
            new Rotate3dAnimation(start, end, centerX, centerY, 200.0f, true);
        rotation.setDuration(500);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation arg0) {

				mContainer.post(new Runnable() {
					@Override
					public void run() {
						if(viewId == R.id.imageview1){
							imageView1.setVisibility(View.GONE);
							imageView2.setVisibility(View.VISIBLE);
						}else if (viewId == R.id.imageview2) {
							imageView2.setVisibility(View.GONE);
							imageView1.setVisibility(View.VISIBLE);
						}
						Rotate3dAnimation rotatiomAnimation = new Rotate3dAnimation(-90, 0, centerX, centerY, 200.0f, false);
						rotatiomAnimation.setDuration(500);
						rotatiomAnimation.setInterpolator(new DecelerateInterpolator());
						
						mContainer.startAnimation(rotatiomAnimation);
					}
				});
			
			}
			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationStart(Animation arg0) {
			}
        });
        mContainer.startAnimation(rotation);
	}
}