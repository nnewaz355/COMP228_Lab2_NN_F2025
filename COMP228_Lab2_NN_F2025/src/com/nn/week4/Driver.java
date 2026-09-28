package com.nn.week4;

import java.util.Scanner;
import java.math.BigDecimal;

public class Driver {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Interest[] investments = new Interest[5];
		
		for (int i=0; i < investments.length; i++) {
			System.out.println("\nInvestment " + (i+1));
			
			System.out.print("Enter Principal: ");
			BigDecimal principal = scanner.nextBigDecimal();
			
			System.out.print("Enter Interest Rate (%): ");
			BigDecimal rate = scanner.nextBigDecimal();
			
			System.out.print("Enter time (years): ");
			int time = scanner.nextInt();
			
			try {
				investments[i] = new Interest(principal, rate, time);
			} catch  (IllegalArgumentException e){
				System.out.println("Invalid input: " + e.getMessage());
			}
		}
	}
}
