package ru.fedormakarov.task4;

import java.util.List;

public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final List<DivisionStep> steps;

    public Result(int dividend, int divisor, int quotient, int remainder, List<DivisionStep> steps) {
        super();
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
        this.steps = steps;
    }

    public Result(int dividend, int divisor, int quotient, int remainder) {
        super();
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
        this.steps = null;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dividend;
        result = prime * result + divisor;
        result = prime * result + quotient;
        result = prime * result + remainder;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Result other = (Result) obj;
        if (dividend != other.dividend)
            return false;
        if (divisor != other.divisor)
            return false;
        if (quotient != other.quotient)
            return false;
        if (remainder != other.remainder)
            return false;
        return true;
    }

}
