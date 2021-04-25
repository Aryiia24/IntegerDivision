package ru.fedormakarov.task4;

import java.util.LinkedList;

public class IntegerDivisionFormatter {

    public String formatDivision(Result result) {
        if(result == null) {
            throw new IllegalArgumentException("Result shouldn't be null");
        }
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
            sb.append(repeatsCharacters(' ', numbsIndent + 1) + currentStep.getMultiply() + "\r\n");
            sb.append(repeatsCharacters(' ', numbsIndent + 1)
                    + repeatsCharacters('-', String.valueOf(currentStep.getMinuend()).length()) + "\r\n");
            if (i == sizeDivisionSteps - 1) {
                sb.append(repeatsCharacters(' ', numbsIndent+String.valueOf(currentStep.getMinuend()).length()) + String.valueOf(currentStep.getPartialRemainder()));
            }
            divisionSteps.removeFirst();
        }

        return sb.toString();
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
