package myphone;

import myphone.app.FacebookApp;

public class Task6Test {
    public static void main(String[] args) {
        FacebookApp app1 = new FacebookApp("1.0");
        FacebookApp app2 = new FacebookApp("1.0");
        FacebookApp app3 = new FacebookApp("2.0");

        System.out.println(app1);
        System.out.println("app1 == app2: " + (app1 == app2));
        System.out.println("app1.equals(app2): " + app1.equals(app2));
        System.out.println("app1.equals(app3): " + app1.equals(app3));
    }
}
