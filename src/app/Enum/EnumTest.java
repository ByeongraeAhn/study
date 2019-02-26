package app.Enum;

enum PowerSwitch {
    //
    ON("켜짐"), OFF("꺼짐");

    private String krName;

    private PowerSwitch() {
        //
    }

    private PowerSwitch(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }

    public PowerSwitch opposite() {
        //
        if (this == PowerSwitch.ON) {
            return PowerSwitch.OFF;
        } else {
            return PowerSwitch.ON;
        }
    }
}

public class EnumTest {
    public static void main(String[] args) {
        PowerSwitch powerSwitch = PowerSwitch.ON;
        displayByPowerSwitch(powerSwitch.opposite());
    }

    public static void displayByPowerSwitch(PowerSwitch powerSwitch) {
        if (powerSwitch == PowerSwitch.ON) {
            System.out.println("Power On");
        } else {
            System.out.println("Power Off");
        }
    }
}