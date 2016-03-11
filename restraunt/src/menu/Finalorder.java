package menu;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List; 

import android.R.array;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.restraunt.R;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;





public class Finalorder extends Activity implements OnItemSelectedListener{


	ListView lv1;
	ListView lv2;
	ListView lv3;
	Button btn;
	ArrayList<String> resultArray ;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.final_order);
		Log.i("rendered layout", "entered");
		// Spinner element
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		lv1 = (ListView) findViewById(R.id.listView1);
		lv2 = (ListView) findViewById(R.id.listView1);
		lv3 = (ListView) findViewById(R.id.listView1);
		btn= (Button) findViewById(R.id.confirm);

		// Spinner click listener
		spinner.setOnItemSelectedListener(this);
		Log.i("spinnerclick", "listened");
		// Spinner Drop down elements
		List<String> categories = new ArrayList<String>();
		categories.add("Butterscotch");
		categories.add("coco-cola");
		categories.add("pepsi");
		categories.add("vannila milkshake");
		categories.add("Sprite");
		categories.add("Mountain Dew");

		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
		Log.i("spinner created", ":d");
		// Drop down layout style - list view with radio button
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner.setAdapter(dataAdapter);
		Log.i("spinnerdisplayed", "two");



		 resultArray = getIntent().
				getStringArrayListExtra("strings");
		Toast.makeText(getApplicationContext(), ""+(getIntent().
				getStringArrayListExtra("strings")), Toast.LENGTH_SHORT).show(); 
		Toast.makeText(getApplicationContext(), "Array"+resultArray.size(), Toast.LENGTH_SHORT).show(); 
		Log.i("list received", resultArray.toString());

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
				this, 
				android.R.layout.simple_list_item_1,
				resultArray);

		lv1.setAdapter(arrayAdapter); 
		Log.i("list displayed", "four");
	}

	
	public void onConfirm(View v)
	{
		Log.i("confirm", "entered");
		final AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
		alertDialog.setTitle("Confirm");
		alertDialog.setMessage("can we confirm your order");
		

		alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Add your code for the button here.
				Toast.makeText(getApplicationContext(), "well come", 1).show();
				Intent i = new Intent(getApplicationContext(),DisplaySuccess.class);
				startActivity(i);
				
				
				}
		
		});
		alertDialog.setNegativeButton("cancel",new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "you have pressed cancel", 1).show();
			}
		});
		alertDialog.show();
	}
		



@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
	// On selecting a spinner item
	String item = parent.getItemAtPosition(position).toString();

	// Showing selected spinner item
	Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
}
public void onNothingSelected(AdapterView<?> arg0) {
	// TODO Auto-generated method stub
}





}
