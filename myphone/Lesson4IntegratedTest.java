package myphone;

import java.util.ArrayList;
import myphone.accessory.BluetoothHeadset;
import myphone.accessory.Charger;
import myphone.accessory.Connectable;
import myphone.accessory.WiredHeadset;
import myphone.app.CallApp;
import myphone.app.FacebookApp;
import myphone.app.general.AppNameComparator;
import myphone.model.MyPhone;
import myphone.power.PerformanceMode;

public class Lesson4IntegratedTest {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Samsung", "Galaxy S24", 256, 90);
        WiredHeadset wired = new WiredHeadset("Sony MDR-EX15");
        BluetoothHeadset bluetooth = new BluetoothHeadset("AirPods Pro", 75);

        System.out.println("--- Wired headset via Connectable ---");
        Connectable device = wired;
        phone.connect(device);
        phone.playRingtone();

        System.out.println("\n--- Switch to Bluetooth headset ---");
        device.disconnect();
        device = bluetooth;
        phone.connect(device);
        phone.playRingtone();
        device.disconnect();

        System.out.println("\n--- Polymorphic list ---");
        ArrayList<Connectable> devices = new ArrayList<>();
        devices.add(wired);
        devices.add(bluetooth);
        devices.add(new Charger(20));

        for (Connectable d : devices) {
            d.connect();

            if (d instanceof BluetoothHeadset) {
                BluetoothHeadset bt = (BluetoothHeadset) d;
                System.out.println(
                    "Bluetooth battery: " + bt.getBatteryLevel() + "%"
                );
            }
        }
        for (Connectable d : devices) {
            d.disconnect();
        }

        System.out.println("\n--- Power modes ---");
        System.out.println("Battery: " + phone.getBatteryLevel() + "%");
        phone.applyPowerMode();
        System.out.println("Battery: " + phone.getBatteryLevel() + "%");
        phone.setPowerMode(new PerformanceMode());
        phone.applyPowerMode();
        System.out.println("Battery: " + phone.getBatteryLevel() + "%");

        System.out.println("\n--- Bonus: sort apps ---");
        phone.installApp(new FacebookApp("1.0"));
        phone.installApp(new CallApp("2.0"));
        phone.sortApps(new AppNameComparator());
        phone.listApps();
        phone.runAllApps();
    }
}
