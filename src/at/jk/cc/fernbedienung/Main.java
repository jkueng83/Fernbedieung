package at.jk.cc.fernbedienung;

//import java.rmi.Remote;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fernbedieung");


        Battery battery1 = new Battery(100);
        Battery battery2 = new Battery(100);

        Remote remote1 = new Remote("Samsung", "abc1", "1964");

        remote1.getStatus();

        Remote remote4 = new Remote("Sony", "remote 123", "1450");

        remote4.addBatterie(battery1);
        remote4.getStatus();

        remote4.addBatterie(battery2);
        remote4.getStatus();

        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                remote4.turnOn();
            } else {
                remote4.turnOff();
            }
        }
        remote4.getStatus();

        for (int i = 0; i < 60; i++) {
            if (i % 2 == 0) {
                remote4.turnOn();
            } else {
                remote4.turnOff();
            }
        }
        remote4.getStatus();

        Battery powerBattery = new Battery(234); // Neue Batterie einbauen
        remote4.addBatterie(powerBattery);
        remote4.getStatus();

        for (int i = 0; i < 114; i++) {
            if (i % 2 == 0) {
                remote4.turnOn();
            } else {
                remote4.turnOff();
            }
        }
        remote4.getStatus();


    }
}
