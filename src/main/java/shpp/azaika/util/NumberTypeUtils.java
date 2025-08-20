package shpp.azaika.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shpp.azaika.NumberType;


public class NumberTypeUtils {
    private static final Logger logger = LoggerFactory.getLogger(NumberTypeUtils.class);
    private NumberTypeUtils() {
    }

    public static NumberType getSystemNumberType() {
        String property = System.getProperty("tableVariableType", "int").toLowerCase();
        logger.debug("Retrieved tableVariableType from property: [{}]", property);
        return switch (property) {
            case "byte" -> NumberType.BYTE;
            case "short" -> NumberType.SHORT;
            case "int", "integer" -> NumberType.INT;
            case "long" -> NumberType.LONG;
            case "float" -> NumberType.FLOAT;
            case "double" -> NumberType.DOUBLE;
            default -> throw new IllegalStateException("Unexpected value: " + property);
        };
    }

    public static Number convertToType(Number value, NumberType numberType) {
        logger.debug("Converting value type [{}] to type [{}]", value.getClass().getSimpleName(), numberType);
        return switch (numberType) {
            case BYTE -> value.byteValue();
            case SHORT -> value.shortValue();
            case INT -> value.intValue();
            case LONG -> value.longValue();
            case FLOAT -> value.floatValue();
            case DOUBLE -> value.doubleValue();
        };
    }
}
