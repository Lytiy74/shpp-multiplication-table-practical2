package shpp.azaika.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shpp.azaika.NumberType;

import java.util.EnumMap;
import java.util.function.Predicate;

public class RangeValidator {
    private static final Logger logger = LoggerFactory.getLogger(RangeValidator.class);

    private RangeValidator() {
    }

    private static final EnumMap<NumberType, Predicate<Number>> VALIDATION_MAP = new EnumMap<>(NumberType.class);

    static {
        VALIDATION_MAP.put(NumberType.BYTE, value -> isInRange(value.longValue(), Byte.MIN_VALUE, Byte.MAX_VALUE));
        VALIDATION_MAP.put(NumberType.SHORT, value -> isInRange(value.longValue(), Short.MIN_VALUE, Short.MAX_VALUE));
        VALIDATION_MAP.put(NumberType.INT, value -> isInRange(value.longValue(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        VALIDATION_MAP.put(NumberType.LONG, value -> isInRange(value.doubleValue(), Long.MIN_VALUE, Long.MAX_VALUE));
        VALIDATION_MAP.put(NumberType.FLOAT, value -> isInRange(value.doubleValue(), -Float.MAX_VALUE, Float.MAX_VALUE));
        VALIDATION_MAP.put(NumberType.DOUBLE, value -> isInRange(value.doubleValue(), -Double.MAX_VALUE, Double.MAX_VALUE));
    }

    public static void validateRangeOfNumber(Number value, NumberType numberType) {
        logger.debug("Validating range for value: [{}] and type: [{}]", value, numberType);

        Predicate<Number> validator = VALIDATION_MAP.get(numberType);
        if (validator == null) {
            IllegalArgumentException e = new IllegalArgumentException("Invalid number type: " + numberType);
            logger.error(e.getMessage(),e);
            throw e;
        }

        if (!validator.test(value)) {
           IllegalArgumentException e = new IllegalArgumentException(
                    String.format("Value %s is out of range for %s.", value, numberType));
            logger.error(e.getMessage(), e);
            throw e;
        }
        logger.debug("Value [{}] is in valid range of [{}]", value, numberType);
    }

    private static boolean isInRange(long value, long min, long max) {
        return value >= min && value <= max;
    }

    private static boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }
}
