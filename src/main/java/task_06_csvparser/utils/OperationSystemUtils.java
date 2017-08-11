package task_06_csvparser.utils;

public class OperationSystemUtils {
    private final static String MAC_OS = "mac";
    private final static String WIN_OS = "win";

    /**
     * * Checks is current OS Mac
     * @return true if yes
     */
    public static boolean isMac() {
        return getSystemOS().contains(MAC_OS);
    }

    /**
     * Checks is current OS Windows
     * @return true if yes
     */
    public static boolean isWindows() {
        return getSystemOS().contains(WIN_OS);
    }

    /**
     * Gets OS name
     * @return os name in lower case
     */
    private static String getSystemOS() {
        return System.getProperty("os.name").toLowerCase();
    }
}
