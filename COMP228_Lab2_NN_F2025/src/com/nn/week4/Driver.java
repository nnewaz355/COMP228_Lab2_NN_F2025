package com.nn.week4;

import java.util.*;
import java.math.BigDecimal;

public class Driver {
	public static void main(String[] args) {
		
		BigDecimal principal = BigDecimal.ZERO, rate = BigDecimal.ZERO;
		int time = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		Interest[] investments = new Interest[5];
		
		for (int i=0; i < investments.length; i++) {
			System.out.println("\nInvestment " + (i+1));
			
			try {
				System.out.print("Enter Principal: ");
				principal = scanner.nextBigDecimal();
				
				System.out.print("Enter Interest Rate (%): ");
				rate = scanner.nextBigDecimal();
				
				System.out.print("Enter time (years): ");
				time = scanner.nextInt();
				
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input: " + e.getMessage());
				i--;
				//continue;
				scanner.nextLine();
				continue;
			}
			
			try {
				investments[i] = new Interest(principal, rate, time);
			} catch  (IllegalArgumentException e){
				System.out.println("Invalid input: " + e.getMessage());
				i--;
			} 
		}
		System.out.println();
		
		// Display 5 investments
		for (int i=0; i < investments.length; i++) {
			System.out.printf("Investment #%d%n", i+1);
			System.out.println(investments[i]);
		}
		
		scanner.close();
	}
}
