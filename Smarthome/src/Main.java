package Smarthome.src;

import Smarthome.src.gagdets.Lamp;
import Smarthome.src.gagdets.Thermostat;

public class Main {
    public static void main(String[] args) {
        Lamp lamp = new Lamp("Stuelampe", false, 75);
        Thermostat thermostat = new Thermostat("Gang", true, 21.5);
        
        lamp.turnOn();

        SmartDevice[] devices = {lamp, thermostat};
        for(SmartDevice d : devices) {
            d.displayInfo();
        }
        
    }
        
        
        
        
        



}
