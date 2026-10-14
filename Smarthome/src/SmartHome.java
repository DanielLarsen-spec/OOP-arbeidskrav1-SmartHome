package Smarthome.src;

import java.util.ArrayList;

public class SmartHome {
   private String name;
   private ArrayList<SmartDevice> devices = new ArrayList<>();
    
   public SmartHome(String name) {
    this.name = name;
   }

   public void addDevices(SmartDevice device) {
    devices.add(device);
   }

   public SmartDevice findDevice(String deviceName) {
    for(SmartDevice d : devices) {
        if(d.getName().equalsIgnoreCase(deviceName)) {
            return d;
        }
    }
    return null;
   }

   public void turnOnDevice(String devicename) {
    SmartDevice d = findDevice(devicename);
    if(d != null) {
        d.turnOn();
    } else {
        System.out.println("Fant ingen enheter med navn: " + devicename);
    }
   }
   public void turnOffAll() {
    for(SmartDevice d: devices) {
        d.turnOff();
    }
   }

   public void displayAll() {
    System.out.println("===" + devices + "===");
   }
}
