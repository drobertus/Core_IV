package com.mechzombie.infraview.server.core

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 9/1/13
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
class DepCalcTests extends spock.lang.Specification {
    //double currentStatus, int newStatus, int destroyedStatus, int replacementStatus, double replacementTimeYrs, double yearsAhead

    def "basic projected status of asset class"() {
        expect:
        futureValue == DepreciationCalculator.getFutureValue(currentStatus, newStatus, destoyedStatus, replacementStatus, replacementTimeYrs, yearsAhead)

        where:
        currentStatus | futureValue | newStatus | destoyedStatus | replacementStatus | replacementTimeYrs | yearsAhead
        10            | 7.5         | 10        | 0              | 5                 | 10                 | 5
        10            | 5           | 10        | 0              | 5                 | 10                 | 10
        10            | 0           | 10        | 0              | 5                 | 10                 | 20
        10            | 0           | 10        | 0              | 5                 | 10                 | 25

    }

    def "count the number of replacements needed over a span of time"() {


        expect:
        replacementCount == DepreciationCalculator.getProjectedTimesToReplace(currentStatus, newStatus, replacementStatus, replacementTimeYrs, yearsAhead)

        where:
        currentStatus | newStatus | replacementStatus | replacementTimeYrs | yearsAhead | replacementCount
        10            | 10        | 5                 | 5                  | 1          | 0
        10            | 10        | 5                 | 5                  | 4.9        | 0
        10            | 10        | 5                 | 5                  | 5          | 1
        10            | 10        | 5                 | 5                  | 10         | 2
        4             | 10        | 5                 | 5                  | 10         | 3
        5             | 10        | 5                 | 5                  | 10         | 3
        6             | 10        | 5                 | 5                  | 10         | 2
        10            | 10        | 5                 | 1                  | 1          | 1
        10            | 10        | 5                 | 2                  | 5          | 2
        10            | 10        | 5                 | 3                  | 5          | 1
        10            | 10        | 5                 | 4                  | 10         | 2
        4             | 10        | 5                 | 0.5                | 10         | 21
        5             | 10        | 5                 | 3.5                | 10         | 3
        6             | 10        | 5                 | 0.1                | 10         | 100
        10            | 10        | 0                 | 0.5                | 10         | 20
        10            | 10        | 0                 | 10                 | 10         | 1
        7.5           | 10        | 5                 | 4.5                | 10         | 2
        5.5           | 10        | 5                 | 4.4                | 10         | 3
        7.5           | 10        | 5                 | 4.6                | 10         | 2
    }

}
