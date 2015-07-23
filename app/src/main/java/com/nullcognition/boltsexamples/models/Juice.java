package com.nullcognition.boltsexamples.models;// Created by ersin on 20/07/15

public final class Juice<F extends Flavour> extends DrinkableLiquid<F>{

	public Juice(double amount, F flavour){
		super(amount, flavour); //, nonAlcoholic);
	}

	public Wine<F> ferment(){
		return new Wine<>(this.amount, this.getFlavour());
	}

}
