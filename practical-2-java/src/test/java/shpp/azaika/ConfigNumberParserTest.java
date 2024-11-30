package shpp.azaika;

import org.junit.jupiter.api.Test;
import shpp.azaika.util.ConfigNumberParser;

import static org.junit.jupiter.api.Assertions.*;

class ConfigNumberParserTest {

    private final ConfigNumberParser parser = new ConfigNumberParser();

    @Test
    void testParseInteger() {
        Number result = parser.parse("42");
        assertInstanceOf(Byte.class, result);
    }

    @Test
    void testParseLong() {
        Number result = parser.parse("123456789");
        assertInstanceOf(Integer.class, result);
    }

    @Test
    void testParseFloat() {
        Number result = parser.parse("3.14f");
        assertEquals(3.14f, result);
        assertInstanceOf(Float.class, result);
    }

    @Test
    void testParseDouble() {
        Number result = parser.parse("3.1415");
        assertEquals(3.1415, result);
        assertInstanceOf(Double.class, result);
    }

    @Test
    void testParseInvalidNumber() {
        assertThrows(NumberFormatException.class, () -> parser.parse("invalid"));
    }
}
