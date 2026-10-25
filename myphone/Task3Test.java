package myphone;

import myphone.app.CallApp;
import myphone.app.FacebookApp;
import myphone.model.MyPhone;

public class Task3Test {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Apple", "iPhone 14", 256, 80);
        FacebookApp facebook = new FacebookApp("1.0");
        CallApp callApp = new CallApp("2.0");

        phone.installApp(facebook);
        phone.installApp(callApp);
        phone.runAllApps();
    }
}
