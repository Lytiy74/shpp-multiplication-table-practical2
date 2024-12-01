package shpp.azaika;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shpp.azaika.util.*;


public class MultiplicationTableApp {
    private static final Logger logger = LoggerFactory.getLogger(MultiplicationTableApp.class);

    public static void main(String[] args) {
        Parser numberParser = new ConfigNumberParser();

        Number minValue = numberParser.parse(Config.getProperty("table.calculation.minValue"));
        Number maxValue = numberParser.parse(Config.getProperty("table.calculation.maxValue"));
        Number increment = numberParser.parse(Config.getProperty("table.calculation.increment"));

        NumberType numberType = NumberTypeUtils.getSystemNumberType();

        validateRange(minValue, maxValue, increment, numberType);

        minValue = NumberTypeUtils.convertToType(minValue, numberType);
        maxValue = NumberTypeUtils.convertToType(maxValue, numberType);
        increment = NumberTypeUtils.convertToType(increment, numberType);
        printMultiplicationTable(minValue, maxValue, increment);
    }

    private static void validateRange(Number minValue, Number maxValue, Number increment, NumberType numberType) {
        logger.debug("Validating MINVALUE = [{}] [{}] , MAXVALUE = [{}] [{}] , INCREMENT = [{}] [{}], if they are in range of [{}]", minValue, minValue.getClass().getSimpleName(), maxValue, maxValue.getClass().getSimpleName(), increment
                , increment.getClass().getSimpleName(), numberType);
        RangeValidator.validateRangeOfNumber(minValue, numberType);
        RangeValidator.validateRangeOfNumber(maxValue, numberType);
        RangeValidator.validateRangeOfNumber(increment, numberType);

        if (minValue.doubleValue() >= maxValue.doubleValue()) {
            IllegalArgumentException e = new  IllegalArgumentException("minValue must be less than maxValue");
            logger.error(e.getMessage(),e);
            throw e;
        }
        if (increment.doubleValue() <= 0) {
            IllegalArgumentException e = new  IllegalArgumentException("increment must be greater than 0");
            logger.error(e.getMessage(),e);
            throw e;
        }
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
