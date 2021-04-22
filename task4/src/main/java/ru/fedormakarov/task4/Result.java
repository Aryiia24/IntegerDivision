package ru.fedormakarov.task4;

import java.util.LinkedList;

public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final LinkedList<DivisionSteps> steps;

    public Result(int dividend, int divisor, int quotient, int remainder, LinkedList<DivisionSteps> steps) {
        super();
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
        this.steps = steps;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public LinkedList<DivisionSteps> getSteps() {
        return steps;
    }

}
