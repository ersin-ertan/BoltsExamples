package com.nullcognition.boltsexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
	private void continueWith(){
		getAppleWine().onSuccess(new Continuation<Wine<Apple>, Void>(){
			public Void then(Task<Wine<Apple>> task) throws Exception{
				Toast.makeText(MainActivity.this, "Give to everyone", Toast.LENGTH_SHORT).show();
				return null;
			}
		});
	}


	public Task<Wine<Apple>> getAppleWine(){
		Toast.makeText(MainActivity.this, "getAppleWine()", Toast.LENGTH_SHORT).show();
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
							Toast.makeText(MainActivity.this, "then task.getResult(), return appleJuice.ferment(), which is Wine", Toast.LENGTH_SHORT).show();
							return appleJuice.ferment();
						}
					}
				}
		);
	}

	public Task<Juice<Apple>> getAppleJuice(){
		Task<Juice<Apple>>.TaskCompletionSource successful = Task.create();
		successful.setResult(new Juice<>(1, Apple.GALA));
		Toast.makeText(MainActivity.this, "getAppleJuice(), return new Juice<>(Apple.GALA)", Toast.LENGTH_SHORT).show();
		return successful.getTask();
	}


}

