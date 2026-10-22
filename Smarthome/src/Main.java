package Smarthome.src;

import Smarthome.src.gagdets.Lamp;
import Smarthome.src.gagdets.Thermostat;

public class Main {
    public static void main(String[] args) {
        testOppgave1();
        testOppgave2();
    }
    private static void testOppgave1() {
        System.out.println("Oppgave1");
        Lamp lamp = new Lamp("Stuelampe", false, 40);
        Thermostat thermostat = new Thermostat("Gangtermostat", false, 21.0);
        SmartDevice[] devices = {lamp, thermostat};

        //Enhetene vises, men er slått av
        System.out.println("Enhetene er slått av");
        showStatus(devices);

        //Vi slår på enhetene og endrer verdiene
        lamp.turnOn();
        thermostat.turnOn();
        lamp.setBrightness(75);
        thermostat.setTemperature(23.0);

        System.out.println("Enhetene er på slått");
        showStatus(devices);


    }

    private static void showStatus(SmartDevice[] devices) {
        for(SmartDevice d: devices) {
            d.displayInfo();
            System.out.println();
        }
    }

    private static void testOppgave2() {
        System.out.println("Oppgave 2");
        SmartHome home = new SmartHome("Boligen");
        home.addDevices(new Lamp("Stuelampe", false, 80));
        home.addDevices(new Lamp("Leselampe", false, 50));
        home.addDevices(new Thermostat("Gang", false, 21.5));

        home.displayAll();

        home.turnOnDevice("Stuelampe");
        home.turnOnDevice("Leselampe");
        home.turnOnDevice("Gang");
        home.displayAll();

        home.turnOffDevice("Leselampe");
        home.displayAll();

        home.turnOffAll();
        home.displayAll();
    }


//Test oppgave 2       
        
        
        



}
