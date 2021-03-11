package app.enumm;

enum PowerSwitch {
    ON("켜짐",true), OFF("꺼짐",false);

    private String krName;
    private boolean flag;

    private PowerSwitch() {
        //
    }

    private PowerSwitch(String krName, boolean flag) {
        this.krName = krName;
        this.flag = flag;
    }

    public String getKrName() {
        return krName;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(String krName) {
        this.krName = krName;
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
        displayByPowerSwitch(powerSwitch);
        displayByPowerSwitch(powerSwitch.opposite());

    }

    private static void displayByPowerSwitch(PowerSwitch powerSwitch) {
        if (powerSwitch == PowerSwitch.ON) {
            System.out.println("Power On");
            System.out.println(powerSwitch.getKrName());
            System.out.println(powerSwitch.getFlag());
        } else {
            System.out.println("Power Off");
            System.out.println(powerSwitch.getKrName());
            System.out.println(powerSwitch.getFlag());
        }
    }
}