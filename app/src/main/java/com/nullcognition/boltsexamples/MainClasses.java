package com.nullcognition.boltsexamples;// Created by ersin on 16/07/15

import bolts.Bolts;
import bolts.Continuation;
import bolts.Task;

public class MainClasses{
	private void mainClaseses(){

		String s = Bolts.VERSION;

		// Standard continuation with task

		Continuation c = new Continuation(){
			@Override
			public Object then(final Task task) throws Exception{
				if(task.isCancelled()){
					// do resource clean up
				}
				else if(task.isFaulted()){
					throw task.getError();
					// or catch it and deal with it
				}
				else{
					Object o = task.getResult();
					return o;
				}
				return null;
			}
		};

		new Continuation<Float, Integer>(){ // we have the task result and the continuation result

			@Override
			public Integer then(final Task<Float> task) throws Exception{
				// to cancel the task in this continuation, throw a java.util.concurrent.CancellationException from within

				task.getResult(); // will get ^ since defined in the task as a type parameter else return object
				task.cast();
//				task.continueWhile(); // task based loop
//				task.continueWith();
//				task.continueWithTask(); // async continuation
				task.isFaulted(); // if the task has an error
				task.makeVoid(); // turns the task into a Task<Void> dropping the result
//				task.onSuccess();
//				task.onSuccessTask();
				task.waitForCompletion(); // will block until task is complete
//				task.call();
//				task.callInBackground(); // task invokes in background thread, returns task as representation
				task.cancelled(); // creates a cancelled task
				task.delay(1000); // delay then execution

//				task.whenAll(); // task created when all are complete
//				task.whenAllResult();
//				task.whenAny(); // when any
//				task.whenAnyResult();// return is the task that completed
				task.forError(new Exception()); task.forResult(String.class);



				return null;
			}
		};


	}
}
