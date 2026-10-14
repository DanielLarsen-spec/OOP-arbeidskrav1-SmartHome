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






}
