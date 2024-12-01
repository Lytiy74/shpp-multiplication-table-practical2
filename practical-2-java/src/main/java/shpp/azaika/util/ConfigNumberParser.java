package shpp.azaika.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigNumberParser implements Parser {
    private static final Logger logger = LoggerFactory.getLogger(ConfigNumberParser.class);

    @Override
    public Number parse(String s) {
        try {
            if (s.contains(".")) {
                if (s.contains("f")) {
                    logger.debug("[{}] parsed to FLOAT",s);
                    return Float.parseFloat(s);
                }
                logger.debug("[{}] parsed to DOUBLE",s);
                return Double.parseDouble(s);
            } else {
                long longValue = Long.parseLong(s);
                if (longValue <= Byte.MAX_VALUE && longValue >= Byte.MIN_VALUE) {
                    logger.debug("[{}] parsed to BYTE",s);
                    return Byte.parseByte(s);
                } else if (longValue <= Short.MAX_VALUE && longValue >= Short.MIN_VALUE) {
                    logger.debug("[{}] parsed to SHORT",s);
                    return Short.parseShort(s);
                } else if (longValue <= Integer.MAX_VALUE && longValue >= Integer.MIN_VALUE) {
                    logger.debug("[{}] parsed to INT",s);
                    return Integer.parseInt(s);
                }
                logger.debug("[{}] parsed to Long",s);
                return longValue;
            }
        } catch (NumberFormatException e) {
            logger.error("[{}] parsing failed",s);
            throw new NumberFormatException(e.getMessage());
        }
    }
}
