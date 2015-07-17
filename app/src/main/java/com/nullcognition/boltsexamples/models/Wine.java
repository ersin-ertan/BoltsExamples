package com.nullcognition.boltsexamples.models;// Created by ersin on 16/07/15

public class Wine<F extends Flavour> extends Liquid implements Drinkable<Flavour>{

	public Wine(){}

	public Flavour flavour = F.Wine;
	public AlcoholStatus alcoholStatus = super.aged; // super as a reminder of initialization, but also
	// to override any AlcoholStatus defined with the same variable name.

	@Override
	public Flavour drink(){
		return flavour;
	}
}
