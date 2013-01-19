package com.hisense.tweenanim;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class tweenanim extends Activity 
{
	ImageView imgShow;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tweenanim);
		BtnClick btnClick = new BtnClick();   
		// �ƶ����䶯��
		Button btnTranslate = (Button) findViewById(R.id.btnTranslate);
		btnTranslate.setOnClickListener(btnClick);
		// ���Ų��䶯��
		Button btnScale = (Button) findViewById(R.id.btnScale);
		btnScale.setOnClickListener(btnClick);
		// ��ת���䶯��
		Button btnRotate = (Button) findViewById(R.id.btnRotate);
		btnRotate.setOnClickListener(btnClick);
		// ͸�����䶯��
		Button btnAlpha = (Button) findViewById(R.id.btnAlpha);
		btnAlpha.setOnClickListener(btnClick);
		imgShow = (ImageView) findViewById(R.id.imgShow);
		imgShow.setBackgroundResource(R.drawable.show);

	}

	class BtnClick implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			Animation animation = null;
			switch (arg0.getId()) {
			case R.id.btnTranslate:
				animation = new TranslateAnimation(0,50,0,50);				
				break;
			case R.id.btnScale:
				//��һ������Ϊx������ʼ��С(1f��ʾԭͼ��С)
				//�ڶ�������Ϊx������ֹ��С(0.2f��ʾԭͼ��0.2��)
				//����������ʾx�ᶯ������ķ�ʽ��ϵ���������0.5f��ʾ����x�������
				animation = new ScaleAnimation(1f,0.2f,1f,0.2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);			
				break;
			case R.id.btnRotate:
				animation = new RotateAnimation(360,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);				
				break;
			case R.id.btnAlpha:
				animation = new AlphaAnimation(1f,0.1f);
				break;
			default:
				break;
			}
						//��Ⱦ��  androidϵͳ�ṩ�˺ܶ���Ⱦ����Դ ͨ��android.R.anim.�ķ�ʽʹ��
			animation.setInterpolator(tweenanim.this,android.R.anim.anticipate_overshoot_interpolator);			
			//���ö�������ʱ��
			animation.setDuration(2000);
			imgShow.startAnimation(animation);

		}

	}
	

}