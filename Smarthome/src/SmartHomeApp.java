package Smarthome.src;
import myphone.app.general.App;

public class SmartHomeApp extends App {
    private SmartHome home;

    public SmartHomeApp(String version, SmartHome home ) {
        super("SmartHome", version);
        this.home = home;
    }
    @Override
    public void run() {
        System.out.println("SmartHome appen er åpnet");
        home.displayAll();
    }

    public void turnOn(String deviceName){
        home.turnOnDevice(deviceName);
    }

    public void turnOff(String deviceName){
        home.turnOffDevice(deviceName);
    }

    public void schedule(String deviceName, String time){
        home.scheduleDevice(deviceName, time);
    }





}
