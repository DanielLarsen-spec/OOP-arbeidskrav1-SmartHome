package myphone.accessory;

public class Charger implements Connectable {
    private int watt;
    private boolean connected;

    public Charger(int watt) {
        this.watt = watt;
        this.connected = false;
    }

    public int getWatt() {
        return watt;
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println(watt + "W charger connected.");
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println(watt + "W charger disconnected.");
    }

    public boolean isConnected() {
        return connected;
    }
}
