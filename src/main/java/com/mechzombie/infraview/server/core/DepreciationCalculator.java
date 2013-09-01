package com.mechzombie.infraview.server.core;


public class DepreciationCalculator {

    public double getFutureValue(double currentStatus, int newStatus, int destroyedStatus, int replacementStatus, double replacementTimeYrs, double yearsAhead) {

        double reductionPerYear = (newStatus - replacementStatus) / replacementTimeYrs;

        double reductionOverTime = reductionPerYear * yearsAhead;

        double futureVal = currentStatus - reductionOverTime;

        return futureVal;
    }

}
