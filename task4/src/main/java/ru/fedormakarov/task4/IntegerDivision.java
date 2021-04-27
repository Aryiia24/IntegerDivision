package ru.fedormakarov.task4;

import java.util.Collections;
import java.util.LinkedList;

public class IntegerDivision {
    static final int LAST_STEP_WITHOUT_INDENT = 1;
    static final int FIRST_ITERATION = 0;
    static final int ONE_INDENT = 1;

    public String divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor should be > 0");
        }

        if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend should be > divisor");
        }

        Result result = getResult(dividend, divisor);
        LinkedList<DivisionStep> divisionSteps = (LinkedList<DivisionStep>) result.getSteps();
        StringBuilder sb = new StringBuilder();

        sb.append("_" + result.getDividend() + "|" + result.getDivisor() + "\r\n");

        sb.append(" " + divisionSteps.getFirst().getMultiply());
        int numbSpaces = String.valueOf(result.getDividend()).length()
                - String.valueOf(divisionSteps.getFirst().getMultiply()).length();
        sb.append(repeatsCharacters(' ', numbSpaces) + "|");
        int numbDashes = String.valueOf(result.getQuotient()).length();
        sb.append(repeatsCharacters('-', numbDashes) + "\r\n");

        numbDashes = String.valueOf(divisionSteps.getFirst().getMultiply()).length();
        sb.append(" " + repeatsCharacters('-', numbDashes) + repeatsCharacters(' ', numbSpaces) + "|"
                + result.getQuotient() + "\r\n");

        divisionSteps.removeFirst();

        int sizeDivisionSteps = divisionSteps.size();

        for (int i = 0; i < sizeDivisionSteps; i++) {
            DivisionStep currentStep = divisionSteps.getFirst();
            int numbsIndent = divisionSteps.getFirst().getIndent();

            sb.append(repeatsCharacters(' ', numbsIndent) + "_" + currentStep.getMinuend() + "\r\n");
            sb.append(repeatsCharacters(' ', numbsIndent + ONE_INDENT) + currentStep.getMultiply() + "\r\n");
            sb.append(repeatsCharacters(' ', numbsIndent + ONE_INDENT)
                    + repeatsCharacters('-', String.valueOf(currentStep.getMinuend()).length()) + "\r\n");
            if (i == sizeDivisionSteps - 1) {
                sb.append(repeatsCharacters(' ', numbsIndent + String.valueOf(currentStep.getMinuend()).length())
                        + String.valueOf(result.getRemainder()));
            }
            divisionSteps.removeFirst();
        }

        return sb.toString();
    }

    private Result getResult(int dividend, int divisor) {

        LinkedList<DivisionStep> steps = new LinkedList<>();
        LinkedList<Integer> numbsDividend = intToNumbers(dividend);
        int minuend = numbsDividend.getFirst();
        int countIterationOfCycle = 0;
        int zeroCount = 0;
        int indentCount = 1;

        if (numbsDividend.size() > 1) {
            numbsDividend.removeFirst();

            while (!numbsDividend.isEmpty()) {
                DivisionStep step = new DivisionStep();

                if (countIterationOfCycle > FIRST_ITERATION) {
                    minuend = steps.getLast().getPartialRemainder();
                }

                if (minuend < divisor) {
                    minuend = (minuend * 10) + numbsDividend.getFirst();
                    numbsDividend.removeFirst();
                    if (minuend == 0) {
                        countIterationOfCycle++;
                        zeroCount++;
                        indentCount++;
                        continue;
                    }
                }

                step.setMinuend(minuend);
                step.setPartialQuontient((minuend / divisor));
                step.setMultiply(step.getPartialQuontient() * divisor);
                step.setPartialRemainder(minuend - step.getMultiply());

                if (countIterationOfCycle > LAST_STEP_WITHOUT_INDENT) {
                    step.setIndent(indentCount + zeroCount);
                    zeroCount = 0;
                    indentCount++;
                }
                steps.add(step);
                countIterationOfCycle++;
            }

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

    private String repeatsCharacters(char inputCharacter, int numberOfTimes) {
        StringBuilder result = new StringBuilder();
        if (numberOfTimes == 0) {
            return "";
        }
        for (int i = 0; i < numberOfTimes; i++) {
            result.append(inputCharacter);
        }
        return result.toString();
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
