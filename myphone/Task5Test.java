package myphone;

import myphone.app.CallApp;
import myphone.app.FacebookApp;
import myphone.app.general.App;

public class Task5Test {
    public static void main(String[] args) {
        App[] apps = {
            new FacebookApp("1.0"),
            new CallApp("2.0")
        };

        for (App app : apps) {
            app.run();

            if (app instanceof CallApp) {
                CallApp callApp = (CallApp) app;
                callApp.makeCall("12345678", 4);
                callApp.printCallHistory();
            }
        }
    }
}
