package Smarthome.src.gagdets;
import Smarthome.src.SmartDevice;
import Smarthome.src.Timer;


public class Thermostat extends SmartDevice implements Timer {
   private double temperature;
    private String scheduledTime;
    public Thermostat(String name, boolean status, double temperature) {
        super(name, status);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    @Override
    public void setTime(String time) {scheduledTime = time;}

    @Override
    public String getTime() {return scheduledTime;}


    @Override
    public void displayInfo() {
        System.out.println("Termostat: " + name);
        System.out.println("Status: " + (status ? "På" : "Av"));
        System.out.println("Temperatur: " + temperature);
        System.out.println("Planlagt på tid: " + (scheduledTime != null ? scheduledTime : "Ikke planlagt"));
    }







}

