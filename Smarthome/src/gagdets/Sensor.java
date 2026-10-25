package Smarthome.src.gagdets;
import Smarthome.src.SmartDevice;

public class Sensor extends SmartDevice {
   private boolean movementDetected;

    public Sensor(String name, boolean status, boolean movementDetected) {
        super(name, status);
        this.movementDetected = movementDetected;
    }

    public void detectMovement() {
        if(status) {movementDetected = true;}
    }

    public void clearMovement() {movementDetected = false;}

    public boolean isMovementDetected() {
        return movementDetected;
    }


    @Override
    public void displayInfo() {
        System.out.println("Bevegelsessensor: " + name);
        System.out.println("Status: " + (status ? "på" : "Av"));
        System.out.println("Bevegelse: " + (movementDetected ? "Registrert" : "Ingen bevegelse"));
    }













}
