package com.nullcognition.boltsexamples.models;// Created by ersin on 20/07/15

public enum Apple implements Flavour{
GRANNY_SMITH, GOLDEN_DEL, GALA;

	// to total 1.00

	@Override
	public double sweetness(){
		return 0.70;
		// during fermentation, sweetness decreases(carbohydrate to alcohol)
	}
	@Override
	public double saltiness(){
		return 0.05;
		// during fermentation, salt increases(is added)
	}
	@Override
	public double sourness(){
		return 0.20;
		// during fermentation, sourness increases(lactic acid)
	}
	@Override
	public double bitterness(){
		return 0.05;
		// during fermentation, bitterness increases(acid)
	}
}
