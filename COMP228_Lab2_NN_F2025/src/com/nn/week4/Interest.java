package com.nn.week4;
import java.math.*;

public class Interest {
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;
	
	//SI = P*R*T/100
	//CI = P * (1 + r/100)^t - P
	
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
	
	
	
	public BigDecimal getPrincipal() {
		return principal;
	}



	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}



	public BigDecimal getRate() {
		return rate;
	}



	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}



	public int getTime() {
		return time;
	}



	public void setTime(int time) {
		this.time = time;
	}



	public BigDecimal calculateSimpleInterest(BigDecimal p, BigDecimal r, int time) {
		return p.multiply(r).multiply(BigDecimal.valueOf(time)).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
	}
	
	public double calculateSimpleInterest(double p, double r, int time) {
		return p*r*time/100.0;
	}
	
	public BigDecimal calculateCompoundInterest(BigDecimal p, BigDecimal r, int time) {
		/***************************************************************************************
		 SHOWING WORK FOR COMPOUND INTEREST FORMULA SINCE BIGDECIMAL FORMULA MAY BE COMPLICATED
		***************************************************************************************/
		// r.divide(BigDecimal.valueOf(100)) -> r/100
		// BigDecimal.ONE.add(r.divide(BigDecimal.valueOf(100))) -> 1 + r/100
		// BigDecimal.ONE.add(r.divide(BigDecimal.valueOf(100))).pow(time) -> (1 + r/100)^t
		// p.multiply(BigDecimal.ONE.add(r.divide(BigDecimal.valueOf(100))).pow(time)) -> P * (1 + r/100)^t
		// p.multiply(BigDecimal.ONE.add(r.divide(BigDecimal.valueOf(100))).pow(time)).subtract(p) -> P * (1 + r/100)^t - P
		
		return p.multiply(BigDecimal.ONE.add(r.divide(BigDecimal.valueOf(100))).pow(time)).subtract(p).setScale(2, RoundingMode.HALF_UP);
	}
	
	public double calculateCompoundInterest(double p, double r, int time) {
		return p * Math.pow((1.0 + r/100.0), time*1.0) - p;
	}
	
	public String toString() {
		return String.format("Principal: $%.2f%nRate: %.2f%%%nTime: %d year(s)%nSimple Interest: $%.2f%nCompound Interest: $%.2f%n", this.principal, this.rate, this.time, this.calculateSimpleInterest(this.principal, this.rate, this.time), this.calculateCompoundInterest(this.principal, this.rate, this.time));
	}
	
}
