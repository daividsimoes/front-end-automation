package br.com.frontend.automation.driver;

import br.com.frontend.automation.util.SOInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractDriverLoader {

    public static final String WIN = "win";
    public static final String LINUX = "linux";
    public static final String MAC = "mac";
    public static final String UNKNOWN = "unknown";

    protected String resolveInternalSo() {

        if (SOInfo.isWindows()) {

            log.info("Windows S.O");
            return WIN;
        } else if (SOInfo.isLinux()) {

            log.info("Linux S.O");
            return LINUX;
        } else if (SOInfo.isMac()) {

            log.info("Mac S.O");
            return MAC;
        } else {

            log.info("Could not find S.O");
            return UNKNOWN;
        }
    }
}
