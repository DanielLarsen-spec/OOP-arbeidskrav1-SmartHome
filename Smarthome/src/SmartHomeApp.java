package Smarthome.src;
import myphone.app.general.App;
import Smarthome.src.gagdets.Lamp;
import Smarthome.src.gagdets.Thermostat;


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

    public void setBrightness(String deviceName, int brightness){
        SmartDevice d = home.findDevice(deviceName);
        if(d instanceof Lamp lamp) {
            lamp.setBrightness(brightness);
        } else {
            System.out.println(deviceName + " Er ikke en lampe");
        }
    }

    public void setTemperature(String deviceName, double temperature) {
        SmartDevice d = home.findDevice(deviceName);
        if(d instanceof Thermostat thermostat) {
            thermostat.setTemperature(temperature);
        } else{
            System.out.println(deviceName + "Er ikke en termostat");
        }
    }



}
