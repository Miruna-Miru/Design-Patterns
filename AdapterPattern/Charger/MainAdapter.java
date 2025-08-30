package AdapterPattern.Charger;

// Existing devices with different plug types
class USBACable {
    public void chargeWithUSBA() {
        System.out.println("Charging with USB-A");
    }
}

class USBCCable {
    public void chargeWithUSBC() {
        System.out.println("Charging with USB-C");
    }
}

class LightningCable {
    public void chargeWithLightning() {
        System.out.println("Charging with Lightning");
    }
}

// Target interface
interface Charger {
    void chargeDevice();
}

// Adapters
class USBAAdapter implements Charger {
    private USBACable usbA;
    public USBAAdapter(USBACable usbA) { this.usbA = usbA; }
    public void chargeDevice() { usbA.chargeWithUSBA(); }
}

class USBCAdapter implements Charger {
    private USBCCable usbC;
    public USBCAdapter(USBCCable usbC) { this.usbC = usbC; }
    public void chargeDevice() { usbC.chargeWithUSBC(); }
}

class LightningAdapter implements Charger {
    private LightningCable lightning;
    public LightningAdapter(LightningCable lightning) { this.lightning = lightning; }
    public void chargeDevice() { lightning.chargeWithLightning(); }
}

// Test
public class MainAdapter {
    public static void main(String[] args) {
        Charger chargerA = new USBAAdapter(new USBACable());
        Charger chargerC = new USBCAdapter(new USBCCable());
        Charger chargerL = new LightningAdapter(new LightningCable());

        chargerA.chargeDevice();
        chargerC.chargeDevice();
        chargerL.chargeDevice();
    }
}
