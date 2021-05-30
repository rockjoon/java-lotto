package lotto;

import java.math.BigDecimal;

public class divideUtil {

    public static final int DIVIDE_SCALE_SIZE = 2;

    private divideUtil() {
    }

    public static double divide(int numerator, int denominator) {
        return BigDecimal.valueOf(numerator).divide(
                BigDecimal.valueOf(denominator),
                DIVIDE_SCALE_SIZE,
                BigDecimal.ROUND_HALF_EVEN
        ).doubleValue();
    }

}
