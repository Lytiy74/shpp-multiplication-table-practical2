package shpp.azaika.util;


import org.junit.jupiter.api.Test;
import shpp.azaika.NumberType;

import static org.junit.jupiter.api.Assertions.*;

class RangeValidatorTest {
    @Test
    void testValidateByteRangeValid() {
        assertDoesNotThrow(() ->
                RangeValidator.validateRangeOfNumber((byte) 100, NumberType.BYTE)
        );
    }

    @Test
    void testValidateByteRangeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                RangeValidator.validateRangeOfNumber(200, NumberType.BYTE)
        );
    }

    @Test
    void testValidateShortRangeValid() {
        assertDoesNotThrow(() ->
                RangeValidator.validateRangeOfNumber((short) 200, NumberType.SHORT)
        );
    }

    @Test
    void testValidateShortRangeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                RangeValidator.validateRangeOfNumber(32768, NumberType.SHORT)
        );
    }

    @Test
    void testValidateIntegerRangeValid() {
        assertDoesNotThrow(() ->
                RangeValidator.validateRangeOfNumber(1000, NumberType.INT)
        );
    }

    @Test
    void testValidateIntegerRangeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                RangeValidator.validateRangeOfNumber(Long.MAX_VALUE, NumberType.INT)
        );
    }

    @Test
    void testValidateLongRangeValid() {
        assertDoesNotThrow(() ->
                RangeValidator.validateRangeOfNumber(100000L, NumberType.LONG)
        );
    }

    @Test
    void testValidateLongRangeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                RangeValidator.validateRangeOfNumber(Double.MAX_VALUE+1000000000, NumberType.LONG)
        );
    }

    @Test
    void testValidateFloatRangeValid() {
        assertDoesNotThrow(() ->
                RangeValidator.validateRangeOfNumber(1.23f, NumberType.FLOAT)
        );
    }

    @Test
    void testValidateFloatRangeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                RangeValidator.validateRangeOfNumber(Double.MAX_VALUE, NumberType.FLOAT)
        );
    }

    @Test
    void testValidateDoubleRangeValid() {
        assertDoesNotThrow(() ->
                RangeValidator.validateRangeOfNumber(12345.6789, NumberType.DOUBLE)
        );
    }

    @Test
    void testValidateDoubleRangeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                RangeValidator.validateRangeOfNumber(Double.POSITIVE_INFINITY, NumberType.DOUBLE)
        );
    }



}
