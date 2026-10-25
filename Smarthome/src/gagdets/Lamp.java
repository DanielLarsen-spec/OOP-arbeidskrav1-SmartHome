package Smarthome.src.gagdets;
import Smarthome.src.SmartDevice;
import Smarthome.src.Timer;

public class Lamp extends SmartDevice implements Timer{
    private int brightness;
    private String scheduledTime;
    public Lamp(String name, boolean status, int brightness) {
        super(name, status);
        this.brightness = brightness;
    }
    
    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
    @Override
    public String getTime() {return scheduledTime;}

    @Override
    public void setTime(String time) {scheduledTime = time;}

    @Override
    public void displayInfo() {
        System.out.println("Lampe: " + name);
        System.out.println("Status: " + (status ? "på" : "Av"));
        System.out.println("Lysstyrke: " + brightness);
        System.out.println("Planlagt på tid: " + (scheduledTime != null ? scheduledTime : "Ikke planlagt"));
    }
}
