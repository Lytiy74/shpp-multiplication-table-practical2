package shpp.azaika;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shpp.azaika.util.*;


public class MultiplicationTableApp {
    private static Logger logger = LoggerFactory.getLogger(MultiplicationTableApp.class);

    public static void main(String[] args) {
        Parser numberParser = new ConfigNumberParser();

        Number minValue = (Number) numberParser.parse(Config.getProperty("table.calculation.minValue"));
        Number maxValue = (Number) numberParser.parse(Config.getProperty("table.calculation.maxValue"));
        Number increment = (Number) numberParser.parse(Config.getProperty("table.calculation.increment"));

        NumberType numberType = NumberTypeUtils.getSystemNumberType();

        RangeValidator.validateRangeOfNumber(minValue, numberType);
        RangeValidator.validateRangeOfNumber(maxValue, numberType);
        RangeValidator.validateRangeOfNumber(increment, numberType);

        minValue = NumberTypeUtils.convertToType(minValue, numberType);
        maxValue = NumberTypeUtils.convertToType(maxValue, numberType);
        increment = NumberTypeUtils.convertToType(increment, numberType);
        printMultiplicationTable(minValue, maxValue, increment);
    }

    private static void printMultiplicationTable(Number minValue, Number maxValue, Number incrementValue) {
        if (minValue instanceof Double || minValue instanceof Float) {
            printForFloatingPoint(minValue.doubleValue(), maxValue.doubleValue(), incrementValue.doubleValue());
        } else if (minValue instanceof Long || minValue instanceof Integer) {
            printForInteger(minValue.longValue(), maxValue.longValue(), incrementValue.longValue());
        }
    }

    private static void printForFloatingPoint(double min, double max, double increment) {
        while (min <= max) {
            for (double i = min; i < max; i += increment) {
                logger.info("{} * {} = {}", min, i, min * i);
            }
            min += increment;
        }
    }

    private static void printForInteger(long min, long max, long increment) {
        while (min <= max) {
            for (long i = min; i < max; i += increment) {
                logger.info("{} * {} = {}", min, i, min * i);
            }
            min += increment;
        }
    }



}
