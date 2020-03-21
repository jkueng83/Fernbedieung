package at.jk.cc.fernbedienung;

import java.util.ArrayList;
import java.util.List;

public class Remote {
    String brand;
    String type;
    String serialNumber;

    boolean isOn;
    boolean hasPower;
    List<Battery> batteries;

    public Remote(String brand, String type, String serialNumber) {
        this.brand = brand;
        this.type = type;
        this.serialNumber = serialNumber;
        this.batteries = new ArrayList<>();
    }

    public void addBatterie(Battery battery) {
        this.batteries.add(battery);
    }

    public List<Battery> getBatteries() {
        return batteries;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("is on");
        batteriesUse(1);
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("is off");
        batteriesUse(1);
    }

    private void batteriesUse(int use) {
        for (int i = 0; i < this.batteries.size(); i++) {
            if (this.batteries.get(i).getChargingStatus(false) > 0) {
                this.batteries.get(i).batteryUse(1);
                this.batteries.get(i).getChargingStatus(true);
                break;
            }

        }
    }

    public void getStatus() {
        System.out.println("___________________________");
        System.out.println("####  Print Status  ####");
        System.out.println("Hersteller: " + this.brand + " Type: " + this.type);
        if (this.isOn) {
            System.out.println("Status: ON");
        } else {
            System.out.println("Status: OFF");
        }

        System.out.println("Batterie Ladestatus: " + getBatteryChargingStatus());

    }

    public int getBatteryChargingStatus() {

        int batteriesChargingStatus = 0;

        for (int i = 0; i < this.batteries.size(); i++) {
            batteriesChargingStatus = batteriesChargingStatus + this.batteries.get(i).getChargingStatus(false);
        }
        return batteriesChargingStatus; // 12; // batteriesChargingStatus;

    }
}
