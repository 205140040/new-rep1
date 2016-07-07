package com.demo.deep.c19;

import java.math.BigDecimal;

public enum BigdecimalEnum {
	zero(0.0),one(1.00),two(2);
	
	private double value;
	private BigdecimalEnum(double value){
		this.value=value;
	}
	
	public BigDecimal getValue(){
		return new BigDecimal(value);
	}
	
	public static void main(String[] args) {
		for (BigdecimalEnum e : BigdecimalEnum.values()) {
			System.out.println("name:"+e.name()+",value:"+e.getValue());
		}
	}
}
