package com.mechzombie.infraview.server.core;


public class DepreciationCalculator {

    public static double getFutureValue(double currentStatus, int newStatus, int destroyedStatus, int replacementStatus, double replacementTimeYrs, double yearsAhead) {

        double reductionPerYear = (newStatus - replacementStatus) / replacementTimeYrs;

        double reductionOverTime = reductionPerYear * yearsAhead;

        double futureVal = currentStatus - reductionOverTime;

        if (futureVal < destroyedStatus) {
            futureVal = destroyedStatus;
        }
        return futureVal;
    }


    public static int getProjectedTimesToReplace(double currentStatus, int newStatus, int replacementStatus, double replacementTimeYrs, double yearsAhead) {

        int replacementCount = 0;
        //first see the time from current to replacement
        double yearsRemaining = yearsAhead;

        int statusUnitsFromNewToReplace = newStatus - replacementStatus;
        double statusUnitsLostPerYear = statusUnitsFromNewToReplace / replacementTimeYrs;
        double yearsForOneUnitOfStatusLost = 1 / statusUnitsLostPerYear;

        //double annualReplacementRate = 1 / replacementTimeYrs;
        //double replacements = annualReplacementRate * yearsAhead;

        //double reductionPerYear = (newStatus - replacementStatus) / replacementTimeYrs;

        double yearsToFirstReplace;
        //if the asset needs to be replaced this year then
        if (currentStatus <= replacementStatus) {
            yearsToFirstReplace = 0.0;
        } else {
            yearsToFirstReplace = yearsForOneUnitOfStatusLost * (currentStatus - replacementStatus);
        }

        if (yearsToFirstReplace > yearsAhead) {
            return 0;
        } else {
            replacementCount++;
            yearsRemaining -= yearsToFirstReplace;
        }

        int additionalTimesToReplace = (int) Math.floor(yearsRemaining / replacementTimeYrs);

        replacementCount = replacementCount + additionalTimesToReplace;

        return replacementCount;
    }


}
