package ru.fedormakarov.task4;

public class DivisionStep {
    private int minuend;
    private int multiply;
    private int partialQuontient;
    private int partialRemainder;
    private int indent;

    public int getMinuend() {
        return minuend;
    }

    public void setMinuend(int minuend) {
        this.minuend = minuend;
    }

    public int getMultiply() {
        return multiply;
    }

    public void setMultiply(int multiply) {
        this.multiply = multiply;
    }

    public int getPartialQuontient() {
        return partialQuontient;
    }

    public void setPartialQuontient(int partialQuontient) {
        this.partialQuontient = partialQuontient;
    }

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public void incrementsIndent() {
        this.indent = this.indent + 1;
    }

    public int getPartialRemainder() {
        return partialRemainder;
    }

    public void setPartialRemainder(int partialRemainder) {
        this.partialRemainder = partialRemainder;
    }
}
