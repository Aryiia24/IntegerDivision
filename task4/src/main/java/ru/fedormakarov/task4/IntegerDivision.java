package ru.fedormakarov.task4;

import java.util.Collections;
import java.util.LinkedList;

public class IntegerDivision {
    LinkedList<DivisionStep> steps = new LinkedList<>();

    public Result divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor should be > 0");
        }
        
        if(dividend<divisor) {
            throw new IllegalArgumentException("Dividend shuolde be > divisor");
        }
        
        LinkedList<Integer> numbsDividend = intToNumbers(dividend);
        int minuend = numbsDividend.getFirst();
        numbsDividend.removeFirst();
        int countOfIterationOfCycle = 0;
        int zeroCount = 0;
        int indentCount = 1;

        while (!numbsDividend.isEmpty()) {
            DivisionStep step = new DivisionStep();

            if (countOfIterationOfCycle > 0) {
                minuend = steps.getLast().getPartialRemainder();
            }

            if (minuend < divisor) {
                minuend = (minuend * 10) + numbsDividend.getFirst();
                numbsDividend.removeFirst();
                if (minuend == 0) {
                    countOfIterationOfCycle++;
                    zeroCount++;
                    indentCount++;
                    continue;
                }
            }

            step.setMinuend(minuend);
            step.setPartialQuontient((minuend / divisor));
            step.setMultiply(step.getPartialQuontient() * divisor);
            step.setPartialRemainder(minuend - step.getMultiply());
            steps.add(step);

            if (countOfIterationOfCycle > 1) {
                step.setIndent(indentCount + zeroCount);
                zeroCount = 0;
                indentCount++;
            }
            countOfIterationOfCycle++;
        }
        return new Result(dividend, divisor, dividend / divisor, dividend % divisor, steps);
    }

    private LinkedList<Integer> intToNumbers(int number) {
        LinkedList<Integer> numbs = new LinkedList<>();
        while (number > 0) {
            numbs.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(numbs);
        return numbs;
    }
}

class DivisionStep {
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
