package configuration;

import io.github.cdimascio.dotenv.Dotenv;

public final class Config {

    private static Dotenv dotenv = Dotenv.configure().load();

    public static String correctEmail = dotenv.get("CORRECT_MAIL");
    public static String correctPass = dotenv.get("CORRECT_PASSWORD");

    public static int waitTimeout = Integer.parseInt(dotenv.get("WAIT_TIMEOUT"));
}
