public class DoorLockDevice extends BaseDevice {
    DoorLockDevice(String deviceId, String location){
        super(deviceId, location);
    }
    
    @Override 
    protected void performTurnOn(){
        System.out.println("Locked");
    }

    @Override 
    protected void performTurnOff(){
        System.out.println("Unlocked");
    }

    public boolean isLocked() {
        // Where we consider on to be locked. 
        return isOn();
    }
}