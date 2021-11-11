package br.com.frontend.automation.util;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class StringUtil {

    public static String normalizeText(String text, Object... args) {

        return MessageFormat.format(text, args);
    }

    public static BigDecimal normalizePriceValue(String price) {

        if(price.contains("$"))
            return new BigDecimal(
                    price.replaceAll(" ", "").replace("$", "")
            );

        return new BigDecimal(price);
    }
}
