package myphone;

import myphone.app.CallApp;
import myphone.app.general.App;

public class Task4Test {
    public static void main(String[] args) {
        App app = new CallApp("2.0");

        app.run();

        // Uncomment this line to observe the compilation error:
        // app.makeCall("12345678", 4);
    }
}
