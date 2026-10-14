package Smarthome.src.gagdets;
import Smarthome.src.SmartDevice;


public class Thermostat extends SmartDevice {
   private double temperature;
    
    public Thermostat(String name, boolean status, double temperature) {
        super(name, status);
        this.temperature = temperature;
    }

    public void isOn() {
        this.status = true;
    }

    public void isOff() {
        this.status = false;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void displayInfo() {
        System.out.println("Termostat: " + name);
        System.out.println("Status: " + (status ? "På" : "Av"));
        System.out.println("Temperatur: " + temperature);
    }







}

