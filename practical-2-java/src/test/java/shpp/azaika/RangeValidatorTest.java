package shpp.azaika;


import org.junit.jupiter.api.Test;
import shpp.azaika.util.RangeValidator;

import static org.junit.jupiter.api.Assertions.*;

class RangeValidatorTest {

    @Test
    void testValidateByteRangeValid() {
        RangeValidator.validateRangeOfNumber((byte) 100, NumberType.BYTE);
    }

    @Test
    void testValidateIntegerRangeValid() {
        RangeValidator.validateRangeOfNumber(1000, NumberType.INT);
    }

    @Test
    void testValidateIntegerRangeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                RangeValidator.validateRangeOfNumber(Long.MAX_VALUE, NumberType.INT)
        );
    }

    @Test
    void testValidateDoubleRangeValid() {
        RangeValidator.validateRangeOfNumber(3.14, NumberType.DOUBLE);
    }

}
