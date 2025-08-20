package shpp.azaika.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigNumberParserTest {

    private final ConfigNumberParser parser = new ConfigNumberParser();

    @Test
    void testParseByte() {
        Number result = parser.parse("127");
        assertInstanceOf(Byte.class, result);
    }
    @Test
    void testParseShort() {
        Number result = parser.parse("32767");
        assertInstanceOf(Short.class, result);
    }
    @Test
    void testParseInteger() {
        Number result = parser.parse("2147483647");
        assertInstanceOf(Integer.class, result);
    }

    @Test
    void testParseLong() {
        Number result = parser.parse("9223372036854775807");
        assertInstanceOf(Long.class, result);
    }

    @Test
    void testParseFloat() {
        Number result = parser.parse("3.40282347e+38f");
        assertInstanceOf(Float.class, result);
    }

    @Test
    void testParseDouble() {
        Number result = parser.parse("1.79769313486231570e+308");
        assertInstanceOf(Double.class, result);
    }

    @Test
    void testParseInvalidNumber() {
        assertThrows(NumberFormatException.class, () -> parser.parse("invalid"));
    }
}
