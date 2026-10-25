package myphone.power;

import myphone.model.Battery;

public interface PowerMode {
    void adjust(Battery battery);
    String name();
}
