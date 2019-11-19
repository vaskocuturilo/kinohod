package ru.kinohod.environment;


/**
 * The type Environment.
 */
public class Environment {

    /**
     * Method isCheckOSSystem.
     * If method return true, that is automation scripts to run on OS Unix or Linux.
     * If method return false, that is automation scripts to run on OS Windows or Mac.
     *
     * @return the boolean.
     */
    public static boolean isCheckOperationSystem() {

        String systemName = System.getProperty("os.name");
        return (systemName.contains("nix") || systemName.contains("nux"));
    }
}
