package myphone;

import java.util.ArrayList;
import myphone.accessory.Charger;
import myphone.accessory.Connectable;
import myphone.accessory.WiredHeadset;
import myphone.app.CallApp;
import myphone.app.FacebookApp;
import myphone.app.general.App;
import myphone.app.general.AppNameComparator;
import myphone.model.MyPhone;

public class Lesson4Task5Test {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Apple", "iPhone 14", 256, 80);

        System.out.println("--- A: Sort apps with Comparator ---");
        phone.installApp(new FacebookApp("1.0"));
        phone.installApp(new CallApp("2.0"));
        phone.installApp(new App("Camera", "3.1"));
        System.out.println("Before sorting:");
        phone.listApps();
        phone.sortApps(new AppNameComparator());
        System.out.println("After sorting:");
        phone.listApps();

        System.out.println("\n--- B: Charger as Connectable ---");
        Connectable headset = new WiredHeadset("Sony MDR-EX15");
        Connectable charger = new Charger(20);
        phone.connect(headset);
        phone.connect(charger);

        ArrayList<Connectable> devices = new ArrayList<>();
        devices.add(headset);
        devices.add(charger);
        for (Connectable device : devices) {
            device.disconnect();
        }
    }
}
