package com.hisense.TranslateAnimation;
                       
import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class TranslateAnimationactivity extends Activity {  
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {               //重载onCreate方法  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.translateanimation);  
        
        final ImageView image=(ImageView)findViewById(R.id.image1); //ImageView对象  
        image.setImageResource(R.drawable.b1);
        Button btn1=(Button)findViewById(R.id.button1);             //按钮对象  
        Button btn2=(Button)findViewById(R.id.button2);  
        final Animation translateAnimation=new TranslateAnimation(0,800,0,800);                                                                 //移动动画效果  
               
        btn1.setOnClickListener(new View.OnClickListener() {            //设置监听器  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	Log.d("button1","1........................");
                translateAnimation.setDuration(3000);               //设置动画持续时间  
                translateAnimation.setFillAfter (true);             //保留在终止位置  
                translateAnimation.setFillEnabled(true);            //使能填充效果  
                //image.setAnimation(translateAnimation);             //设置动画效果  
                //translateAnimation.startNow();                      //启动动画  
                //translateAnimation.start(); 
                image.startAnimation(translateAnimation);
            }  
        });  
        
        btn2.setOnClickListener(new View.OnClickListener() {            //设置监听器  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
            	Log.d("button2","2........................");
                translateAnimation.cancel();                        //取消动画执行  
            }    
        });     
    }  
    }  