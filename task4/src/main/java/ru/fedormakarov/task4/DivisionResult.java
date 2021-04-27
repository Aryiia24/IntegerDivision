package ru.fedormakarov.task4;

import java.util.List;

public class DivisionResult {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final List<DivisionStep> steps;

    public DivisionResult(int dividend, int divisor, int quotient, int remainder, List<DivisionStep> steps) {
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

    public List<DivisionStep> getSteps() {
        return steps;
    }
}
