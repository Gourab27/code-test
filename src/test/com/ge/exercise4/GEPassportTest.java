package com.ge.exercise4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GEPassportTest {

    GEPassport testEngine;

    @Before
    public void setUp() {
        testEngine = new GEPassport("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GEPassport SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
    
	@Test
    public void hoursLeftToRebuildTest() {
    	assertEquals(testEngine.flightHoursBeforeRebuild - testEngine.getFlightHours(), 50_000, 0.01);
    }
	
	@Test
	public void remainingServiceLife() {
	}
}