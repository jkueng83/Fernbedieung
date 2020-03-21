package at.jk.cc.fernbedienung;

public class Battery {
    private int chargingStatus = 100;

    public Battery(int chargingStatus) {
        this.chargingStatus = chargingStatus;
    }

    public int getChargingStatus(boolean printStatus) {
        if (printStatus) {
            System.out.println("charging status is of this Battery is: " + this.chargingStatus);
        }
        return this.chargingStatus;
    }

    public void batteryUse(int use) {
        this.chargingStatus = this.chargingStatus - use;
        if (this.chargingStatus < 0) {
            this.chargingStatus = 0;
        }
        boolean isEmpty = isBatteryEmpty();

    }

    public boolean isBatteryEmpty() {
        boolean isEmpty = false;
        if (this.chargingStatus <= 0) {
            System.out.println("Battery is empty!");
            isEmpty = true;
        }

        return isEmpty;
    }

}
