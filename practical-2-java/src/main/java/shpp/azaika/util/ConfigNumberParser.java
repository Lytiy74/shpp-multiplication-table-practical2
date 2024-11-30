package shpp.azaika.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigNumberParser implements Parser {
    private static final Logger logger = LoggerFactory.getLogger(ConfigNumberParser.class);

    @Override
    public Number parse(String s) {
        try {
            if (s.contains(".")) { // float or double
                if (s.contains("f")) return Float.parseFloat(s);
                return Double.parseDouble(s);
            } else {
                long longValue = Long.parseLong(s);
                if (longValue <= Byte.MAX_VALUE && longValue >= Byte.MIN_VALUE) {
                    return Byte.parseByte(s);
                } else if (longValue <= Short.MAX_VALUE && longValue >= Short.MIN_VALUE) {
                    return Short.parseShort(s);
                } else if (longValue <= Integer.MAX_VALUE && longValue >= Integer.MIN_VALUE) {
                    return Integer.parseInt(s);
                }
                return longValue;
            }
        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw new NumberFormatException(e.getMessage());
        }
    }
}
