package ru.fedormakarov.task4;

import java.util.Collections;
import java.util.LinkedList;

public class IntegerDivision {
    private static final int LAST_STEP_WITHOUT_INDENT = 1;
    private static final int FIRST_ITERATION = 0;
    private static final int ONE_INDENT = 1;
    private static final int DOZENS = 10;
    private static final String LINE_BREAKER = "\r\n";
    private static final char DIVIDEND_DIVISOR_SEPARATOR = '|';
    private static final char COLUMN_SEPARATOR = '-';
    private static final char DIVISOR_QUOTIENT_SEPARATOR = '-';
    private static final String MINUS = "_";

    public String divide(int dividend, int divisor) {
        if (divisor == 0 || divisor < 0) {
            throw new IllegalArgumentException("Divisor should be > 0");
        }

        if (dividend < divisor) {
            throw new IllegalArgumentException("Dividend should be > divisor");
        }
        
        if (dividend < 0) {
            throw new IllegalArgumentException("Dividend should be > 0");
        }

        DivisionResult result = getResult(dividend, divisor);
        LinkedList<DivisionStep> divisionSteps = (LinkedList<DivisionStep>) result.getSteps();
        StringBuilder sb = new StringBuilder();

        sb.append(MINUS + result.getDividend() + DIVIDEND_DIVISOR_SEPARATOR + result.getDivisor() + LINE_BREAKER);

        sb.append(" " + divisionSteps.getFirst().getMultiply());
        int numbSpaces = String.valueOf(result.getDividend()).length()
                - String.valueOf(divisionSteps.getFirst().getMultiply()).length();
        sb.append(repeatCharacter(' ', numbSpaces) + DIVIDEND_DIVISOR_SEPARATOR);
        int numbDashes = String.valueOf(result.getQuotient()).length();
        sb.append(repeatCharacter(DIVISOR_QUOTIENT_SEPARATOR, numbDashes) + LINE_BREAKER);

        numbDashes = String.valueOf(divisionSteps.getFirst().getMultiply()).length();
        sb.append(" " + repeatCharacter(COLUMN_SEPARATOR, numbDashes) + repeatCharacter(' ', numbSpaces)
                + DIVIDEND_DIVISOR_SEPARATOR + result.getQuotient() + LINE_BREAKER);

        divisionSteps.removeFirst();

        int sizeDivisionSteps = divisionSteps.size();
        
        if(sizeDivisionSteps<=1) {
            sb.append(repeatCharacter(' ',  String.valueOf(result.getDividend()).length())
                    + String.valueOf(result.getRemainder()));  
        }
        for (int i = 0; i < sizeDivisionSteps; i++) {
            DivisionStep currentStep = divisionSteps.getFirst();
            int numbsIndent = divisionSteps.getFirst().getIndent();

            sb.append(repeatCharacter(' ', numbsIndent) + MINUS + currentStep.getMinuend() + LINE_BREAKER);
            sb.append(repeatCharacter(' ', numbsIndent + ONE_INDENT) + currentStep.getMultiply() + LINE_BREAKER);
            sb.append(repeatCharacter(' ', numbsIndent + ONE_INDENT)
                    + repeatCharacter(COLUMN_SEPARATOR, String.valueOf(currentStep.getMinuend()).length())
                    + LINE_BREAKER);

            if (i == sizeDivisionSteps - 1) {
                sb.append(repeatCharacter(' ', numbsIndent + String.valueOf(currentStep.getMinuend()).length())
                        + String.valueOf(result.getRemainder()));
            }

            divisionSteps.removeFirst();
        }

        return sb.toString();
    }

    private DivisionResult getResult(int dividend, int divisor) {

        LinkedList<DivisionStep> steps = new LinkedList<>();
        LinkedList<Integer> ListDigitsOfDividend = intToDigis(dividend);
        int minuend = ListDigitsOfDividend.getFirst();
        int countIterationOfCycle = 0;
        int zeroCount = 0;
        int indentCount = 1;

        ListDigitsOfDividend.removeFirst();

        while (!ListDigitsOfDividend.isEmpty()) {
            DivisionStep step = new DivisionStep();

            if (countIterationOfCycle > FIRST_ITERATION) {
                minuend = steps.getLast().getPartialRemainder();
            }

            if (minuend < divisor) {
                minuend = (minuend * DOZENS) + ListDigitsOfDividend.getFirst();
                ListDigitsOfDividend.removeFirst();
                if (minuend == 0) {
                    countIterationOfCycle++;
                    zeroCount++;
                    indentCount++;
                    continue;
                }
            }

            step.setMinuend(minuend);
            step.setPartialQuontient(minuend / divisor);
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

        return new DivisionResult(dividend, divisor, dividend / divisor, dividend % divisor, steps);
    }

    private LinkedList<Integer> intToDigis(int number) {
        LinkedList<Integer> numbs = new LinkedList<>();
        while (number > 0) {
            numbs.add(number % 10);
            number = number / 10;
        }
        Collections.reverse(numbs);
        return numbs;
    }

    private String repeatCharacter(char inputCharacter, int numberOfTimes) {
        if (numberOfTimes == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfTimes; i++) {
            result.append(inputCharacter);
        }
        return result.toString();
    }

}
