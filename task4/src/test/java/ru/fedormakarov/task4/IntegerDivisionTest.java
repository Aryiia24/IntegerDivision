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

    @DisplayName("Testing divide method on correct output")
    @Test
    void exceptReturnOutput() {

        assertEquals("_78945|4\r\n" + " 4    |-----\r\n" + " -    |19736\r\n" + "_38\r\n" + " 36\r\n" + " --\r\n"
                + " _29\r\n" + "  28\r\n" + "  --\r\n" + "  _14\r\n" + "   12\r\n" + "   --\r\n" + "   _25\r\n"
                + "    24\r\n" + "    --\r\n" + "     1", integerDivision.divide(78945, 4));
        assertEquals(
                "_1005500|4\r\n" + " 8      |------\r\n" + " -      |251375\r\n" + "_20\r\n" + " 20\r\n" + " --\r\n"
                        + " _5\r\n" + "  4\r\n" + "  -\r\n" + "  _15\r\n" + "   12\r\n" + "   --\r\n" + "   _30\r\n"
                        + "    28\r\n" + "    --\r\n" + "    _20\r\n" + "     20\r\n" + "     --\r\n" + "      1",
                integerDivision.divide(1005500, 4));
    }
    
    
}
