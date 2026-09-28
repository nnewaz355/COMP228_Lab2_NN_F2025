package com.nn.week4;
import java.math.*;

public class Interest {
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;
	
	//SI = P*R*T/100
	
	//Constructor
	
	public Interest(BigDecimal principal, BigDecimal rate, int time) {
		if (principal.compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("Principal must be greater than zero.");
		}
		
		this.principal = principal;
		this.rate = rate;
		this.time = time;
	}
	
	public BigDecimal calculateSimplateInterest(BigDecimal p, BigDecimal r, int time) {
		
	}
	
	public BigDecimal calculateSimplateInterest(BigDecimal p, BigDecimal r, int time) {
		
	}
}
