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

   public void turnOffDevice(String devicename){
    SmartDevice d = findDevice(devicename);
    if(d != null) {
        d.turnOff();
    } else{
        System.out.println("Fant ingen enheter med navn: " + devicename);
    }
   }

   public void turnOffAll() {
    for(SmartDevice d: devices) {
        d.turnOff();
    }
   }

   public void scheduleDevice(String deviceName, String time) {
    SmartDevice d = findDevice(deviceName);
    if(d instanceof Timer t) {
        t.setTime(time);
    } else{ 
        System.out.println(deviceName +" Enheten støtter ikke tidsinnstilling");
    }
   }

   public ArrayList<Timer> getScheduledDevices() {
    ArrayList<Timer> result = new ArrayList<>();
    for(SmartDevice d : devices) {
        if(d instanceof Timer t) {
            result.add(t);
        }
    }
    return result;
   }

   public void displayAll() {
    System.out.println("===" + name + "===");
    for(SmartDevice d : devices) {
        d.displayInfo();
        System.out.println();
    }
   }
}
