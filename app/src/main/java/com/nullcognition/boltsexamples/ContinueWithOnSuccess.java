package com.nullcognition.boltsexamples;// Created by ersin on 21/07/15

import android.util.Log;

import com.nullcognition.boltsexamples.models.Fruit;
import com.nullcognition.boltsexamples.models.Juice;
import com.nullcognition.boltsexamples.models.Wine;

import bolts.Continuation;
import bolts.Task;

public class ContinueWithOnSuccess{
	public static void continueWithOnSuccess(){
		continueWith();
	}

	private static void continueWith(){
		getWine().onSuccess(new Continuation<Wine<Fruit>, Void>(){

			public Void then(Task<Wine<Fruit>> task) throws Exception{
				if(task.isCancelled()){ return null; }
				else if(task.isFaulted()){
					Exception error = task.getError();
					throw error;
				}
				else{
					Log.e("logErr", "OnSuccess then task.getResult(), return wine.compare()");
					Log.e("logErr", "based on the results of the compare, respond");
					Wine<Fruit> appleWine = task.getResult();
					if(appleWine.compareTo(Fruit.APPLE) == 0){
						Log.e("logErr", "onSuccess tastes GOOD, Give to everyone");
					}
					else{ Log.e("logErr", "onSuccess tastes BAD, spit it out"); }
				}
				return null;
			}
		});
	}

	private static Task<Wine<Fruit>> getWine(){
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

	private static Task<Juice<Fruit>> getJuice(){
		Log.e("logErr", "getJuice(), return new Juice<>(new Fruit())");
		Task<Juice<Fruit>>.TaskCompletionSource successful = Task.create();
		successful.setResult(new Juice<>(1, Fruit.APPLE));
		return successful.getTask();
	}


}
