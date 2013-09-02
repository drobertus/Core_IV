package com.mechzombie.infraview.server.core;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepreciationCalcTest {

    private DepreciationCalculator calculator = new DepreciationCalculator();

    @Test
    public void testDepreciationBasic() {

        int top = 10;
        int destroyed = 0;
        int replacement = 5;
        double currentStatus = 10;

        double replacementLife = 10;

        Double futureStatus = DepreciationCalculator.getFutureValue(currentStatus, top, destroyed, replacement, replacementLife, 0.0);

        assertEquals(Double.valueOf(10), futureStatus);

        futureStatus = DepreciationCalculator.getFutureValue(currentStatus, top, destroyed, replacement, replacementLife, 10.0);

        assertEquals(Double.valueOf(5), futureStatus);

        futureStatus = DepreciationCalculator.getFutureValue(currentStatus, top, destroyed, replacement, replacementLife, 5.0);

        assertEquals(Double.valueOf(7.5), futureStatus);


        futureStatus = DepreciationCalculator.getFutureValue(currentStatus, top, destroyed, replacement, replacementLife, 20.0);

        assertEquals(Double.valueOf(0.0), futureStatus);

        futureStatus = DepreciationCalculator.getFutureValue(currentStatus, top, destroyed, replacement, replacementLife, 25.0);

        assertEquals(Double.valueOf(0.0), futureStatus);
    }
}
