package util;

public class App {
    private static ClassLoader classLoader;
    private static App app;

    private App() {
    }

    public static App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    public ClassLoader getClassLoader() {
        if (classLoader == null) {
            classLoader = getClass().getClassLoader();
        }
        return classLoader;
    }
}
