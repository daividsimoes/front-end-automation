package br.com.frontend.automation.driver;

import br.com.frontend.automation.util.SOInfoUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractDriverLoader {

    public static final String WIN = "win";
    public static final String LINUX = "linux";
    public static final String MAC = "mac";
    public static final String UNKNOWN = "unknown";

    protected String resolveInternalSo() {

        if (SOInfoUtil.isWindows()) {

            log.info("Windows S.O");
            return WIN;
        } else if (SOInfoUtil.isLinux()) {

            log.info("Linux S.O");
            return LINUX;
        } else if (SOInfoUtil.isMac()) {

            log.info("Mac S.O");
            return MAC;
        } else {

            log.info("Could not find S.O");
            return UNKNOWN;
        }
    }
}
