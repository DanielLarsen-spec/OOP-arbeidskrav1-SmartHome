package myphone.app;

import java.util.ArrayList;
import myphone.app.general.App;

public class CallApp extends App {
    private ArrayList<CallRecord> callHistory;

    public CallApp(String version) {
        super("Call", version);
        callHistory = new ArrayList<>();
    }

    @Override
    public void run() {
        System.out.println("Call app is ready to make calls.");
    }

    public void makeCall(String phoneNumber, int duration) {
        CallRecord record = new CallRecord(phoneNumber, duration);
        callHistory.add(record);
    }

    public void printCallHistory() {
        System.out.println("Calls: " + callHistory.size());
        for (CallRecord record : callHistory) {
            record.displayInfo();
        }
    }
}
