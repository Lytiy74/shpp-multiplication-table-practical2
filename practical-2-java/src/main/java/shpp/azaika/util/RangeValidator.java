package shpp.azaika.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shpp.azaika.NumberType;

public class RangeValidator {
    private static final Logger logger = LoggerFactory.getLogger(RangeValidator.class);

    public static void validateRangeOfNumber(Number value, NumberType numberType) throws IllegalArgumentException {
        logger.debug("Validating range for value: {} and type: {}", value, numberType);
        long longValue = value.longValue();
        double doubleValue = value.doubleValue();

        switch (numberType) {
            case BYTE:
                if (!isInByteRange(longValue)) {
                    throw new IllegalArgumentException("Value " + value + " is out of range for BYTE.");
                }
                break;
            case SHORT:
                if (!isInShortRange(longValue)) {
                    throw new IllegalArgumentException("Value " + value + " is out of range for SHORT.");
                }
                break;
            case INT:
                if (!isInIntegerRange(longValue)) {
                    throw new IllegalArgumentException("Value " + value + " is out of range for INT.");
                }
                break;
            case LONG:
                if (!isInLongRange(longValue)) {
                    throw new IllegalArgumentException("Value " + value + " is out of range for LONG.");
                }
                break;
            case FLOAT:
                if (!isInFloatRange(doubleValue)) {
                    throw new IllegalArgumentException("Value " + value + " is out of range for FLOAT.");
                }
                break;
            case DOUBLE:
                if (!isInDoubleRange(doubleValue)) {
                    throw new IllegalArgumentException("Value " + value + " is out of range for DOUBLE.");
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported number type: " + numberType);
        }
    }

    static boolean isInDoubleRange(double doubleValue) {
        return doubleValue >= Double.MIN_VALUE && doubleValue <= Double.MAX_VALUE;
    }

    static boolean isInFloatRange(double doubleValue) {
        return doubleValue >= Float.MIN_VALUE && doubleValue <= Float.MAX_VALUE;
    }

    static boolean isInLongRange(long longValue) {
        return longValue >= Long.MIN_VALUE && longValue <= Long.MAX_VALUE;
    }

    static boolean isInIntegerRange(long longValue) {
        return longValue >= Integer.MIN_VALUE && longValue <= Integer.MAX_VALUE;
    }

    static boolean isInShortRange(long longValue) {
        return longValue >= Short.MIN_VALUE && longValue <= Short.MAX_VALUE;
    }

    static boolean isInByteRange(long longValue) {
        return longValue >= Byte.MIN_VALUE && longValue <= Byte.MAX_VALUE;
    }
}