package myphone;

import myphone.accessory.BluetoothHeadset;
import myphone.accessory.WiredHeadset;
import myphone.model.MyPhone;

public class Lesson4Task2Test {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Apple", "iPhone 14", 256, 80);
        WiredHeadset wired = new WiredHeadset("Sony MDR-EX15");
        BluetoothHeadset bluetooth = new BluetoothHeadset("AirPods Pro", 75);

        phone.playRingtone();

        phone.connect(wired);
        phone.playRingtone();

        phone.detachHeadset().disconnect();
        phone.connect(bluetooth);
        phone.playRingtone();

        // Does not compile - AudioDevice is abstract:
        // AudioDevice device = new AudioDevice("Generic");
    }
}
