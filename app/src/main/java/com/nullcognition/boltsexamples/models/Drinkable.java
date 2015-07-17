package com.nullcognition.boltsexamples.models;// Created by ersin on 16/07/15

public interface Drinkable<F extends Flavour>{
	Flavour drink();
}
