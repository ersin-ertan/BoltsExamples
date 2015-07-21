package com.nullcognition.boltsexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.nullcognition.boltsexamples.models.Apple;
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
		getAppleWine().onSuccess(new Continuation<Wine<Apple>, Void>(){

			public Void then(Task<Wine<Apple>> task) throws Exception{
				if(task.isCancelled()){ return null; }
				else if(task.isFaulted()){
					Exception error = task.getError();
					throw error;
				}
				else{
					Log.e("logErr", "OnSuccess then task.getResult(), return wine.compare()");
					Wine<Apple> appleWine = task.getResult();
					Log.e("logErr", "based on the results of the compare, respond");
					if(appleWine.compareTo(Apple.GALA) == 0){
						Log.e("logErr", "onSuccess tastes GOOD, Give to everyone");
					}
					else{ Log.e("logErr", "onSuccess tastes BAD, spit it out"); }
				}
				return null;
			}
		});
	}

	public Task<Wine<Apple>> getAppleWine(){
		Log.e("logErr", "getAppleWine()");
		return getAppleJuice().continueWith(
				new Continuation<Juice<Apple>, Wine<Apple>>(){
					@Override
					public Wine<Apple> then(final Task<Juice<Apple>> task) throws Exception{
						if(task.isCancelled()){ return null; }
						else if(task.isFaulted()){
							Exception error = task.getError();
							throw error;
						}
						else{
							Juice<Apple> appleJuice = task.getResult();
							Log.e("logErr", "then task.getResult(), return appleJuice.ferment(), which is Wine");
							return appleJuice.ferment();
						}
					}
				}
		);
	}

	public Task<Juice<Apple>> getAppleJuice(){
		Task<Juice<Apple>>.TaskCompletionSource successful = Task.create();
		successful.setResult(new Juice<>(1,Apple.GOLDEN_DEL));
		Log.e("logErr", "getAppleJuice(), return new Juice<>(new Apple())");
		return successful.getTask();
	}


}
