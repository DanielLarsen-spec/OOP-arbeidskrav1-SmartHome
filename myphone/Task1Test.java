package myphone;

import myphone.app.CallApp;
import myphone.app.FacebookApp;

public class Task1Test {
    public static void main(String[] args) {
        FacebookApp facebook = new FacebookApp("1.0");
        CallApp callApp = new CallApp("2.0");

        facebook.run();
        callApp.run();
    }
}
