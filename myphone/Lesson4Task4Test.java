package myphone;

import java.util.ArrayList;
import myphone.accessory.BluetoothHeadset;
import myphone.accessory.Connectable;
import myphone.accessory.WiredHeadset;

public class Lesson4Task4Test {
    public static void main(String[] args) {
        ArrayList<Connectable> devices = new ArrayList<>();
        devices.add(new WiredHeadset("Sony MDR-EX15"));
        devices.add(new BluetoothHeadset("AirPods Pro", 75));

        for (Connectable device : devices) {
            device.connect();

            if (device instanceof BluetoothHeadset) {
                BluetoothHeadset bt = (BluetoothHeadset) device;
                System.out.println(
                    "Bluetooth battery: " + bt.getBatteryLevel() + "%"
                );
            }
        }

        for (Connectable device : devices) {
            device.disconnect();
        }
    }
}
