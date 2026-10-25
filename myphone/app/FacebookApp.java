package myphone.app;

import myphone.app.general.App;
import myphone.model.MyPhone;

public class FacebookApp extends App {
    public FacebookApp(String version) {
        super("Facebook", version);
    }

    @Override
    public void run() {
        System.out.println("Facebook opens the news feed.");
    }

    public void use(MyPhone phone) {
        System.out.println(appName + " is used on " + phone.getModel());
    }
}
