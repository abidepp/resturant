package menu;



import java.util.ArrayList;

import com.example.restraunt.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CustomAdapter2 extends ArrayAdapter
{

	ArrayList<Food> fd = null;
	Context context;
	public CustomAdapter2(Context context, ArrayList<Food> foodlist) {
		super(context,R.layout.starter_veg_row,foodlist);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.fd = foodlist;
	}



	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		convertView = inflater.inflate(R.layout.starter_veg_row, parent, false); 
		TextView name = (TextView) convertView.findViewById(R.id.textView1);
		CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
		name.setText(fd.get(position).getName());
		if(fd.get(position).getValue() == 1)
		{
			cb.setChecked(true);
			cb.setOnCheckedChangeListener(null);
		}
		else
		{
			cb.setChecked(false);
			cb.setOnCheckedChangeListener(null);
		}
		return convertView;
	}



}



