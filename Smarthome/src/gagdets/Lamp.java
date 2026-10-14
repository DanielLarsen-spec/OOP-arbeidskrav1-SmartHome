package Smarthome.src.gagdets;
import Smarthome.src.SmartDevice;


public class Lamp extends SmartDevice {
    private int brightness;

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

    public void displayInfo() {
        System.out.println("Lampe: " + name);
        System.out.println("Status: " + (status ? "på" : "Av"));
        System.out.println("Lysstyrke: " + brightness);

    }
}
