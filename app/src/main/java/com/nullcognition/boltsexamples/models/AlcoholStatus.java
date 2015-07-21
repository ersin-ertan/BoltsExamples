package com.nullcognition.boltsexamples.models;// Created by ersin on 16/07/15

import org.threeten.bp.Year;

public interface AlcoholStatus{

	int basePercent = 8;
	Year yearStored = Year.parse("2015");
	double percent();
	boolean isAlcoholic();

}
