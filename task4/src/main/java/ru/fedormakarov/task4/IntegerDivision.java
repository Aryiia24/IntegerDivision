package ru.fedormakarov.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class IntegerDivision {
    LinkedList<DivisionSteps> steps = new LinkedList<DivisionSteps>();
    public Result divide(int dividend, int divisor) {
        LinkedList<Integer> numbsDividend = intToNumbers(dividend);
        int minuend = numbsDividend.getFirst();
        numbsDividend.removeFirst();
        
        while (!numbsDividend.isEmpty()) {
            if(minuend<divisor) {
               
                
            }
        }

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

class DivisionSteps {
    private int remainderNumber;
    private int multiply;
    private int partialQuontient;
    private int indent;

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public void setRemainderNumber(int remainderNumber) {
        this.remainderNumber = remainderNumber;
    }

    public void setMultiply(int multiply) {
        this.multiply = multiply;
    }

    public void setPartialQuontient(int partialQuontient) {
        this.partialQuontient = partialQuontient;
    }

    public int getRemainderNumber() {
        return remainderNumber;
    }

    public int getMultiply() {
        return multiply;
    }

    public int getPartialQuontient() {
        return partialQuontient;
    }

}
