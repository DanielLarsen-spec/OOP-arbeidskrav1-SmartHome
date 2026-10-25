package myphone.power;

import myphone.model.Battery;

public class PerformanceMode implements PowerMode {
    @Override
    public void adjust(Battery battery) {
        battery.consume(10);
    }

    @Override
    public String name() {
        return "Performance";
    }
}
