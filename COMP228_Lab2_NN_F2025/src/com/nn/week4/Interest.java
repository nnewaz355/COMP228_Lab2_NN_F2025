package com.nn.week4;
import java.math.*;

public class Interest {
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;
	
	//SI = P*R*T/100
	//CI = P*(1+r/n)**(t/n)
	
	//Constructor
	
	public Interest(BigDecimal principal, BigDecimal rate, int time) {
		if (principal.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Principal must be greater than $0.00.");
		}
		if (rate.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Rate must be 0% or greater.");
		}
		if (time <=0) {
			throw new IllegalArgumentException("Time must be greater than 0 years.");
		}
		
		this.principal = principal;
		this.rate = rate;
		this.time = time;
	}
	
	public BigDecimal calculateSimpleInterest(BigDecimal p, BigDecimal r, int time) {
		return p.multiply(r).multiply(BigDecimal.valueOf(time)).divide(BigDecimal.valueOf(100));
	}
	
	public double calculateSimpleInterest(double p, double r, int time) {
		return p*r*time/100.0;
	}
	
	
}
