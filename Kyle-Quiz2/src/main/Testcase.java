package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testcase {
	
	
	@Test
	public void test() {
		UDTuition test = new UDTuition();
		
		test.setInitialTuition(10000);
		test.setPercentage_increases(5);
		test.setFixedAPR(5);
		test.setYearsRepay(10);
		test.monthlypayment();
		double d=746.376;
		
		System.out.println(test.getMonthlyPayment());
		assertTrue(Math.abs(test.getMonthlyPayment() - d) < .01);
	}
}
