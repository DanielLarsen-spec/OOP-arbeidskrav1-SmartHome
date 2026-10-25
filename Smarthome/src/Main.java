package Smarthome.src;

import Smarthome.src.gagdets.Lamp;
import Smarthome.src.gagdets.Thermostat;
import myphone.app.CallApp;
import myphone.model.MyPhone;
import Smarthome.src.gagdets.Sensor;

public class Main {
    public static void main(String[] args) {
        testOppgave1();
        testOppgave2();
        testOppgave3();
        testOppgave4();
        testOppgave5();
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

    private static void testOppgave3() {
        System.out.println("Oppgave 3");
        SmartHome home = new SmartHome("Boligen");
        Sensor sensor = new Sensor("Gangsensor", true, false);
        home.addDevices(new Lamp("Stuelampe", false, 50));
        home.addDevices(new Thermostat("Gangtermostat", false, 21.0));
        home.addDevices(sensor);

        System.out.println("Før planlegging");
        home.displayAll();

    
        home.scheduleDevice("Stuelampe", "06:00");
        home.scheduleDevice("Gangtermostat", "06:30");
        home.scheduleDevice("gangsensor", "07:00");

        
        System.out.println("Etter planlegging");
        home.displayAll();

        
        System.out.println("Bevegelse før: " + sensor.isMovementDetected());
        sensor.detectMovement();
        System.out.println("Bevegelse etter: " + sensor.isMovementDetected());
        System.out.println();

        
        System.out.println("Alle planleggbare enheter settes til klokken 22:00");
        for(Timer t : home.getScheduledDevices()) {
            t.setTime("22:00");
        }
        home.displayAll();
    }

    private static void testOppgave4(){
        System.out.println("Oppgave 4");

        SmartHome home = new SmartHome("Boligen");
        Lamp livingRoomLamp = new Lamp("Stuelampe", false, 30);
        Thermostat hallThermostat = new Thermostat("Gangtermostat", false, 19.0);
        home.addDevices(livingRoomLamp);
        home.addDevices(hallThermostat);
        home.addDevices(new Sensor("Gangsensor", true, false));
        //Oppretter telefonen og installerer appen
        MyPhone phone = new MyPhone("Apple", "Iphone 14", 260, 80);
        SmartHomeApp smartHomeApp = new SmartHomeApp("1.0", home);
        phone.installApp(new CallApp("2.0"));
        phone.installApp(smartHomeApp);
        phone.listApps();

        //Starter appene via telefon
        System.out.println("Telefonen starter appene");
        phone.runAllApps();

        //Slår på lampen og endrer lysstyrken via telefonen
        smartHomeApp.turnOn("Stuelampe");
        smartHomeApp.setBrightness("Stuelampe", 80);

        //Endrer temperaturen via telefonen og appen
        smartHomeApp.setTemperature("Gangtermostat", 22.5);

        //Planlegger en enhet via appen
        smartHomeApp.schedule("Stuelampe", "07:00");

        //Viser at typesjekken fungerer
        smartHomeApp.setBrightness("Gangtermostat", 50);

        //Viser hjemme ikke via appen
        System.out.println("Viser hjemme etter endringer i appen");
        home.displayAll();

        //viser til at det er de samme objektene
        System.out.println("Lampens lysstyrke lest fra originale referanser: "
            + livingRoomLamp.getBrightness());
        System.out.println("Samme lampeobjekt i hjemmet: "
            + (home.findDevice("Stuelampe") == livingRoomLamp));
            
        }


    private static void testOppgave5() {
        System.out.println("Oppgave 5 - En morgen i MySmartHome");

        // 1. Morgen-scenario: hjemmet og enhetene settes opp kvelden før
        SmartHome home = new SmartHome("Pilotboligen");
        Lamp bedroomLamp = new Lamp("Soveromslampe", false, 20);
        Lamp kitchenLamp = new Lamp("Kjøkkenlampe", false, 60);
        Thermostat livingRoomThermostat = new Thermostat("Stuetermostat", false, 18.0);
        Sensor hallSensor = new Sensor("Gangsensor", true, false);
        home.addDevices(bedroomLamp);
        home.addDevices(kitchenLamp);
        home.addDevices(livingRoomThermostat);
        home.addDevices(hallSensor);

        // 2. Installer og start SmartHome-appen på MyPhone
        MyPhone phone = new MyPhone("Apple", "iPhone 14", 256, 80);
        SmartHomeApp smartHomeApp = new SmartHomeApp("1.0", home);
        phone.installApp(new CallApp("2.0"));
        phone.installApp(smartHomeApp);

        // 3a. Kvelden før: brukeren planlegger morgenen gjennom appen
        System.out.println("\n 22:00 Kvelden før: morgenen planlegges");
        smartHomeApp.schedule("Stuetermostat", "06:30");
        smartHomeApp.schedule("Soveromslampe", "06:45");
        smartHomeApp.schedule("Kjøkkenlampe", "07:00");

        // Brukeren åpner appen om morgenen og ser de planlagte tidene
        System.out.println("\n 06:45 Brukeren våkner og åpner appen");
        phone.runAllApps();

        // 3b. Morgenhandlinger gjennom appen
        System.out.println("06:50 Morgenhandlinger");
        smartHomeApp.turnOn("Soveromslampe");
        smartHomeApp.setBrightness("Soveromslampe", 40);   // typespesifikk: lampe
        smartHomeApp.turnOn("Stuetermostat");
        smartHomeApp.setTemperature("Stuetermostat", 21.5); // typespesifikk: termostat
        smartHomeApp.turnOn("Kjøkkenlampe");
        smartHomeApp.setBrightness("Kjøkkenlampe", 90);
        home.displayAll();

        // 4. Bevegelsessensoren registrerer at brukeren går gjennom gangen
        System.out.println(" 07:20 Brukeren går gjennom gangen");
        hallSensor.detectMovement();
        System.out.println("Gangsensor registrerte bevegelse: " + hallSensor.isMovementDetected());

        // 5. Brukeren går ut døren og slår av alt med én handling i appen
        System.out.println("\n 07:30 Brukeren forlater hjemmet");
        smartHomeApp.turnOffAll();

        // 6. Sluttoversikt, vist direkte fra hjemmet
        System.out.println("\n Sluttstatus");
        home.displayAll();
        System.out.println("Alle enheter er av: "
                + (!bedroomLamp.isOn() && !kitchenLamp.isOn()
                   && !livingRoomThermostat.isOn() && !hallSensor.isOn()));
    }


     
        
        
        



}
