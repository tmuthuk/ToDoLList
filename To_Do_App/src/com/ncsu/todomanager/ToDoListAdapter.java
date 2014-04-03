package com.ncsu.todomanager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ncsu.todomanager.ToDoItem.Status;

public class ToDoListAdapter extends BaseAdapter {

	// List of ToDoItems
	private final List<ToDoItem> mItems = new ArrayList<ToDoItem>();
	
	private final Context mContext;

	private static final String TAG = "Lab-UserInterface";
	LayoutInflater mInflater=null;
	public ToDoListAdapter(Context context) {

		mContext = context;
		
		
		mInflater = LayoutInflater.from(context);

	}

	// Add a ToDoItem to the adapter
	// Notify observers that the data set has changed

	public void add(ToDoItem item) {

		mItems.add(item);
		notifyDataSetChanged();

	}
	
	// Clears the list adapter of all items.
	
	public void clear(){

		mItems.clear();
		notifyDataSetChanged();
	
	}

	// Returns the number of ToDoItems

	@Override
	public int getCount() {

		return mItems.size();

	}

	// Retrieve the number of ToDoItems

	@Override
	public Object getItem(int pos) {

		return mItems.get(pos);

	}

	// Get the ID for the ToDoItem
	// In this case it's just the position

	@Override
	public long getItemId(int pos) {

		return pos;

	}

	//Create a View to display the ToDoItem 
	// at specified position in mItems

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {


		
		final ToDoItem toDoItem = this.mItems.get(position);

		
		
		RelativeLayout itemLayout = null;
		
		convertView = mInflater.inflate(R.layout.todo_item,parent,false);
		itemLayout = (RelativeLayout) convertView.findViewById(R.id.RelativeLayout1);
		final TextView titleView = (TextView) convertView.findViewById(R.id.titleView);
		titleView.setText(toDoItem.getTitle());
		final CheckBox statusView = (CheckBox) convertView.findViewById(R.id.statusCheckBox);
				statusView.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				log("Entered onCheckedChanged()");
				
				// TODO - Set up and implement an OnCheckedChangeListener, which 
				// is called when the user toggles the status checkbox
				if(statusView.isChecked()){
					
				}
				else{
					
				}

			
			}
		});

		

		final TextView priorityView = (TextView) convertView.findViewById(R.id.priorityView);
		priorityView.setText(toDoItem.getPriority().toString());

		
		// TODO - Display Time and Date. 
		

		final TextView dateView = null;
				

		// Return the View you just created
		return itemLayout;

	}
	
	private void log(String msg) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.i(TAG, msg);
	}

}
