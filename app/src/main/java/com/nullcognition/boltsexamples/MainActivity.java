package com.nullcognition.boltsexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.nullcognition.boltsexamples.models.Fruit;
import com.nullcognition.boltsexamples.models.Juice;
import com.nullcognition.boltsexamples.models.Wine;

import bolts.Continuation;
import bolts.Task;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();

		if(id == R.id.action_continueWith){

			ContinueWithOnSuccess.continueWithOnSuccess();

			return true;
		}
//		else if(id == R.id.action_)

		return super.onOptionsItemSelected(item);
	}




}
