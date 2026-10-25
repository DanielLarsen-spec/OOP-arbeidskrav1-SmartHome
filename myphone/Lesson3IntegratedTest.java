package myphone;

import myphone.app.CallApp;
import myphone.app.FacebookApp;
import myphone.app.general.App;
import myphone.model.MyPhone;

public class Lesson3IntegratedTest {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Samsung", "Galaxy S24", 256, 90);
        FacebookApp facebook = new FacebookApp("1.0");
        CallApp callApp = new CallApp("2.0");

        phone.installApp(facebook);
        phone.installApp(callApp);

        System.out.println("--- Run all apps ---");
        phone.runAllApps();

        System.out.println("\n--- Run Facebook with version ---");
        facebook.run(true);

        System.out.println("\n--- Work through an App reference ---");
        App selectedApp = callApp;
        selectedApp.run();

        if (selectedApp instanceof CallApp) {
            CallApp selectedCallApp = (CallApp) selectedApp;
            selectedCallApp.makeCall("99887766", 3);
            selectedCallApp.printCallHistory();
        }

        System.out.println("\n--- Object methods ---");
        System.out.println(facebook);
        System.out.println(callApp);

        FacebookApp sameVersion = new FacebookApp("1.0");
        System.out.println("facebook == sameVersion: "
                + (facebook == sameVersion));
        System.out.println("facebook.equals(sameVersion): "
                + facebook.equals(sameVersion));
    }
}
