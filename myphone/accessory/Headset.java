package myphone.accessory;

public abstract class Headset extends AudioDevice {
    private boolean connected;

    public Headset(String model) {
        super(model);
        this.connected = false;
    }

    @Override
    public void connect() {
        connected = true;
        System.out.println(getModel() + " connected.");
    }

    @Override
    public void disconnect() {
        connected = false;
        System.out.println(getModel() + " disconnected.");
    }

    public boolean isConnected() {
        return connected;
    }
}
