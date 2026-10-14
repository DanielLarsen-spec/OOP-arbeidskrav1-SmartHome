package Smarthome.src;

public abstract class SmartDevice {
  protected  String name;
  protected  boolean status;
    

    
    
    public SmartDevice(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public void turnOn() {status = true;}
    public void turnOff() {status = false;}

    public String getName() {return name;}
    public boolean isOn() { return status;}
    
    public abstract void displayInfo();
  }






    
    













    
