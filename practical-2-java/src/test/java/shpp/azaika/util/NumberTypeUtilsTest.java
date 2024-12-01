package shpp.azaika.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shpp.azaika.NumberType;

import static org.junit.jupiter.api.Assertions.*;

class NumberTypeUtilsTest {

    @Test
    void testGetSystemNumberTypeDefault() {
        System.setProperty("tableVariableType", "int");
        Assertions.assertEquals(NumberType.INT, NumberTypeUtils.getSystemNumberType());
    }

    @Test
    void testGetSystemNumberTypeInvalidProperty() {
        System.setProperty("tableVariableType", "unknown");
        assertThrows(IllegalStateException.class, () -> NumberTypeUtils.getSystemNumberType());
    }

    @Test
    void testConvertToByte() {
        assertEquals((byte) 10, NumberTypeUtils.convertToType(10L, NumberType.BYTE));
    }

    @Test
    void testConvertToShort() {
        assertEquals((short) 100, NumberTypeUtils.convertToType(100L, NumberType.SHORT));
    }

    @Test
    void testConvertToInt() {
        assertEquals(1000, NumberTypeUtils.convertToType(1000L, NumberType.INT));
    }

    @Test
    void testConvertToLong() {
        assertEquals(10000L, NumberTypeUtils.convertToType(10000L, NumberType.LONG));
    }

    @Test
    void testConvertToFloat() {
        assertEquals(10.5f, NumberTypeUtils.convertToType(10.5, NumberType.FLOAT));
    }

    @Test
    void testConvertToDouble() {
        assertEquals(10.5, NumberTypeUtils.convertToType(10.5, NumberType.DOUBLE));
    }
}
