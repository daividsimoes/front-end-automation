package br.com.frontend.automation.driver;

import br.com.frontend.automation.enums.SO;
import br.com.frontend.automation.util.SOInfoUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractDriverLoader {

    protected String resolveInternalSo() {

        if (SOInfoUtil.isWindows()) {

            log.info("Windows S.O");
            return SO.WINDOWS.getSo();
        } else if (SOInfoUtil.isLinux()) {

            log.info("Linux S.O");
            return SO.LINUX.getSo();
        } else if (SOInfoUtil.isMac()) {

            log.info("Mac S.O");
            return SO.MAC.getSo();
        } else {

            log.info("Could not find S.O");
            return SO.UNKNOWN.getSo();
        }
    }
}
