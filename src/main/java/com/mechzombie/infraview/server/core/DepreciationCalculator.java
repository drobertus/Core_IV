package com.mechzombie.infraview.server.core;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class DepreciationCalculator {

    private static final int moneyPrecision = 2;

    /**
     * Projects the status of an asset in the future based on current status.  Assumes no replacement
     * so this will not return a value less than a "destroyed" value.
     *
     * @param currentStatus
     * @param newStatus
     * @param destroyedStatus
     * @param replacementStatus
     * @param replacementTimeYrs
     * @param yearsAhead
     * @return
     */
    public static double getFutureStatus(double currentStatus, int newStatus, int destroyedStatus, int replacementStatus, double replacementTimeYrs, double yearsAhead) {

        double reductionPerYear = (newStatus - replacementStatus) / replacementTimeYrs;

        double reductionOverTime = reductionPerYear * yearsAhead;

        double futureVal = currentStatus - reductionOverTime;

        if (futureVal < destroyedStatus) {
            futureVal = destroyedStatus;
        }
        return futureVal;
    }

    /**
     * @param currentStatus
     * @param newStatus
     * @param replacementStatus
     * @param replacementTimeYrs
     * @param yearsAhead
     * @return
     */
    public static int getProjectedTimesToReplace(double currentStatus, int newStatus, int replacementStatus, double replacementTimeYrs, double yearsAhead) {

        int replacementCount = 0;
        //first see the time from current to replacement
        double yearsRemaining = yearsAhead;

        int statusUnitsFromNewToReplace = newStatus - replacementStatus;
        double statusUnitsLostPerYear = statusUnitsFromNewToReplace / replacementTimeYrs;
        double yearsForOneUnitOfStatusLost = 1 / statusUnitsLostPerYear;

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

    /**
     *
     * @param timesToReplace
     * @param yearsBetweenReplacement
     * @param yearsToFirstReplacement
     * @param currentReplacementCost
     * @param projectedInflationRate
     * @return
     */
    public static double cumulativeReplacementCostOverTime(int timesToReplace, double yearsBetweenReplacement, double yearsToFirstReplacement, double currentReplacementCost, double projectedInflationRate) {

        double cumulativeCost = 0.0;

        for (int i = 0; i < timesToReplace; i++) {
            cumulativeCost += compoundedRate(currentReplacementCost, projectedInflationRate, yearsToFirstReplacement + (i * yearsBetweenReplacement));
            //System.out.println("cumulativeCost =" + cumulativeCost);
        }
        return new BigDecimal(cumulativeCost).setScale(moneyPrecision, RoundingMode.HALF_EVEN).doubleValue();
    }

    private static double compoundedRate(double principal, double rate, double years) {
        double amount = principal * Math.pow(1.0 + rate, years);
        //System.out.println("compounded val=" + amount);
        return new BigDecimal(amount).setScale(moneyPrecision, RoundingMode.HALF_EVEN).doubleValue();
    }
}
