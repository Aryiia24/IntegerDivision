package ru.fedormakarov.task4;

public class Main {

    public static void main(String[] args) {
        IntegerDivision integerDivision = new IntegerDivision();
        Result result = integerDivision.divide(70540, 4);
        IntegerDivisionFormatter divisionFormatter = new IntegerDivisionFormatter();
        String resultString = divisionFormatter.formatDivision(result);
        System.out.println(resultString);

    }

}
