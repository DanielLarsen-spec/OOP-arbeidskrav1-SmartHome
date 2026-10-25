package myphone.app.general;

public class App {
    protected String appName;
    protected String version;

    public App(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }

    public void run() {
        System.out.println(appName + " is running.");
    }

    public void run(boolean showVersion) {
        run();
        if (showVersion) {
            System.out.println("Version: " + version);
        }
    }

    @Override
    public String toString() {
        return appName + " (version " + version + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof App)) {
            return false;
        }

        App otherApp = (App) obj;
        return this.appName.equals(otherApp.appName)
                && this.version.equals(otherApp.version);
    }
}
