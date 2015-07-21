package com.nullcognition.boltsexamples.models;// Created by ersin on 16/07/15

import org.threeten.bp.Year;

public abstract class Liquid{

	protected double amount;
	public Liquid(double amount){ this.amount = amount;}

//	public static AlcoholStatus nonAlcoholic = new AlcoholStatus(){
//		@Override
//		public double percent(){
//			return 0;
//		}
//		@Override
//		public boolean isAlcoholic(){
//			return false;
//		}
//	};
//
//	public static AlcoholStatus ofThisYear = new AlcoholStatus(){
//	// anonymous class, implements contains alcohol
//		// which is no an instance of the interface, but an ^
//		// no constructors allowed
//		@Override
//		public double percent(){
//			return basePercent;
//		}
//		@Override
//		public boolean isAlcoholic(){
//			return percent() > 0; // if percent is a dynamic number use this
//		}
//	};
//
//	// showcasing use of three ten backport
//	public static AlcoholStatus aged = new AlcoholStatus(){
//		int yearsOld = Year.now().getValue() - yearStored.getValue();
//
//		@Override
//		public double percent(){
//			int percent = basePercent;
//			for(int i = 0; i < yearsOld; i++){percent *= 1.1;}
//			return percent;
//		}
//		@Override
//		public boolean isAlcoholic(){
//			return true;
//		}
//	};

}
