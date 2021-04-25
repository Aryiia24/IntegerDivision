package ru.fedormakarov.task4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerDivisionTest {

    private IntegerDivision integerDivision = new IntegerDivision();

    @DisplayName("Testing divide method on throw Exceptions")
    @Test
    void expectIllegalArgumentsException() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> integerDivision.divide(1, 0));
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> integerDivision.divide(1, 2));
    }
    
    @DisplayName("Testing divide method on return correct result")
    @Test
    void exceptReturnResult() {
        Result expectResult = new Result(512, 2, 256, 0);
        assertEquals(expectResult, integerDivision.divide(512, 2));
    }

}
