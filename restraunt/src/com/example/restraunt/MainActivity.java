package com.example.restraunt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import menu.Startervegpoc;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText name;
	EditText email;
	EditText mobile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name = (EditText) findViewById(R.id.editText1);
		email= (EditText) findViewById(R.id.editText2);
		mobile = (EditText) findViewById(R.id.editText3);
		Button btn = (Button)findViewById(R.id.enter);
	}

	
	public void saveInternalCache(View v) 
	{
		switch (v.getId())
		{
		case R.id.enter:
		{
			Intent intent = new Intent(this, Startervegpoc.class);

		String data1 = name.getText().toString();
		String data2 = email.getText().toString();
		String data3 = mobile.getText().toString();

		File folder = getCacheDir();
		File myfile = new File(folder,"mydata.txt");
		FileOutputStream fileoutputstream = null;
		try {
			fileoutputstream = new FileOutputStream(myfile);
			fileoutputstream.write(data1.getBytes());
			fileoutputstream.write(data2.getBytes());
			fileoutputstream.write(data3.getBytes());
			Toast.makeText(getApplicationContext(), "data written to file",
					Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(fileoutputstream != null)
			{
				try {
					fileoutputstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		}
		
		
		
		}
		}




	}


	/*String filename = "myfile";
	String string = "Hello world!";
	FileOutputStream outputStream;

	try {
	  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
	  outputStream.write(string.getBytes());
	  outputStream.close();
	} catch (Exception e) {
	  e.printStackTrace();
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
