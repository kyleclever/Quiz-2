package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testcase {
	
	//UDTuition test = new UDTuition();
	double InitialTuition = 10000;
	double percentage_increases = 5;
	double fixedAPR = 5;
	int YearsRepay = 10;
	
	@Test
	public void test() {
		double d=746.37;
		assertEquals(UDTuition.monthlypayment(), d);
	}
	

}
