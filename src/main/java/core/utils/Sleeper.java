package core.utils;

public class Sleeper {
    public static void sleepInSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
