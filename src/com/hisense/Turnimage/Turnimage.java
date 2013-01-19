package com.hisense.Turnimage;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Turnimage extends Activity {
    /** Called when the activity is first created. */
	private ImageView imgView;
	private boolean bool = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turn);
        imgView = (ImageView) findViewById(R.id.imgView);
        imgView.setOnClickListener(new ImgViewListener());
    }
    //ImageView����¼�
    class ImgViewListener implements OnClickListener {
    	@Override
    	public void onClick(View v) {
    		// TODO Auto-generated method stub
    		/*Ҳ��ͨ�������ʵ��   ���������Ч��
    		AnimationSet animation = new AnimationSet(true);
    		ScaleAnimation scale = new ScaleAnimation(1, 0f, 1, 1f, 
    				Animation.RELATIVE_TO_SELF, 0.5f, 
    				Animation.RELATIVE_TO_SELF, 0.5f);
    		animation.addAnimation(scale);
    		animation.setDuration(150);
    		*/
    		//ͨ��AnimationUtils�õ����������ļ�(/res/anim/back_scale.xml)
    		Animation animation = AnimationUtils.loadAnimation(Turnimage.this, R.anim.back_scale);
    		animation.setAnimationListener(new Animation.AnimationListener() {
				@Override
				public void onAnimationStart(Animation animation) {  
				}
				@Override
				public void onAnimationRepeat(Animation animation) {
				}
				@Override
				public void onAnimationEnd(Animation animation) {
					if(bool){
						imgView.setImageResource(R.drawable.back2);
						bool = false;
					}else {
						imgView.setImageResource(R.drawable.front2);
						bool = true;
					}
					//ͨ��AnimationUtils�õ����������ļ�(/res/anim/front_scale.xml),Ȼ���ڰѶ�������ImageView
					imgView.startAnimation(AnimationUtils.loadAnimation(Turnimage.this, R.anim.front_scale));
				}
			});
    		imgView.startAnimation(animation);
    	}
    }
    
}