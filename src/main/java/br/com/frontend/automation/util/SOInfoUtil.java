package br.com.frontend.automation.util;

public class SOInfoUtil {

    private static final String name = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {

        return (name.contains("win"));
    }

    public static boolean isLinux() {

        return (name.contains("nux"));
    }

    public static boolean isMac() {

        return (name.contains("mac"));
    }
}
