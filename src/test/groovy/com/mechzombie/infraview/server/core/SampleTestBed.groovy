package com.mechzombie.infraview.server.core

/**
 * Created by David on 1/15/14.
 */
class SampleTestBed extends GroovyTestCase {

    void "test how a Double converts to int"() {

        Double d1 = 8.000
        assert 8 == d1.intValue()

        d1 = 8.23
        assert 8 == d1.intValue()

        d1 = 8.5
        assert 8 == d1.intValue()

        d1 = 8.9
        assert 8 == d1.intValue()
    }

    void "test specific case in detail"() {
        double replacementTimeInYrs = 4.4
        double yearsToLookAhead = 10
        double currentStatus = 5.5

        def depPerYr = depreciationPerYear(10, 5, replacementTimeInYrs)

        def timeToFirstReplacement = DepreciationCalculator.getYearsToNextReplacement(currentStatus, 5, 10, replacementTimeInYrs)

        println("time to first replacement = $timeToFirstReplacement")

        assert timeToFirstReplacement > 0
        def yrsLeft = yearsToLookAhead - timeToFirstReplacement

        def nextReplacementTime = DepreciationCalculator.getYearsToNextReplacement(10, 5, 10, replacementTimeInYrs)

        def replacementCount = 1 + (yrsLeft / nextReplacementTime)

        println "standard replacement time  = $nextReplacementTime"
        println "total replacements over $yearsToLookAhead years is $replacementCount"


    }


    def depreciationPerYear(double newVal, double replacementVal, double yearsToreaplce) {

        return (newVal - replacementVal)/ yearsToreaplce
    }
}
