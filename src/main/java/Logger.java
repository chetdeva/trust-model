public class Logger {

    private static Logger logger = null;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String context, Object statement) {
        System.out.println(context + " : " + statement);
    }
}
