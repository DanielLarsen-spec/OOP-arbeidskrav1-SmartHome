package myphone.accessory;

public class WiredHeadset extends Headset {
    public WiredHeadset(String model) {
        super(model);
    }

    @Override
    protected void onPlay(String sound) {
        System.out.println("[Wired] " + getModel()
                + " plays " + sound + " through the cable.");
    }
}
