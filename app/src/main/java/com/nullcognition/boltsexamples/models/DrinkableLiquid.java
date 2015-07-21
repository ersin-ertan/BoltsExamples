package com.nullcognition.boltsexamples.models;// Created by ersin on 21/07/15

public abstract class DrinkableLiquid<F extends Flavour> extends Liquid
		implements Drinkable<F>,
		           Comparable<Flavour>{

	protected final F flavour;
//	protected final AlcoholStatus alcoholStatus;

	protected DrinkableLiquid(double amount, F flavour){ // , AlcoholStatus alcoholStatus){
		super(amount);

		if(flavour == null){ throw new IllegalArgumentException(); }
		this.flavour = flavour;

//		if(alcoholStatus == null){throw new IllegalArgumentException(); }
//		this.alcoholStatus = alcoholStatus;
	}

	@Override
	public F getFlavour(){return this.flavour;}

	@Override
	public int compareTo(final Flavour another){
		if(another instanceof Apple && this.flavour instanceof Apple){
			if(((Apple) another).ordinal() == ((Apple) this.flavour).ordinal()){
				return 0; //  is equal
			}
		}
		return 1;
	}

//	public boolean isAlcoholic(){return alcoholStatus.isAlcoholic();}

}
