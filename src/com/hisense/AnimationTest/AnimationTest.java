package com.hisense.AnimationTest;

import com.android.silence.round.AnimRoundProcessDialog;
import com.hisense.InterpolatorTest.MainActivityMenu;
import com.hisense.InterpolatorTest.Myactivity;
import com.hisense.ListFlipper.ListFlipper;
import com.hisense.MyLayoutAnimation.MyLayoutAnimation;
import com.hisense.Rotate3D.RotateActivity;
import com.hisense.Rotate3d.Rotate3dActivity;
import com.hisense.TranslateAnimation.TranslateAnimationactivity;
import com.hisense.Turnimage.Turnimage;
import com.hisense.activityAnim.MainActivity;
import com.hisense.anim1.Anim1;
import com.hisense.frameanim.frameanim;
import com.hisense.image3D.Amagetext;
import com.hisense.imageanim.imageanim;
import com.hisense.layout3d.Layout3D;
import com.hisense.listviewanim.ListdemoActivity;
import com.hisense.shakeimage.shakeimageanim;
import com.hisense.shakelayout.ShakeDemoActivity;
import com.hisense.tweenanim.tweenanim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationTest extends Activity implements OnClickListener
{	
	Button mbutton1,mbutton2,mbutton3,mbutton4,mbutton5,mbutton6,mbutton7,mbutton8,mbutton9,mbutton10,
		   mbutton11,mbutton12,mbutton13,mbutton14,mbutton15,mbutton16,mbutton17,mbutton18;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        /*
        //去除title   
        requestWindowFeature(Window.FEATURE_NO_TITLE);   
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);  
        Display display = getWindowManager().getDefaultDisplay(); // 为获取屏幕宽、高
        Window window = getWindow();
        LayoutParams windowLayoutParams = window.getAttributes(); // 获取对话框当前的参数值
        //windowLayoutParams.width = 300;//(int) (display.getWidth() * 0.7); // 宽度设置为屏幕的0.95
        //windowLayoutParams.height = 500;//(int) (display.getHeight() * 0.5); // 高度设置为屏幕的0.6
        //windowLayoutParams.y= -400;
        windowLayoutParams.alpha = 0.9f;// 设置透明度 
        windowLayoutParams.dimAmount = 0.0f;      //设置黑暗度      
        getWindow().setAttributes(windowLayoutParams);     //设置生效  
        // getWindow().setGravity(Gravity.RIGHT);       //设置靠右对齐  
        int ID =  this.getResources().getIdentifier("text", "layout",this.getPackageName());  
        //setContentView(R.layout.text);    
        setContentView(ID);  
        */ 
        setContentView(R.layout.text); 
        InitView(); 
        //SimpleAdapter
    }
    
    public void InitView()
    {
        mbutton1 = (Button)findViewById(R.id.button1);
        mbutton2 = (Button)findViewById(R.id.button2);
        mbutton3 = (Button)findViewById(R.id.button3);
        mbutton4 = (Button)findViewById(R.id.button4);
        mbutton5 = (Button)findViewById(R.id.button5);
        mbutton6 = (Button)findViewById(R.id.button6);
        mbutton7 = (Button)findViewById(R.id.button7);
        mbutton8 = (Button)findViewById(R.id.button8);
        mbutton9 = (Button)findViewById(R.id.button9);
        mbutton10 = (Button)findViewById(R.id.button10);
        mbutton11 = (Button)findViewById(R.id.button11);
        mbutton12 = (Button)findViewById(R.id.button12);
        mbutton13 = (Button)findViewById(R.id.button13);
        mbutton14 = (Button)findViewById(R.id.button14);
        mbutton15 = (Button)findViewById(R.id.button15);
        mbutton16 = (Button)findViewById(R.id.button16);
        mbutton17 = (Button)findViewById(R.id.button17);
        mbutton18 = (Button)findViewById(R.id.button18);
        
        mbutton1.setOnClickListener(this);
        mbutton2.setOnClickListener(this);
        mbutton3.setOnClickListener(this);
        mbutton4.setOnClickListener(this);
        mbutton5.setOnClickListener(this);
        mbutton6.setOnClickListener(this);
        mbutton7.setOnClickListener(this);
        mbutton8.setOnClickListener(this);
        mbutton9.setOnClickListener(this);
        mbutton10.setOnClickListener(this);
        mbutton11.setOnClickListener(this);
        mbutton12.setOnClickListener(this);
        mbutton13.setOnClickListener(this);
        mbutton14.setOnClickListener(this);
        mbutton15.setOnClickListener(this);
        mbutton16.setOnClickListener(this);
        mbutton17.setOnClickListener(this);
        mbutton18.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.button1:
				onclick(Anim1.class);
				break;
			case R.id.button2:
				onclick(Amagetext.class);
				break;
			case R.id.button3:
				onclick(Layout3D.class);  
				break;
			case R.id.button4:
				onclick(ListFlipper.class);
				break;
			case R.id.button5:
				onclick(TranslateAnimationactivity.class);
				break;
			case R.id.button6:
				onclick(imageanim.class);
				break;
			case R.id.button7:
				onclick(MainActivity.class);
				break;  
			case R.id.button8:
				onclick(Rotate3dActivity.class);
				break;  
			case R.id.button9:
				onclick(ListdemoActivity.class);
				break;  
			case R.id.button10:
				onclick(tweenanim.class);
				break;  
			case R.id.button11:
				onclick(MyLayoutAnimation.class);
				break;  
			case R.id.button12:
				onclick(Myactivity.class);
				//onclick(MainActivityMenu.class);
				break;     
			case R.id.button13:
				onclick(frameanim.class);
				//onclick(MainActivityMenu.class);
				break;    
			case R.id.button14:
				onclick(shakeimageanim.class);
				//onclick(MainActivityMenu.class);
				break;   
			case R.id.button15:
				onclick(Turnimage.class);
				//onclick(MainActivityMenu.class);
				break;
			case R.id.button16:
				onclick(RotateActivity.class);
				//onclick(MainActivityMenu.class);
				break;
			case R.id.button17:
				onclick(ShakeDemoActivity.class);
				//onclick(MainActivityMenu.class);
				break;
			case R.id.button18:
				onclick(AnimRoundProcessDialog.class);
				//onclick(MainActivityMenu.class);
				break;
		}    
	}             
	
	private void onclick(Class<?> cls)
	{
		StartActivitybyp(AnimationTest.this, cls);  
	}
	
    private void StartActivitybyp(Context packageContext, Class<?> cls)  
    {
    	Intent intent = new Intent();
        intent.setClass(packageContext, cls); //利用Intent从Activity02.this跳转到OtherActivity.class
        startActivity(intent);  //启动这个请求Intent。
    }
    
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
		if (keyCode == KeyEvent.KEYCODE_BACK)   
		{
			finish();
			overridePendingTransition(R.anim.zoom_enter,R.anim.zoom_exit2);
			return false;
		}  
		
		return false;
	}
    
}