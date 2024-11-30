package shpp.azaika.util;

import shpp.azaika.NumberType;

import static shpp.azaika.NumberType.SHORT;

public class NumberTypeUtils {
    private NumberTypeUtils() {}
    public static NumberType getSystemNumberType() {
        String property = System.getProperty("tableVariableType", "int").toLowerCase();
        return switch (property) {
            case "byte" -> NumberType.BYTE;
            case "short" -> SHORT;
            case "int", "integer" -> NumberType.INT;
            case "long" -> NumberType.LONG;
            case "float" -> NumberType.FLOAT;
            case "double" -> NumberType.DOUBLE;
            default -> throw new IllegalStateException("Unexpected value: " + property);
        };
    }

    public static Number convertToType(Number value, NumberType numberType) {
        return switch (numberType) {
            case BYTE -> (byte) value.longValue();
            case SHORT -> (short) value.longValue();
            case INT -> (int) value.longValue();
            case LONG -> value.longValue();
            case FLOAT -> value.floatValue();
            case DOUBLE -> value.doubleValue();
            default -> throw new IllegalArgumentException("Unsupported number type: " + numberType);
        };
    }
}
