package com.nullcognition.boltsexamples.models;// Created by ersin on 20/07/15

public enum Apple implements Flavour{//, Comparable<Flavour>{
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

//	@Override
//	public int compareTo(final Flavour another){
//		if(another == null){return 99;}
//		if(another.bitterness() >= this.bitterness() - 0.10 && another.bitterness() <= this.bitterness() + 0.10
//				&& another.sourness() >= this.sourness() - 0.10 && another.sourness() <= this.sourness() + 0.10
//				&& another.saltiness() >= this.saltiness() - 0.10 && another.saltiness() <= this.saltiness() + 0.10
//				&& another.sweetness() >= this.sweetness() - 0.10 && another.sweetness() <= this.sweetness() + 0.10){
//			return 0;
//		}
//		else if(another.sweetness() > this.sweetness() + 0.10){ return -1; }
//		else if(another.sweetness() < this.sweetness() - 0.10){ return 1; }
//		else{ return 99; }
//	}

}
