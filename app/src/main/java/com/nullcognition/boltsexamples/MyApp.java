package com.nullcognition.boltsexamples;// Created by ersin on 16/07/15

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.threeten.bp.DateTimeUtils;

public class MyApp extends Application{
	@Override
	public void onCreate(){
		super.onCreate();
		AndroidThreeTen.init(this);
	}
}
