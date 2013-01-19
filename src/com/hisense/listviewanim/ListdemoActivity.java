package com.hisense.listviewanim;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.hisense.AnimationTest.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 加载时有动画效果，滑动删除有动画效果
 * @author cj83226
 *
 */
public class ListdemoActivity extends Activity implements OnItemClickListener, OnTouchListener
{
	private ArrayList<Map<String, Object>> mData;
	ListView mListView;
	MyAdapter mAdapter;
	public Button mDeleteButton,mEditButton;
	float x , y , upx, upy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history_record);
		final Calendar c = Calendar.getInstance(); 		 
		int year = c.get(Calendar.YEAR);  
		int month = c.get(Calendar.MONTH);
		int day  = c.get(Calendar.DAY_OF_MONTH); 
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		String minutes = "";
		if (minute<10) 
		{
			minutes = "0"+minute;
		}
		String time_value = year+":"+month+":"+day+":"+hour+":"+ minutes;

		mData = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) 
		{	
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", R.drawable.ic_launcher);
			map.put("maxValue", "aaaa" + i);
			map.put("avgValue", "bbbb" + i);
			map.put("time", time_value);
			map.put("how_time", "cccc: " + i);
			map.put("last_time", "dddd");
			map.put("isVisible", false);
			mData.add(map);

		}		
		mAdapter = new MyAdapter(this);
		mListView = (ListView)findViewById(R.id.list);
		mListView.setCacheColorHint(Color.TRANSPARENT);	
		mListView.setAdapter(mAdapter);
		mListView.setOnTouchListener(this);
		mListView.setOnItemClickListener(this);
		mListView.setLayoutAnimation(getListAnim());
		
	}
	
	private LayoutAnimationController getListAnim() 
	{
		AnimationSet set = new AnimationSet(true);
		Animation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(300);
		set.addAnimation(animation);

		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
		Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
		-1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(500);
		set.addAnimation(animation);
		LayoutAnimationController controller = new LayoutAnimationController(set, 0.5f);
		return controller;
	}

	class ViewHolder {
		public TextView maxValue;
		public Button del_btn;
		public TextView how_time;
		public TextView last_time;
		public TextView  avgValue;
		public ImageView image;
		public boolean isVisible = true;
	}
	
	public class MyAdapter extends BaseAdapter {    
		private Context mContext;
		private MyAdapter(Context context) {
			mContext = context;
		}

		public int getCount() {
			return mData.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(final int position, View convertView, ViewGroup parent) 
		{
			ViewHolder holder = null;
			if(convertView == null) 
			{
				holder = new ViewHolder();
				LayoutInflater inflater = LayoutInflater.from(mContext);
				convertView = inflater.inflate(R.layout.record_info, null);
				holder.del_btn = (Button) convertView.findViewById(R.id.del);
				holder.how_time = (TextView) convertView.findViewById(R.id.how_time);
				holder.last_time = (TextView) convertView.findViewById(R.id.last_time);
				holder.avgValue = (TextView) convertView.findViewById(R.id.avgValue);
				holder.image = (ImageView)convertView.findViewById(R.id.image);
				holder.maxValue = (TextView)convertView.findViewById(R.id.maxValue);
				convertView.setTag(holder);
			} 
			else 
			{
				holder = (ViewHolder)convertView.getTag();
			}
			
			holder.image.setBackgroundResource((Integer)mData.get(position).get("image"));
			holder.del_btn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					mData.remove(position);
					mAdapter.notifyDataSetChanged();  

				}
			});
			holder.how_time.setText((String)(mData.get(position).get("time")));           
			holder.last_time.setText((String)(mData.get(position).get("last_time")));          
			holder.avgValue.setText((String)(mData.get(position).get("avgValue")));    		
			holder.maxValue.setText((String)(mData.get(position).get("maxValue")));
			return convertView;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, final int position,
			long id) {
		new AlertDialog.Builder(ListdemoActivity.this).setTitle("onItemClick")
		.setMessage("onItemClick").setPositiveButton("ok",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,
					int whichButton) {
				mData.remove(position);
				mAdapter.notifyDataSetChanged();
			}
		}).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				System.out.println("nnn");
			}
		}).show();
	}
	
	protected void removeListItem(View rowView, final int positon) 
	{        
        final Animation animation = (Animation) AnimationUtils.loadAnimation(rowView.getContext(), R.anim.item_anim); 
                                                
        animation.setAnimationListener(new AnimationListener() { 
            public void onAnimationStart(Animation animation) {} 
            public void onAnimationRepeat(Animation animation) {} 
            public void onAnimationEnd(Animation animation) { 
                mData.remove(positon); 
                mAdapter.notifyDataSetChanged(); 
                animation.cancel(); 
            } 
        }); 
         
        rowView.startAnimation(animation); 
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		 	
		 if (event.getAction() == MotionEvent.ACTION_DOWN) { 
             x = event.getX(); 
             y = event.getY(); 
             Log.v("@@@@@@", "is on touch down x = " + x + " ,y = " + y);
         } 
         if (event.getAction() == MotionEvent.ACTION_UP) { 
             upx = event.getX(); 
             upy = event.getY(); 
             int position1 = ((ListView) v).pointToPosition((int) x, (int) y); 
             int position2 = ((ListView) v).pointToPosition((int) upx,(int) upy); 
             
             Log.v("@@@@@@", "is on touch x = " + x + " ,y = " + y);
             Log.v("@@@@@@", "is on touch upx = " + upx + " ,upy = " + upy);
             
             Log.v("@@@@@@", "is on touch positon1 = " + position1 + " ,position2 = " + position2);
              
             if (position1 == position2 && Math.abs(x - upx) > 10) { 
                 View view = ((ListView) v).getChildAt(position1); 
                 removeListItem(view, position1); 
             } 
         } 
		
		return false;
	} 

}
