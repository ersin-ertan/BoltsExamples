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

			continueWith();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	// this should really have
	private void continueWith(){
		getWine().onSuccess(new Continuation<Wine<Fruit>, Void>(){

			public Void then(Task<Wine<Fruit>> task) throws Exception{
				if(task.isCancelled()){ return null; }
				else if(task.isFaulted()){
					Exception error = task.getError();
					throw error;
				}
				else{
					Log.e("logErr", "OnSuccess then task.getResult(), return wine.compare()");
					Wine<Fruit> appleWine = task.getResult();
					Log.e("logErr", "based on the results of the compare, respond");
					if(appleWine.compareTo(Fruit.APPLE) == 0){
						Log.e("logErr", "onSuccess tastes GOOD, Give to everyone");
					}
					else{ Log.e("logErr", "onSuccess tastes BAD, spit it out"); }
				}
				return null;
			}
		});
	}

	public Task<Wine<Fruit>> getWine(){
		Log.e("logErr", "getWine()");
		return getJuice().continueWith(
				new Continuation<Juice<Fruit>, Wine<Fruit>>(){
					@Override
					public Wine<Fruit> then(final Task<Juice<Fruit>> task) throws Exception{
						if(task.isCancelled()){ return null; }
						else if(task.isFaulted()){
							Exception error = task.getError();
							throw error;
						}
						else{
							Juice<Fruit> appleJuice = task.getResult();
							Log.e("logErr", "then task.getResult(), return appleJuice.ferment(), which is Wine");
							return appleJuice.ferment();
						}
					}
				}
		);
	}

	public Task<Juice<Fruit>> getJuice(){
		Task<Juice<Fruit>>.TaskCompletionSource successful = Task.create();
		successful.setResult(new Juice<>(1, Fruit.APPLE));
		Log.e("logErr", "getJuice(), return new Juice<>(new Fruit())");
		return successful.getTask();
	}


}
