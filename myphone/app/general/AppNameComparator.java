package myphone.app.general;

import java.util.Comparator;

public class AppNameComparator implements Comparator<App> {
    @Override
    public int compare(App a, App b) {
        return a.appName.compareToIgnoreCase(b.appName);
    }
}
