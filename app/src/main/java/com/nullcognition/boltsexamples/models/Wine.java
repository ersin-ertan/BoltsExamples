package com.nullcognition.boltsexamples.models;// Created by ersin on 16/07/15

public final class Wine<F extends Flavour> extends DrinkableLiquid{

	public Wine(double amount, F flavour){
		super(amount, flavour, ofThisYear);
	}

}
