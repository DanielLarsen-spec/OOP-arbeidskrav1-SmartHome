package myphone;

import myphone.accessory.Connectable;
import myphone.accessory.WiredHeadset;
import myphone.model.MyPhone;

public class Lesson4Task1Test {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Apple", "iPhone 14", 256, 80);

        // Declared type: Connectable. Actual type: WiredHeadset.
        Connectable device = new WiredHeadset("Sony MDR-EX15");

        // Expectation: Headset.connect() runs, then MyPhone stores the reference.
        phone.connect(device);
        System.out.println("Phone has headset: " + phone.hasHeadset());
        System.out.println("Stored the same object: "
                + (phone.getHeadset() == device));

        device.disconnect();
    }
}
