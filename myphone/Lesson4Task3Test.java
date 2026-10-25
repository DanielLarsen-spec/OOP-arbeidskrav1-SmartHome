package myphone;

import myphone.model.MyPhone;
import myphone.power.EcoMode;
import myphone.power.PerformanceMode;
import myphone.power.PowerMode;

public class Lesson4Task3Test {
    public static void main(String[] args) {
        MyPhone phone = new MyPhone("Apple", "iPhone 14", 256, 80);
        System.out.println("Battery: " + phone.getBatteryLevel() + "%");

        // Starts in EcoMode
        phone.applyPowerMode();
        System.out.println("Battery: " + phone.getBatteryLevel() + "%");

        phone.setPowerMode(new PerformanceMode());
        phone.applyPowerMode();
        System.out.println("Battery: " + phone.getBatteryLevel() + "%");

        // Upcasting happens here: EcoMode/PerformanceMode -> PowerMode
        PowerMode eco = new EcoMode();
        PowerMode performance = new PerformanceMode();
        System.out.println("eco.name(): " + eco.name());
        System.out.println("performance.name(): " + performance.name());
    }
}
