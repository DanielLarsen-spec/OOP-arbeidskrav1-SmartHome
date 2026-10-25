package myphone.accessory;

public class BluetoothHeadset extends Headset {
    private int batteryLevel;

    public BluetoothHeadset(String model, int batteryLevel) {
        super(model);
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    protected void onPlay(String sound) {
        System.out.println("[Bluetooth] " + getModel()
                + " streams " + sound + " wirelessly (battery "
                + batteryLevel + "%).");
    }
}
