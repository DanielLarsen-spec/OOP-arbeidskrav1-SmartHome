package myphone.power;

import myphone.model.Battery;

public class EcoMode implements PowerMode {
    @Override
    public void adjust(Battery battery) {
        battery.consume(2);
    }

    @Override
    public String name() {
        return "Eco";
    }
}
