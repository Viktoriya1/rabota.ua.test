package testLogger;

public class ConsoleLogger extends AbstractLogger {

    @Override
    protected void doLogging(String stringToLog) {

        System.out.println(stringToLog);
    }
}
