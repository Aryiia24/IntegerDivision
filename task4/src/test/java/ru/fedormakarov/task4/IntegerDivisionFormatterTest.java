package ru.fedormakarov.task4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerDivisionFormatterTest {

    private IntegerDivision integerDivision = new IntegerDivision();
    private IntegerDivisionFormatter divisionFormatter = new IntegerDivisionFormatter();

    @Test
    @DisplayName("Testing method to format Division on expected conclusion")
    void testFormat() {
        assertEquals(
                "_78945|4\r\n" 
              + " 4    |-----\r\n" 
              + " -    |19736\r\n" 
              + "_38\r\n" 
              + " 36\r\n" 
              + " --\r\n"         
              + " _29\r\n" 
              + "  28\r\n" 
              + "  --\r\n" 
              + "  _14\r\n" 
              + "   12\r\n" 
              + "   --\r\n" 
              + "   _25\r\n"
              + "    24\r\n" 
              + "    --\r\n" 
              + "     1",
                divisionFormatter.formatDivision(integerDivision.divide(78945, 4)));
    }

    @Test
    @DisplayName("Testing method to format Division on entering null")
    void expectIllegalArgumentsException() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> divisionFormatter.formatDivision(null));
    }

}
