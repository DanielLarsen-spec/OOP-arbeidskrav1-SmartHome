package myphone.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import myphone.accessory.Connectable;
import myphone.accessory.Headset;
import myphone.app.general.App;
import myphone.power.EcoMode;
import myphone.power.PowerMode;

public class MyPhone {
    private String brand;
    private String model;
    private int storageCapacity;
    private final Battery battery;
    private ArrayList<App> apps;
    private Headset headset;
    private PowerMode powerMode = new EcoMode();
    private static int phoneCount = 0;

    public MyPhone(String brand, String model,
                   int storageCapacity, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.storageCapacity = storageCapacity;
        this.battery = new Battery(batteryLevel);
        this.apps = new ArrayList<>();
        phoneCount++;
    }

    public String getModel() {
        return model;
    }

    public int getBatteryLevel() {
        return battery.getLevel();
    }

    public void displayInfo() {
        System.out.println("Phone: " + brand + " " + model);
        System.out.println("Storage: " + storageCapacity + " GB");
        System.out.println("Battery: " + battery.getLevel() + "%");
    }

    public void installApp(App app) {
        apps.add(app);
    }

    public void listApps() {
        for (App app : apps) {
            System.out.println(app);
        }
    }

    public void runAllApps() {
        for (App app : apps) {
            app.run();
        }
    }

    public void sortApps(Comparator<App> comparator) {
        Collections.sort(apps, comparator);
    }

    public void attachHeadset(Headset headset) {
        this.headset = headset;
    }

    public Headset detachHeadset() {
        Headset detached = this.headset;
        this.headset = null;
        return detached;
    }

    public boolean hasHeadset() {
        return headset != null;
    }

    public Headset getHeadset() {
        return headset;
    }

    public void connect(Connectable c) {
        c.connect();

        if (c instanceof Headset) {
            Headset h = (Headset) c;
            this.headset = h;
            System.out.println("Connected headset: " + h.getModel());
        }
    }

    public void playRingtone() {
        if (headset == null) {
            System.out.println("No audio device connected.");
        } else {
            headset.play("Ringtone");
        }
    }

    public void setPowerMode(PowerMode mode) {
        this.powerMode = mode;
    }

    public void applyPowerMode() {
        System.out.println("Power mode: " + powerMode.name());
        powerMode.adjust(battery);
    }

    public static int getPhoneCount() {
        return phoneCount;
    }
}
