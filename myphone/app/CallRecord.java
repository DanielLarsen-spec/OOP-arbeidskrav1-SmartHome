package myphone.app;

class CallRecord {
    private String phoneNumber;
    private int duration;

    CallRecord(String phoneNumber, int duration) {
        this.phoneNumber = phoneNumber;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println(phoneNumber + " - " + duration + " minutes");
    }
}
