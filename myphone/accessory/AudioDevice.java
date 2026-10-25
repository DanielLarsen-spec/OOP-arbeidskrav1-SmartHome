package myphone.accessory;

public abstract class AudioDevice implements Connectable {
    private String model;

    public AudioDevice(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public final void play(String sound) {
        onPlay(sound);
    }

    protected abstract void onPlay(String sound);
}
